package com.herokuapp.samkaz.config;

import com.herokuapp.samkaz.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;


/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
@Configuration
@EnableCassandraRepositories
public class CassandraConfig  extends AbstractCassandraConfiguration  {

    private static final Logger log = LoggerFactory.getLogger(CassandraConfig.class);
    @Value("${cassandra.basepackages}")
    private String basePackages;

    @Value("${spring.data.cassandra.keyspace-name}")
    protected String keyspaceName;

    @Value("${spring.data.cassandra.contact-points}")
    protected String cassandraHost;


    @PostConstruct
    public void init() {
        log.info(" cassandraHost :" + cassandraHost );
        log.info(" System.getProperty :" + System.getProperty("CASSANDRA_HOST"));
    }

    @Override
    protected String getKeyspaceName() {
        return this.keyspaceName;
    }

    @Override
    protected List getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(keyspaceName).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication());
    }

    @Override
    protected List getStartupScripts() {
        return Collections.singletonList("CREATE KEYSPACE IF NOT EXISTS "
                + keyspaceName + " WITH replication = {"
                + " 'class': 'SimpleStrategy', "
                + " 'replication_factor': '2' " + "};");

    }

    @Bean
    public CassandraSessionFactoryBean session()  {

        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(keyspaceName);
        session.setConverter(converter());
        session.setStartupScripts(getStartupScripts());
        session.setSchemaAction(getSchemaAction());

        return session;
    }

    @Override
    public String getContactPoints() {

        return cassandraHost;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }

    @Bean
    public CassandraConverter converter()  {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraMappingContext mappingContext()  {
        CassandraMappingContext bean = new CassandraMappingContext();
        try {
            bean.setInitialEntitySet(CassandraEntityClassScanner.scan(("com.herokuapp.samkaz.model")));
        } catch (ClassNotFoundException e) {
            throw new SystemException(" error at mappingContext : ", e);
        }
        return bean;
    }


}

/*
@Configuration
@SuppressWarnings("unused")
class CassandraConfiguration extends AbstractSessionConfiguration {

    @Autowired
    Environment env;

    @Override
    protected String getContactPoints() {
        return env.getProperty("cassandra.cluster.contact-points");
    }

    @Override
    protected String getKeyspaceName() {
        return env.getProperty("spring.data.cassandra.keyspace-name");
    }

    @Override
    protected int getPort() {
        return env.getProperty("cassandra.cluster.port", Integer.TYPE);
    }

}*/

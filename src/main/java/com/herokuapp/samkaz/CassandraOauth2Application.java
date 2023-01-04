package com.herokuapp.samkaz;

import com.datastax.driver.core.utils.UUIDs;
import com.herokuapp.samkaz.model.Client;
import com.herokuapp.samkaz.model.Role;
import com.herokuapp.samkaz.model.User;
import com.herokuapp.samkaz.repository.ClientRepository;
import com.herokuapp.samkaz.repository.RoleRepository;
import com.herokuapp.samkaz.repository.UserRepository;
import com.herokuapp.samkaz.util.AuthHelper;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableCassandraRepositories(basePackages = "com.herokuapp.samkaz")
public class CassandraOauth2Application {

	private static final Logger log = LoggerFactory.getLogger(CassandraOauth2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(CassandraOauth2Application.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthHelper authHelper;

	@Bean
	public AuthenticationKeyGenerator getAuthenticationKeyGenerator() {
		return new DefaultAuthenticationKeyGenerator();
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		List<String> mappingFiles = Arrays.asList(
				"dozer-configration-mapping.xml"
		);

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

	@Bean
	InitializingBean sendDatabase() {


		return () -> {
			String hashedPassword = authHelper.generateBCryptPassword("secret");
			Client client = clientRepository.findByClientId(UUID.fromString("d6a37d82-ce4e-49b9-a1f8-2c55f2567dce"));
			if(client == null) {
				client = new Client();
				client.setAccessTokenValiditySeconds(2592000);
				client.setRefreshTokenValiditySeconds(2592000 * 30);
				client.setClientId(UUID.fromString("d6a37d82-ce4e-49b9-a1f8-2c55f2567dce"));
				client.setClientSecret(hashedPassword);
				client.getScope().add("trust");
				client.getAuthorizedGrantTypes().add("password");
				client.getAuthorizedGrantTypes().add("refresh_token");
				clientRepository.save(client);


				Role role = new Role();
				role.setId(UUIDs.timeBased());
				role.setRoleName("ROLE_USER");
				roleRepository.save(role);

				role = new Role();
				role.setId(UUIDs.timeBased());
				role.setRoleName("ROLE_ADMIN");
				roleRepository.save(role);

				role = new Role();
				role.setId(UUIDs.timeBased());
				role.setRoleName("ROLE_SUPER_ADMIN");
				roleRepository.save(role);

				User user = new User();
				user.setUserId(UUIDs.timeBased());
				user.setRoles(Arrays.asList(role.getRoleName()));
				user.setEmailAddress("samkaz@gmail.com");
				user.setActive(true);
				user.setFullName("syed Kazmi");
				user.setUserName("syed");
				user.setPhoneNumber("+923100000000");
				// password is  `secert`
				user.setPassword(hashedPassword);
				userRepository.save(user);
				user = userRepository.findByUserName("syed");
				user.getRoles();
			}
		};
	}

}
package com.herokuapp.samkaz.repository;


import com.herokuapp.samkaz.model.Client;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public interface ClientRepository extends CassandraRepository<Client, UUID> {


    Client findByClientId(UUID clientId);

}

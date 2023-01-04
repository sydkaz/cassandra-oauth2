package com.herokuapp.samkaz.service;

import com.herokuapp.samkaz.model.Client;
import com.herokuapp.samkaz.repository.ClientRepository;
import com.herokuapp.samkaz.security.CassandraClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private ClientRepository clientRepository;

    public ClientDetailsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client =  clientRepository.findByClientId(UUID.fromString(clientId));
        if(client != null) {
            ClientDetails clientDetails = new CassandraClientDetails(client);
            return clientDetails;
        } else {
            return null;
        }
    }
}

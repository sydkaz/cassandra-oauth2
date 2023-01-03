package com.herokuapp.samkaz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "client")
public class Client {

    @PrimaryKey
    protected UUID clientId;
    protected String clientSecret;
    protected String clientName;

    protected Set<String> scope = new HashSet<String>();
    protected Set<String> resourceIds = new HashSet<String>();
    protected Set<String> authorizedGrantTypes = new HashSet<String>();
    protected Set<String> registeredRedirectUris  = new HashSet<String>();
    // JSON GrantedAuthority
    protected List<String> authorities;
    protected Integer accessTokenValiditySeconds = 21600;
    protected Integer refreshTokenValiditySeconds = 2592000;
    // JSON Map<String, Object>
    protected String additionalInformation;
    protected Set<String> autoApproveScopes;




}

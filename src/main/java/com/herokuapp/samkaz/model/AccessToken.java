package com.herokuapp.samkaz.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.nio.ByteBuffer;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Table(value = "access_token")
@Data
public class AccessToken {

    @PrimaryKey
    private String tokenId;

    private ByteBuffer token;

    private String authenticationId;

    private String username;

    private String clientId;

    private ByteBuffer authentication;

    private String refreshToken;

}

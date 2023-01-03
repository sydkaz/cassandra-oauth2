package com.herokuapp.samkaz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.nio.ByteBuffer;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value =  "refresh_token")
public class RefreshToken {

    @PrimaryKey
    private String tokenId;

    private ByteBuffer token;

    private ByteBuffer authentication;


}

package com.herokuapp.samkaz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@Table(value = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User  {

  private static final long serialVersionUID = -3392490659474682931L;

  @PrimaryKey
  private UUID userId;

  private String userName;

  private String emailAddress;

  private String fullName;


  private String profileImage;


  private String password;

  private Boolean active = Boolean.FALSE;

  private String phoneNumber;

  private List<String> roles =new ArrayList<>();

}

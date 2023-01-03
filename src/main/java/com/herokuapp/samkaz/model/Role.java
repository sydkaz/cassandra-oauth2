package com.herokuapp.samkaz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@Table(value = "role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role  {
  private static final long serialVersionUID = -1077836392559104967L;

  @PrimaryKey
  private UUID id;

  private String roleName;
}

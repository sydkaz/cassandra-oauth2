package com.herokuapp.samkaz.dto;

import com.herokuapp.samkaz.util.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

  private static final long serialVersionUID = 8414024608947196037L;

  private Meta status;

  private String message;

  private T data;


}

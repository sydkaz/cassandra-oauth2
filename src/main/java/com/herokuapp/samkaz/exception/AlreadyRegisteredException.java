package com.herokuapp.samkaz.exception;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class AlreadyRegisteredException extends SystemException {
  private static final long serialVersionUID = 12112526L;

  public AlreadyRegisteredException(String message) {
    super(message);
  }
  public AlreadyRegisteredException(String message, Throwable exception) {
    super(message, exception);
  }
}

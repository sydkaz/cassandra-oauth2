package com.herokuapp.samkaz.exception;


/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class AlreadyUsedException extends SystemException {
  private static final long serialVersionUID = 12112526L;

  public AlreadyUsedException(final String exception) {
    super(exception);
  }

  public AlreadyUsedException(String message, Throwable exception) {
    super(message, exception);
  }
}

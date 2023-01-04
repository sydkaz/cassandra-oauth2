package com.herokuapp.samkaz.exception;
/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class NotRegisteredException extends SystemException {
  public NotRegisteredException(String message, Throwable exception) {
    super(message, exception);

  }

  public NotRegisteredException(String exception) {
    super(exception);
  }

}

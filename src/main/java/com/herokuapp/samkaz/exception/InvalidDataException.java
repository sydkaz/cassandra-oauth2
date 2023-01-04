/*
 * Copyright (C) 2016 Ten Hawks, All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class InvalidDataException extends SystemException {

	private static final long serialVersionUID = -3176392501022469536L;
	public InvalidDataException(String message, Throwable exception) {
		super(message, exception);
		
	}
	public InvalidDataException(String message) {
		super(message);
		
	}

}

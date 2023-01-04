/*
 * Copyright (C) 2016 Ten Hawks, All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;
/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class InvalidEmailFormatException extends SystemException {
	private static final long serialVersionUID = -1223704093843950795L;

	public InvalidEmailFormatException(String message, Throwable exception) {
		super(message, exception);
	}

	public InvalidEmailFormatException(String message) {
		super(message);

	}
}

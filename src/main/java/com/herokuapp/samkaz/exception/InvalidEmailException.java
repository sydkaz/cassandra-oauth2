/*
 * Copyright (C) 2016 Ten Hawks, All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;
/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class InvalidEmailException extends SystemException {
	private static final long serialVersionUID = -1223704093843950795L;
	public InvalidEmailException(String message, Throwable exception) {
		super(message, exception);
		
	}

	public InvalidEmailException(String message) {
		super(message);
		
	}

}

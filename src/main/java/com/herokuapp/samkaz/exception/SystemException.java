/*
 * Copyright (C) 2016 Beaver Technologies., All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 12112526L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}

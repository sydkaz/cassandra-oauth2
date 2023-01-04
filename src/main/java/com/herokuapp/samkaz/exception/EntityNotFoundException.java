/*
 * Copyright (C) 2016 Beaver Technologies., All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class EntityNotFoundException extends SystemException {

	private static final long serialVersionUID = 1L;
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

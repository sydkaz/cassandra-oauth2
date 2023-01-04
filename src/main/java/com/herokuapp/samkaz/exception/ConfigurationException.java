/*
 * Copyright (C) 2016 Beaver Technologies., All Rights Reserved.
 */
package com.herokuapp.samkaz.exception;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class ConfigurationException extends SystemException {
	private static final long serialVersionUID = -152203116611411058L;
    public ConfigurationException(String message) {
        super(message);
    }
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}

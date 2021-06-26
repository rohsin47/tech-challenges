/*
* Copyright (C) 2020 BlackRock.
*
* Created on Jan 13, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.cs.app.exception;

/**
 * @author rohsingh
 *
 */
public class CommandNotValidException extends Exception {
    
    private static final long serialVersionUID = 8826160261546881926L;

    public CommandNotValidException(String string) {
        super(string);
    }
    
    public CommandNotValidException(String string, Throwable e) {
        super(string, e);
    }

}

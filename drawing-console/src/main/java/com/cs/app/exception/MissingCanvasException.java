package com.cs.app.exception;

/**
 * @author rohsingh
 *
 */
public class MissingCanvasException extends Exception {

    private static final long serialVersionUID = 31587236708555034L;
    
    public MissingCanvasException(String string) {
        super(string);
    }
    
    public MissingCanvasException(String string, Throwable e) {
        super(string, e);
    }

}

/**
 * 
 */
package com.revolut.moneytransfer.exception;

/**
 * @author rohsi
 *
 */
public class ObjectModificationException extends Exception {
    
	private static final long serialVersionUID = 1L;
	
	private ExceptionType type;

    public ObjectModificationException(ExceptionType exceptionType, Throwable cause) {
        super(exceptionType.getMessage(), cause);
        type = exceptionType;
    }

    public ObjectModificationException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        type = exceptionType;
    }

    public ObjectModificationException(ExceptionType exceptionType, String message) {
        super(exceptionType.getMessage() + ": " + message);
        type = exceptionType;
    }

    public ExceptionType getType() {
        return type;
    }
}

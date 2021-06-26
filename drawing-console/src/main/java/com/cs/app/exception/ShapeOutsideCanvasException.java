/**
 * 
 */
package com.cs.app.exception;

/**
 * @author rohsi
 *
 */
public class ShapeOutsideCanvasException extends Exception {

	private static final long serialVersionUID = 3450758938796322313L;

	public ShapeOutsideCanvasException(String string) {
        super(string);
    }
    
    public ShapeOutsideCanvasException(String string, Throwable e) {
        super(string, e);
    }
}

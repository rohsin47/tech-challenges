package com.crypto.app.model;

/**
 * @author rohsingh
 *
 */
public class Portfolio {
    
    public double stockPosition;
    public double callPosition;
    public double putPosition;
    
    public double getNAV() {
        return stockPosition + callPosition + putPosition;
    }

}

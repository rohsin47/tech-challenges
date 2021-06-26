/**
 * 
 */
package com.crypto.app.model;

/**
 * @author rohsi
 *
 */
public class Price {

    private String asset;
    private double stock;
    private double call;
    private double put;

    public Price(String asset, double stock, double call, double put) {
        super();
        this.asset = asset;
        this.stock = stock;
        this.call = call;
        this.put = put;
    }

    public String getAsset() {
        return asset;
    }

    public Price setAsset(String asset) {
        this.asset = asset;
        return this;
    }

    public double getStock() {
        return stock;
    }

    public Price setStock(double stock) {
        this.stock = stock;
        return this;
    }

    public double getCall() {
        return call;
    }

    public Price setCall(double call) {
        this.call = call;
        return this;
    }

    public double getPut() {
        return put;
    }

    public Price setPut(double put) {
        this.put = put;
        return this;
    }

}

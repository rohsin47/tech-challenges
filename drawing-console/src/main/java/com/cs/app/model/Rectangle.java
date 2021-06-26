package com.cs.app.model;

/**
 * @author rohsingh
 *
 */
public class Rectangle implements Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    private ICanvas canvas;

    public Rectangle(int x, int y, int width, int height) {
        if ((x == width && y > height) || (y == height && x > width)) {
            setRectangle(width, height, x, y);
        } else {
            setRectangle(x, y, width, height);
        }
    }

    public void setRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean validate() {
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ICanvas getCanvas() {
        return canvas;
    }

}

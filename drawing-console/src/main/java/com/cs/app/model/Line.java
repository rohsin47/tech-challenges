package com.cs.app.model;

/**
 * @author rohsingh
 *
 */
public class Line implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        if ((this.x1 == this.x2 && this.y1 > this.y2) || (this.y1 == this.y2 && this.x1 > this.x2)) {
            setLine(x2, y2, x1, y1);
        } else {
            setLine(x1, y1, x2, y2);
        }
    }

    public void setLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean validate() {
        return (x1 >= 0 && y1 >= 0 && y2 >= 0 && x2 >= 0) && (x1 != x2 && y1 != y2)
                || (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Line line = (Line) o;

        if (x1 != line.x1)
            return false;
        if (y1 != line.y1)
            return false;
        if (x2 != line.x2)
            return false;
        return y2 == line.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }

}

/**
 * 
 */
package com.cs.app.processor;

import java.util.Stack;

import com.cs.app.exception.ShapeOutsideCanvasException;
import com.cs.app.model.Bucket;
import com.cs.app.model.Line;
import com.cs.app.model.Point;
import com.cs.app.model.Rectangle;
import com.cs.app.util.ConsoleConstants;

/**
 * @author rohsi
 *
 */
public class CanvasProcessor {
	
	private int width;
    private int height;
    private String[][] body;  
    
    public void addBucketFill(Bucket bucket) throws ShapeOutsideCanvasException {
        if (isOutOfCanvas(bucket.getX(), bucket.getY())) {
            throw new ShapeOutsideCanvasException("Bucket fill point is outside of canvas");
        }
        fillBucket(bucket.getX(), bucket.getY(), bucket.getFillColor());
    }

    public void addRectangle(Rectangle rec) throws ShapeOutsideCanvasException {
        if (isOutOfCanvas(rec.getX(), rec.getY())) {
            throw new ShapeOutsideCanvasException("Rectangle is outside of canvas");
        }
        drawRectangle(rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight());
    }

    public void addLine(Line line) throws ShapeOutsideCanvasException {
        if (isOutOfCanvas(line.getX1(), line.getY1())) {
            throw new ShapeOutsideCanvasException("Line is outside of canvas");
        }
        if (line.getX2() >= width) {
            line.setX2(width);
        }
        if (line.getY2() >= height) {
            line.setY2(height);
        }
        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }
    
    private void drawLine(int x1, int y1, int x2, int y2) {
        //each
        for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
            //col
            for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
                body[row][col] = ConsoleConstants.LINE_ONLY;
            }
        }
    }

    private void fillBucket(int x, int y, String color) {
        String originalChar = body[y - 1][x - 1];
        String colr = color;
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(y - 1, x - 1));

        while (!stack.isEmpty()) {
            Point pop = stack.pop();
            if (body[pop.getX()][pop.getY()] == originalChar) {
                body[pop.getX()][pop.getY()] = colr;
            }
            if (pop.getX() - 1 >= 0 && body[pop.getX() - 1][pop.getY()] == originalChar) {
                stack.add(new Point(pop.getX() - 1, pop.getY()));
            }
            if (pop.getX() + 1 < height && body[pop.getX() + 1][pop.getY()] == originalChar) {
                stack.add(new Point(pop.getX() + 1, pop.getY()));
            }
            if (pop.getY() - 1 >= 0 && body[pop.getX()][pop.getY() - 1] == originalChar) {
                stack.add(new Point(pop.getX(), pop.getY() - 1));
            }
            if (pop.getY() + 1 < width && body[pop.getX()][pop.getY() + 1] == originalChar) {
                stack.add(new Point(pop.getX(), pop.getY() + 1));
            }
        }
    }
    
    private void drawRectangle(int x1, int y1, int x2, int y2) {
        //top edge
        drawLine(x1, y1, x2, y1);
        //right edge
        drawLine(x1, y1, x1, y2);
        //bottom edge
        drawLine(x2, y1, x2, y2);
        //right edge
        drawLine(x1, y2, x2, y2);
    }
    
    protected boolean isOutOfCanvas(int x, int y) {
        return x < 1 || x >= width || y < 1 || y >= height;
    }

	public int getWidth() {
		return width;
	}

	public CanvasProcessor setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public CanvasProcessor setHeight(int height) {
		this.height = height;
		return this;
	}

	public String[][] getBody() {
		return body;
	}

	public CanvasProcessor setBody(String[][] body) {
		this.body = body;
		return this;
	}

}

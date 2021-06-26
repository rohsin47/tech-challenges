package com.cs.app.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.cs.app.exception.ShapeOutsideCanvasException;
import com.cs.app.processor.CanvasProcessor;
import com.cs.app.util.ConsoleConstants;

/**
 * @author rohsingh
 *
 */
public class Canvas implements ICanvas {

    private int width;
    private int height;
    private String[][] body;
    
    private List<Shape> shapes;
    
    private CanvasProcessor canvasProcessor;

    public Canvas(int width, int height) {
        this.width = width;   
        this.height = height;  
        this.body = new String[height][width];       
        this.shapes = new LinkedList<>();
        
        this.canvasProcessor = new CanvasProcessor()
                            .setHeight(height)
                            .setWidth(width)
                            .setBody(body);
             
        Arrays.stream(body).forEach(chars -> Arrays.fill(chars, " "));
    }
    
    @Override
    public String display() {
        final StringBuilder builder = new StringBuilder();

        // top
        StringBuilder horizontal = new StringBuilder();
        for (int i = 0; i < width+2; i++) {
            horizontal.append(ConsoleConstants.HORIZONTAL_LINE);
        }
        builder.append(horizontal.toString()).append("\n");

        // side verticals
        for (int i = 0; i < this.height; i++) {
            builder.append(ConsoleConstants.VERTICAL_LINE);
            for (int j = 0; j < this.width; j++) {
                builder.append(body[i][j]);
            }
            builder.append(ConsoleConstants.VERTICAL_LINE);
            builder.append("\n");
        }

        // bottom
        builder.append(horizontal.toString());

        // final canvas
        return builder.toString();
    }
    
    @Override
    public void addShape(Shape shape) throws ShapeOutsideCanvasException {
        shapes.add(shape);
        if (shape instanceof Line) {
        	canvasProcessor.addLine((Line) shape);
        }else if (shape instanceof Rectangle) {
        	canvasProcessor.addRectangle((Rectangle) shape);
        }else if (shape instanceof Bucket) {
        	canvasProcessor.addBucketFill((Bucket) shape);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBody() {
        return body;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

	public CanvasProcessor getCanvasProcessor() {
		return canvasProcessor;
	}

	public void setCanvasProcessor(CanvasProcessor canvasProcessor) {
		this.canvasProcessor = canvasProcessor;
	}

}

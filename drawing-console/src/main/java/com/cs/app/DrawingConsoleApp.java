package com.cs.app;

import java.util.Scanner;

import com.cs.app.processor.CommandProcessor;

/**
 * @author rohsingh
 *
 */
public class DrawingConsoleApp {

    private DrawingConsoleApp() {
    }

    public static void main(String[] args) {
        help();
        CommandProcessor processor = new CommandProcessor();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("enter command :");
                processor.processCommand(sc.nextLine());
            }
        } catch (Exception e) {
        	System.err.println("An unexpected exception happened while procesing command.");
        	System.exit(0);
        }
    }

    private static void help() {
        String help = "The work as follows:\n"
                + "1. Create a new canvas \n"
                + "2. Draw on the canvas by issuing various commands \n"
                + "3. Quit \n\n\n"
                + "|Command         |Description|\n"
                + "|----|----|\n"
                + "|C w h          | Create a new canvas of width w and height h.|\n"
                + "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\n"
                + "|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\n"
                + "|               | will be drawn using the 'x' character.|\n"
                + "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\n"
                + "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\n"
                + "|               | using the 'x' character.|\n"
                + "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\n"
                + "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\n"
                + "|               | programs.|\n"
                + "|Q              | Quit|\n";
        System.out.println(help);
    }


}

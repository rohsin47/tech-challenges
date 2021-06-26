/*
* Copyright (C) 2020 BlackRock.
*
* Created on Jan 13, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.cs.app.model;

import com.cs.app.util.ConsoleConstants;

/**
 * @author rohsingh
 *
 */
public interface Shape {

    default void clear() {
        try {
            if (ConsoleConstants.OS.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    boolean validate();

}

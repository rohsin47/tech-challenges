package com.cs.app.factory;

/**
 * @author rohsingh
 *
 */
public enum CommandType {
    
    CANVAS("C"),
    LINE("L"), 
    RECTANGLE("R"),
    FILL("B"),
    QUIT("Q");

    private String command;
    
    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }


    public static CommandType resolveCommand(String command) {
        for (CommandType v : CommandType.values()) {
            if (v.getCommand().equals(command)) {
                return v;
            }
        }

        return null;
    }

}

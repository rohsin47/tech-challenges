package com.cs.app.command.context;

import java.util.ArrayList;
import java.util.List;

import com.cs.app.factory.CommandType;

/**
 * @author rohsingh
 *
 */
public class CommandContext {
    
    private CommandType command;
    private List<String> params;
    
    public CommandContext(String input) {
    	 String[] tokens = input.split(" ");
         this.command = CommandType.resolveCommand(tokens[0].toUpperCase());
         this.params = new ArrayList<>();
         for (int i = 1; i < tokens.length; i++) {
             this.params.add(tokens[i]);
         }
    }
    
    public CommandType getCommand() {
        return command;
    }
    
    public List<String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "CommandInput [command=" + command + ", params=" + params + "]";
    }

}

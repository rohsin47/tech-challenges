package com.cs.app.processor;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.command.DrawLineCommand;
import com.cs.app.command.context.CanvasCommand;
import com.cs.app.command.context.Command;
import com.cs.app.command.context.CommandContext;
import com.cs.app.factory.CanvasFactory;
import com.cs.app.factory.CommandFactory;
import com.cs.app.factory.ShapeFactory;
import com.cs.app.model.Canvas;
import com.cs.app.model.Shape;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandProcessorTest {

    @Mock
    private Canvas canvas;

    @Mock
    private CanvasFactory canvasFactory;

    @Mock
    private CommandContext commandCtx;

    @Mock
    private CommandFactory commandFactory;

    @Mock
    private Shape shape;

    @Mock
    private ShapeFactory shapeFactory;

    @InjectMocks
    private CommandProcessor commandProcessor;

    @Test
    public void shouldFailValidation() throws Exception {
        // given
        String input = "C20 4";

        // when
        boolean result = commandProcessor.validateCommand(input);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void shouldFailValidationOnInvalidCommand() throws Exception {
        // given
        String input = "T 20 4";

        // when
        boolean result = commandProcessor.validateCommand(input);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void shouldPassValidation() throws Exception {
        // given
        String input = "C 20 4";
        
        // when
        boolean result = commandProcessor.validateCommand(input);

        // then
        assertThat(result, is(true));
    }

    @Test
    public void shouldProcessCommand() throws Exception {
        Command command = Mockito.mock(Command.class);
        when(commandFactory.getCommand(any(CommandContext.class))).thenReturn(command);
        when(canvasFactory.getCanvas(any(Command.class))).thenReturn(canvas);

        // given
        String input = "C 20 4";
        
        // when
        commandProcessor.processCommand(input);

        // then
        assertThat(commandCtx, is(notNullValue()));
        assertThat(canvas, is(notNullValue()));

        verify(command, times(1)).execute();
    }

    @Test
    public void shouldProcessCanvasCommand() throws Exception {
        CanvasCommand command = Mockito.mock(CanvasCommand.class);
        when(commandFactory.getCommand(any(CommandContext.class))).thenReturn(command);
        when(canvasFactory.getCanvas(any(Command.class))).thenReturn(canvas);

        // given
        String input = "C 20 4";
        
        // when
        commandProcessor.processCommand(input);

        // then
        assertThat(commandCtx, is(notNullValue()));
        assertThat(canvas, is(notNullValue()));

        verify(command, times(1)).execute();
    }

    @Test
    public void shouldProcessShapeCommand() throws Exception {
        DrawLineCommand command = Mockito.mock(DrawLineCommand.class);
        when(commandFactory.getCommand(any(CommandContext.class))).thenReturn(command);
        when(canvasFactory.getCanvas(any(Command.class))).thenReturn(canvas);

        // given
        String input = "L 1 2 6 2";
        
        // when
        commandProcessor.processCommand(input);

        // then
        assertThat(commandCtx, is(notNullValue()));
        assertThat(canvas, is(notNullValue()));

        verify(command, times(1)).execute();
    }

}

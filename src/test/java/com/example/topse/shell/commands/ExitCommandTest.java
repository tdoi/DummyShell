package com.example.topse.shell.commands;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.topse.shell.Shell;
import com.example.topse.shell.commands.ExitCommand;

public class ExitCommandTest {

    ExitCommand command = new ExitCommand();
    Shell shell = mock(Shell.class);

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testHandleExitCommandAndSetFinishedToShell()
    {
        boolean isExecuted = command.execute(shell, "exit", null);
        verify(shell).setFinished(true);

        assertThat(isExecuted, is(true));
    }

    @Test
    public void testDoesNotHandleOtherCommand()
    {
        boolean isExecuted = command.execute(shell, "not_exit", null);

        assertThat(isExecuted, is(false));
    }

}

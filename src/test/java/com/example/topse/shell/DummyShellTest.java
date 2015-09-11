package com.example.topse.shell;

import java.io.ByteArrayInputStream;

import java.io.InputStream;

import org.junit.Test;

import junit.framework.TestCase;

public class DummyShellTest extends TestCase {
	
	DummyShell shell = new DummyShell();

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	@Test
	public void testGetInputReadsInputStream() {
		InputStream stream = new ByteArrayInputStream("java".getBytes());
		shell.setInputStream(stream);
	
		String inputString = shell.getInput();

		assertTrue(inputString.equals("java"));	
	}

	@Test
	public void testGetInputTrimTheExtraSpaces() {
		InputStream stream = new ByteArrayInputStream("  java  ".getBytes());
		shell.setInputStream(stream);
	
		String inputString = shell.getInput();

		assertEquals("java", inputString);	
	}
	
	@Test
	public void testExecuteFinishByExitCommand() {
		assertTrue(shell.executeCommand("exit", null));
		assertTrue(shell.getFinished());
	}

	@Test
	public void testExecuteNotFinishUntilExitCommand() {
		assertFalse(shell.executeCommand("abc", null));
		assertFalse(shell.getFinished());
	}
}

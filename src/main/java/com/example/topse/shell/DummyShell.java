package com.example.topse.shell;

import java.io

.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.example.topse.shell.commands.Command;
import com.example.topse.shell.commands.ExitCommand;

public class DummyShell implements Shell {

	private InputStream inputStream;
	private PrintStream outputStream;
	private List<Command> commandList = new LinkedList<Command>();

	private boolean isFinished;

	public DummyShell() {
		inputStream = System.in;
		outputStream = System.out;

		commandList.add(new ExitCommand());
	}

	public void setInputStream(InputStream stream) {
		this.inputStream = stream;
	}
	public void setOutputStream(PrintStream stream) {
		this.outputStream = stream;
	}

	/* (non-Javadoc)
	 * @see com.example.topse.shell.Shell#execute()
	 */
	@Override
	public void execute() {
		setFinished(false);
		while (!getFinished()) {
			String[] items = parseCommand(getInput());
			String command = items[0];
			String[] args = Arrays.copyOfRange(items, 1, items.length);

			executeCommand(command, args);
		}
	}

	public boolean executeCommand(String inputCommand, String[] args) {
		for (Command command : commandList) {
			try {
				if (command.execute(this,  inputCommand, args)) {
					return true;
				}
			} catch (Exception e) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	@Override
	public boolean getFinished() {
		return this.isFinished;
	}

	public String getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
		String line = "";
		try {
			while (line.isEmpty()) {
				write(" > ");
				line = reader.readLine();
				line = line.trim();
			}
		} catch (IOException e) {
			return null;
		}
		return line;
	}

	@Override
	public void write(String output) {
		outputStream.print(output);
	}

	public String[] parseCommand(String command) {
		return command.split(" ");
	}
}

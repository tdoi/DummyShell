package com.example.topse.shell.commands;

import com.example.topse.shell.Shell;

public class ExitCommand implements Command {

	public boolean execute(Shell shell, String command, String[] args) {
		if ("exit".equals(command)) {
			shell.setFinished(true);
			return true;
		}
		
		return false;
	}
	
}

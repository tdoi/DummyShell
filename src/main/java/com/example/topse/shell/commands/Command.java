package com.example.topse.shell.commands;

import com.example.topse.shell.Shell;

public interface Command {
	public boolean execute(Shell shell, String command, String[] args) throws Exception;
}
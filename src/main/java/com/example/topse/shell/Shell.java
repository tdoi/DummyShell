package com.example.topse.shell;

import java.io.InputStream;
import java.io.PrintStream;

public interface Shell {
		
	public void setInputStream(InputStream stream);
	public void setOutputStream(PrintStream stream);

	public void execute();

	public void setFinished(boolean isFinished);
	public boolean getFinished();
	
	public void write(String output);
}
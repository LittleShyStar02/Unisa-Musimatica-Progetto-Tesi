package it.v1nc3nz0.musimathics;

import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.graphics.frames.MainGUI;

public class Main
{

	public static void main(String[] args)
	{
		ConfigContainer.init();
		MainGUI main = new MainGUI();
		main.setVisible(true);
	}
	
}

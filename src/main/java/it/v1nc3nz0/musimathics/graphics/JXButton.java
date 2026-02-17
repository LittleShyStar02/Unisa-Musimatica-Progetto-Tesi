package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JXButton extends JButton
{

	private static int WIDTH;
	private static int HEIGHT;
	
	private Dimension buttonDimension;
	
	static {
		JXButton.HEIGHT = 30;
		JXButton.WIDTH = 240;
	}
	
	public JXButton(String text)
	{
		buttonDimension = new Dimension(JXButton.WIDTH,JXButton.HEIGHT);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setFont(new Font("Serif",Font.PLAIN,16));
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setSize(buttonDimension);
		setText(text);
	}

}
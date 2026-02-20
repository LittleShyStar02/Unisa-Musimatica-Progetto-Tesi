package it.v1nc3nz0.musimathics.graphics.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JXLabel extends JLabel
{

	private static int WIDTH;
	private static int HEIGHT;
	
	static {
		JXLabel.HEIGHT = 30;
		JXLabel.WIDTH = 250;
	}
	
	private Dimension labelDimension;
	
	public JXLabel(String text)
	{
		super(text);
		
		labelDimension = new Dimension(JXLabel.WIDTH,JXLabel.HEIGHT);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setFont(new Font("Serif",Font.PLAIN,16));
		setMaximumSize(labelDimension);
		setMinimumSize(labelDimension);
		setSize(labelDimension);
		
	}
	
}

package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JXLabel extends JLabel
{

	private Dimension labelDimension;
	
	public JXLabel(int width, int height,String text)
	{
		super(text);
		
		labelDimension = new Dimension(width,height);
		
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setMaximumSize(labelDimension);
		setMinimumSize(labelDimension);
		setSize(labelDimension);
		
	}
	
}

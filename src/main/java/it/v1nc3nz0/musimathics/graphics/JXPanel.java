package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JXPanel extends JPanel
{

	private Dimension panelDimension;
	
	public JXPanel(int width, int height)
	{
		panelDimension = new Dimension(width,height);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setMaximumSize(panelDimension);
		setMaximumSize(panelDimension);
		setSize(panelDimension);
	}
	
	public JXPanel setXLayout(int AXIS)
	{
		setLayout(new BoxLayout(this,AXIS));
		return this;
	}
	
}

package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JXPanel extends JPanel
{

	private static int WIDTH;
	private static int HEIGHT;
	
	private Dimension panelDimension;
	
	static {
		JXPanel.HEIGHT = 500;
		JXPanel.WIDTH = 600;
	}
	
	public JXPanel()
	{
		init(JXPanel.WIDTH,JXPanel.HEIGHT);
	}
	
	public JXPanel(int width, int height)
	{
		init(width,height);
	}
	
	private void init(int width, int height)
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

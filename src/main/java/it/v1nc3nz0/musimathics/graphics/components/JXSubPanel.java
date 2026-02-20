package it.v1nc3nz0.musimathics.graphics.components;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class JXSubPanel extends JXPanel
{

	private static int WIDTH;
	private static int HEIGHT;
	
	static {
		JXSubPanel.HEIGHT = 500;
		JXSubPanel.WIDTH = 250;
	}
	
	public JXSubPanel()
	{
		super(JXSubPanel.WIDTH,JXSubPanel.HEIGHT);
	}
	
	@Override
	public JXSubPanel setXLayout(int AXIS)
	{
		setLayout(new BoxLayout(this,AXIS));
		return this;
	}
}

package it.v1nc3nz0.musimathics.graphics.frames;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.graphics.components.JXButton;
import it.v1nc3nz0.musimathics.graphics.components.JXPanel;
import it.v1nc3nz0.musimathics.graphics.listener.gengui.AbortMusicGenListener;
import it.v1nc3nz0.musimathics.graphics.listener.gengui.BasedMusicGenListener;
import it.v1nc3nz0.musimathics.graphics.listener.gengui.RandomMusicGenListener;

@SuppressWarnings("serial")
public class GenGUI extends JFrame
{

	private Dimension frameDimension;
	private JXPanel panel;
	
	public GenGUI()
	{
		frameDimension = new Dimension(300,200);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximumSize(frameDimension);
		setMinimumSize(frameDimension);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(frameDimension);
		setTitle("Tipo di generazione");
		
		setup();
	}
	
	
	private void loadComponents()
	{
		panel.add(Box.createVerticalStrut(15));
		
		JXButton randomGen = new JXButton("Random").addXMouseListener(new RandomMusicGenListener(this));
		panel.add(randomGen);
		
		panel.add(Box.createVerticalStrut(15));
		
		JXButton basedGen = new JXButton("Vincolata").addXMouseListener(new BasedMusicGenListener(this));
		panel.add(basedGen);
		
		panel.add(Box.createVerticalStrut(30));
		
		JXButton cancel = new JXButton("Annulla").addXMouseListener(new AbortMusicGenListener(this));
		panel.add(cancel);
	}
	
	private void setup()
	{
		panel = new JXPanel().setXLayout(BoxLayout.Y_AXIS);
		
		loadComponents();
		
		add(panel);
	}
	
}

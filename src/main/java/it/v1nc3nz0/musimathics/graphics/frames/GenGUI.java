package it.v1nc3nz0.musimathics.graphics.frames;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.data.configuration.enums.MessagesData;
import it.v1nc3nz0.musimathics.graphics.components.JXButton;
import it.v1nc3nz0.musimathics.graphics.components.JXPanel;
import it.v1nc3nz0.musimathics.graphics.listeners.gengui.AbortMusicGenListener;
import it.v1nc3nz0.musimathics.graphics.listeners.gengui.BasedMusicGenListener;
import it.v1nc3nz0.musimathics.graphics.listeners.gengui.RandomMusicGenListener;

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
		setTitle(MessagesData.COMPONENTS_GENGUI_TITLE.getString());
		
		setup();
	}
	
	
	private void loadComponents()
	{
		panel.add(Box.createVerticalStrut(15));
		
		JXButton randomGen = new JXButton(MessagesData.COMPONENTS_GENGUI_BUTTONS_PARTIALGEN.getString())
				.addXMouseListener(new RandomMusicGenListener(this));
		panel.add(randomGen);
		
		panel.add(Box.createVerticalStrut(15));
		
		JXButton basedGen = new JXButton(MessagesData.COMPONENTS_GENGUI_BUTTONS_FULLGEN.getString())
				.addXMouseListener(new BasedMusicGenListener(this));
		panel.add(basedGen);
		
		panel.add(Box.createVerticalStrut(30));
		
		JXButton cancel = new JXButton(MessagesData.COMPONENTS_GENGUI_BUTTONS_ABORT.getString())
				.addXMouseListener(new AbortMusicGenListener(this));
		panel.add(cancel);
	}
	
	private void setup()
	{
		panel = new JXPanel().setXLayout(BoxLayout.Y_AXIS);
		
		loadComponents();
		
		add(panel);
	}
	
}

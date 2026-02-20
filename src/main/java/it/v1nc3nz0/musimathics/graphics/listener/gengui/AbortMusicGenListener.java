package it.v1nc3nz0.musimathics.graphics.listener.gengui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.graphics.frames.GenGUI;

public class AbortMusicGenListener implements MouseListener
{

	private GenGUI main;
	
	public AbortMusicGenListener(GenGUI main)
	{
		this.main = main;
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		main.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}


	
}

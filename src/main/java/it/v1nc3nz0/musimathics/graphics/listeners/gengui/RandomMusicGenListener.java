package it.v1nc3nz0.musimathics.graphics.listeners.gengui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.data.configuration.enums.MessagesData;
import it.v1nc3nz0.musimathics.graphics.components.JXDialog;
import it.v1nc3nz0.musimathics.graphics.frames.GenGUI;

public class RandomMusicGenListener implements MouseListener
{
	
	private GenGUI main;
	
	public RandomMusicGenListener(GenGUI main)
	{
		this.main = main;
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		try
		{
			main.setVisible(false);
			MusicMain.generateMelodicVoices();
			JXDialog.info(MessagesData.COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_SUCCESSDIALOG_TITLE.getString(),
					MessagesData.COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_SUCCESSDIALOG_CONTENT.getString());
		}
		catch (Exception e)
		{
			JXDialog.error(MessagesData.COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_ERRORDIALOG_TITLE.getString(),
					MessagesData.COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_ERRORDIALOG_CONTENT.getString() 
					+ e.getMessage());
		}
		
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

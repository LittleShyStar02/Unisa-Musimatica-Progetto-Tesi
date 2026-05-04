package it.v1nc3nz0.musimathics.graphics.listeners.gengui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.data.configuration.enums.MessagesData;
import it.v1nc3nz0.musimathics.graphics.components.JXDialog;
import it.v1nc3nz0.musimathics.graphics.frames.GenGUI;

public class BasedMusicGenListener implements MouseListener
{
	
	private GenGUI main;
	
	public BasedMusicGenListener(GenGUI main)
	{
		this.main = main;
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		try
		{
			if(MusicMain.getMusicFileSettings().getVoices() < 2)
			{
				MusicMain.getMusicFileSettings().setVoices(2);
				JXDialog.info(MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_WARNDIALOG_TITLE.getString(),
						MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_WARNDIALOG_CONTENT.getString());
			}
			
			main.setVisible(false);
			MusicMain.generateArmonicVoices();
			JXDialog.info(MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_SUCCESSDIALOG_TITLE.getString(),
					MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_SUCCESSDIALOG_CONTENT.getString());
		}
		catch (Exception e)
		{
			JXDialog.error(MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_ERRORDIALOG_TITLE.getString(), 
					MessagesData.COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_ERRORDIALOG_CONTENT.getString() 
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

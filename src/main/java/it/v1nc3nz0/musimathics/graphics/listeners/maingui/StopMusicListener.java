package it.v1nc3nz0.musimathics.graphics.listeners.maingui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.data.configuration.enums.MessagesData;
import it.v1nc3nz0.musimathics.graphics.components.JXDialog;

public class StopMusicListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent event)
	{
		
		if(MusicMain.getVoicesList() == null || MusicMain.getVoicesList().isEmpty())
		{
			JXDialog.error(MessagesData.COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_ERRORDIALOG_TITLE.getString(),
					MessagesData.COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_ERRORDIALOG_CONTENT.getString());
			return;
		}
		
		MusicMain.getPiece().stop();
		PlayMusicListener.stopped = true;
		JXDialog.info(MessagesData.COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_SUCCESSDIALOG_TITLE.getString(),
				MessagesData.COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_SUCCESSDIALOG_CONTENT.getString());
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

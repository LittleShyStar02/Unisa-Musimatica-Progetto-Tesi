package it.v1nc3nz0.musimathics.graphics.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.CompletableFuture;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.graphics.JXDialog;

public class PlayMusicListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent event)
	{
		
		if(MusicMain.getVoicesList().isEmpty())
		{
			JXDialog.error("Errore", "Nessuna voce trovata. Genera prima di salvare");
			return;
		}
		
		CompletableFuture.runAsync(() -> {
			MusicMain.play();
			JXDialog.info("Riproduzione", "Riproduzione terminata");
		});
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

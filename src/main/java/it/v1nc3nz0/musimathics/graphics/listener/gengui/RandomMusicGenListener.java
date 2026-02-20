package it.v1nc3nz0.musimathics.graphics.listener.gengui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
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
			MusicMain.generateRandomVoices();
			JXDialog.info("Generazione Random Riuscita", "Musica generata correttamente. Ora puoi salvarla o riprodurla");
		}
		catch (Exception e)
		{
			JXDialog.error("Errore", "Errore durante la generazione musicale: " + e.getMessage());
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

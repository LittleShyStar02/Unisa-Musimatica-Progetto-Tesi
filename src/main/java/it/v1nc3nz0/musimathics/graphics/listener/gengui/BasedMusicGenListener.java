package it.v1nc3nz0.musimathics.graphics.listener.gengui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
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
			if(MusicMain.getMusicFileSettings().getVoices() > 4)
			{
				MusicMain.getMusicFileSettings().setVoices(4);
				JXDialog.info("Attenzione", "Hai inserito un numero voci superiore a 4. Abbiamo impostato il limite a 4 per te");
			}
			
			main.setVisible(false);
			MusicMain.generateRandomVoices(); //da sostituire
			JXDialog.info("Generazione Vincolata Riuscita", "Musica generata correttamente. Ora puoi salvarla o riprodurla");
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

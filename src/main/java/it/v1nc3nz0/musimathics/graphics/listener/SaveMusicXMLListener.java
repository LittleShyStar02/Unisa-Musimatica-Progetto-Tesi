package it.v1nc3nz0.musimathics.graphics.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.graphics.JXDialog;

public class SaveMusicXMLListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent event)
	{
		
		if(MusicMain.getVoicesList().isEmpty())
		{
			JXDialog.error("Errore", "Nessuna voce trovata. Genera prima di salvare");
			return;
		}
		
		try
		{
			// Qui il codice per salvare su MusicXML
			JXDialog.info("Salvataggio effettuato", "Salvataggio avvenuto con successo");
		} 
		catch (Exception e)
		{
			JXDialog.error("Salvataggio fallito", "Errore durante il salvataggio: " + e.getMessage());
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

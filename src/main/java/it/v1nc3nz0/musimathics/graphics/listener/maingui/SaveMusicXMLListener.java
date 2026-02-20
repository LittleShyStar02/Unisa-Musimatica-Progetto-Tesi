package it.v1nc3nz0.musimathics.graphics.listener.maingui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.graphics.components.JXDialog;

public class SaveMusicXMLListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent event)
	{
		
		if(MusicMain.getVoicesList() == null || MusicMain.getVoicesList().isEmpty())
		{
			JXDialog.error("Errore", "Nessuna voce trovata. Genera prima di salvare");
			return;
		}
		
		try
		{
			MusicMain.saveToMidi();
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

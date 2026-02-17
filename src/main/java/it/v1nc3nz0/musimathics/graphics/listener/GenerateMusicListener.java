package it.v1nc3nz0.musimathics.graphics.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.v1nc3nz0.musimathics.Main;
import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.graphics.JXDialog;

public class GenerateMusicListener implements MouseListener
{

	private Main main;
	
	public GenerateMusicListener(Main main)
	{
		this.main = main;
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		
		Object bpmObject = main.getBpmSpinner().getValue();
		
		String metric = (String) main.getMetricComboBox().getSelectedItem();
		String scaleNote = (String) main.getScaleNoteComboBox().getSelectedItem();
		String scaleAlteration = (String) main.getScaleAlterationComboBox().getSelectedItem();
		String scaleType = (String) main.getScaleTypeComboBox().getSelectedItem();
		Object voicesObject = main.getVoicesSpinner().getValue();
		
		if(scaleAlteration.equals("NATURALE")) scaleAlteration = "NONE";
		if(scaleAlteration.equals("BEMOLLE")) scaleAlteration = "b";
		if(scaleAlteration.equals("DIESIS")) scaleAlteration = "#";
		
		try
		{
			MusicMain.generateMFS((int) bpmObject, metric, scaleNote, scaleAlteration, scaleType, (int) voicesObject);
			MusicMain.initialize(25);
			MusicMain.generateVoices();
			JXDialog.info("Generazione riuscita", "Musica generata correttamente. Ora puoi salvarla o riprodurla");
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

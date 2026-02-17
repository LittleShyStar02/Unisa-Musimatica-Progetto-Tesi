package it.v1nc3nz0.musimathics;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.graphics.JXButton;
import it.v1nc3nz0.musimathics.graphics.JXComboBox;
import it.v1nc3nz0.musimathics.graphics.JXLabel;
import it.v1nc3nz0.musimathics.graphics.JXPanel;
import it.v1nc3nz0.musimathics.graphics.JXSpinner;
import it.v1nc3nz0.musimathics.graphics.JXSubPanel;
import it.v1nc3nz0.musimathics.graphics.listener.CloseProgramListener;
import it.v1nc3nz0.musimathics.graphics.listener.GenerateMusicListener;
import it.v1nc3nz0.musimathics.graphics.listener.PlayMusicListener;
import it.v1nc3nz0.musimathics.graphics.listener.SaveMusicFileListener;
import it.v1nc3nz0.musimathics.graphics.listener.SaveMusicXMLListener;
import it.v1nc3nz0.musimathics.graphics.listener.StopMusicListener;
import lombok.Getter;

@SuppressWarnings("serial")
public class Main extends JFrame
{

	private Dimension frameDimension;
	private JXPanel leftPanel;
	private JXPanel rightPanel;
	private JXPanel panel;
	
	@Getter
	private JXSpinner bpmSpinner;
	
	@Getter
	private JXComboBox<String> metricComboBox;
	
	@Getter
	private JXComboBox<String> scaleNoteComboBox;
	
	@Getter
	private JXComboBox<String> scaleAlterationComboBox;
	
	@Getter
	private JXComboBox<String> scaleTypeComboBox;
	
	@Getter
	private JXSpinner voicesSpinner;
	
	public Main()
	{
		frameDimension = new Dimension(600,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMaximumSize(frameDimension);
		setMinimumSize(frameDimension);
		setLocationRelativeTo(null);
		setSize(frameDimension);
		setTitle("Compositore Automatico");
		
		setup();
	}
	
	private void loadLeftComponents()
	{
		
		JXSubPanel bpmPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		bpmPanel.add(new JXLabel("Inserisci i BPM"));
		bpmPanel.add((bpmSpinner = new JXSpinner(60,1,999,1)));
		leftPanel.add(bpmPanel);
		
		JXSubPanel metricPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		metricPanel.add(new JXLabel("Inserisci la metrica"));
		metricPanel.add((metricComboBox = new JXComboBox<String>("2/4","3/4","4/4","3/8","6/8")));
		leftPanel.add(metricPanel);
		
		JXSubPanel scaleNotePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleNotePanel.add(new JXLabel("Inserisci la nota della scala"));
		scaleNotePanel.add((scaleNoteComboBox = new JXComboBox<String>("C","D","E","F","G","A","B")));
		leftPanel.add(scaleNotePanel);
		
		JXSubPanel scaleAlterationPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleAlterationPanel.add(new JXLabel("Inserisci l'alterazione della scala"));
		scaleAlterationPanel.add((scaleAlterationComboBox = new JXComboBox<String>("NATURALE","BEMOLLE","DIESIS")));
		leftPanel.add(scaleAlterationPanel);
		
		JXSubPanel scaleTypePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleTypePanel.add(new JXLabel("Inserisci la tipologia di scala"));
		scaleTypePanel.add((scaleTypeComboBox = new JXComboBox<String>("MAJ","MIN")));
		leftPanel.add(scaleTypePanel);
		
		JXSubPanel voicesPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		voicesPanel.add(new JXLabel("Quante voci vuoi generare?"));
		voicesPanel.add((voicesSpinner = new JXSpinner(1,1,999,1)));
		leftPanel.add(voicesPanel);
	}
	
	private void loadRightComponents()
	{
		
		int strut = 30;
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Genera")
				.addXMouseListener(new GenerateMusicListener(this)));
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Riproduci")
				.addXMouseListener(new PlayMusicListener()));
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Ferma Musica")
				.addXMouseListener(new StopMusicListener()));
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Salva: Formato MusicFiles")
				.addXMouseListener(new SaveMusicFileListener()));
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Salva: Formato MusicXML")
				.addXMouseListener(new SaveMusicXMLListener()));
		
		rightPanel.add(Box.createVerticalStrut(strut));
		
		rightPanel.add(new JXButton("Chiudi Programma")
				.addXMouseListener(new CloseProgramListener()));
		
		panel.add(rightPanel);
	}
	
	private void setup()
	{
		panel = new JXPanel().setXLayout(BoxLayout.X_AXIS);
		
		leftPanel = new JXPanel((int)(frameDimension.getWidth()/2),(int)frameDimension.getHeight())
				.setXLayout(BoxLayout.Y_AXIS);
		rightPanel = new JXPanel((int)(frameDimension.getWidth()/2),(int)frameDimension.getHeight())
				.setXLayout(BoxLayout.Y_AXIS);
		
		loadLeftComponents();
		loadRightComponents();
		
		panel.add(leftPanel);
		panel.add(rightPanel);
		add(panel);
	}
	
	public static void main(String[] args)
	{
		ConfigContainer.init();
		Main main = new Main();
		main.setVisible(true);
	}
	
}

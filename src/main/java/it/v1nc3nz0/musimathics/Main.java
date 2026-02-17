package it.v1nc3nz0.musimathics;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.graphics.JXComboBox;
import it.v1nc3nz0.musimathics.graphics.JXLabel;
import it.v1nc3nz0.musimathics.graphics.JXPanel;
import it.v1nc3nz0.musimathics.graphics.JXSpinner;
import it.v1nc3nz0.musimathics.graphics.JXSubPanel;

@SuppressWarnings("serial")
public class Main extends JFrame
{

	private Dimension frameDimension;
	private JXPanel leftPanel;
	private JXPanel rightPanel;
	private JXPanel panel;
	
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
		bpmPanel.add(new JXSpinner(60,1,999,1));
		leftPanel.add(bpmPanel);
		
		JXSubPanel metricPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		metricPanel.add(new JXLabel("Inserisci la metrica"));
		metricPanel.add(new JXComboBox<String>("2/4","3/4","4/4","3/8","6/8"));
		leftPanel.add(metricPanel);
		
		JXSubPanel scaleNotePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleNotePanel.add(new JXLabel("Inserisci la nota della scala"));
		scaleNotePanel.add(new JXComboBox<String>("C","D","E","F","G","A","B"));
		leftPanel.add(scaleNotePanel);
		
		JXSubPanel scaleAlterationPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleAlterationPanel.add(new JXLabel("Inserisci l'alterazione della scala"));
		scaleAlterationPanel.add(new JXComboBox<String>("n","b","#"));
		leftPanel.add(scaleAlterationPanel);
		
		JXSubPanel scaleTypePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleTypePanel.add(new JXLabel("Inserisci la tipologia di scala"));
		scaleTypePanel.add(new JXComboBox<String>("MAJ","MIN"));
		leftPanel.add(scaleTypePanel);
		
		JXSubPanel voicesPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		voicesPanel.add(new JXLabel("Quante voci vuoi generare?"));
		voicesPanel.add(new JXSpinner(1,1,999,1));
		leftPanel.add(voicesPanel);
	}
	
	private void loadRightComponents()
	{
		
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

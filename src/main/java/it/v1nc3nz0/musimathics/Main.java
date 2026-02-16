package it.v1nc3nz0.musimathics;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.graphics.JXComboBox;
import it.v1nc3nz0.musimathics.graphics.JXLabel;
import it.v1nc3nz0.musimathics.graphics.JXPanel;
import it.v1nc3nz0.musimathics.graphics.JXSpinner;

@SuppressWarnings("serial")
public class Main extends JFrame
{

	private Dimension frameDimension;
	private JXPanel leftPanel;
	private JXPanel rightPanel;
	private JXPanel panel;
	
	// Left Components
	private JXComboBox<String> scaleAlterationComboBox;
	private JXComboBox<String> scaleTypeComboBox;
	private JXSpinner bpmSpinner;
	private JXSpinner voicesSpinner;
	
	
	public Main()
	{
		frameDimension = new Dimension(600,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMaximumSize(frameDimension);
		setMinimumSize(frameDimension);
		setSize(frameDimension);
		
		setup();
	}
	
	private int getSubPanelW()
	{
		return (int) (frameDimension.getWidth()/2)-30;
	}
	
	private void loadLeftComponents()
	{
		
		JXPanel bpmPanel = new JXPanel(getSubPanelW(),80)
				.setXLayout(BoxLayout.Y_AXIS);
		bpmPanel.add(new JXLabel(200,50,"Inserisci i BPM"));
		bpmSpinner = new JXSpinner(60,1,999,1,100,20);
		bpmPanel.add(bpmSpinner);
		leftPanel.add(bpmPanel);
		
		JXPanel metricPanel = new JXPanel(getSubPanelW(),80)
				.setXLayout(BoxLayout.Y_AXIS);
		metricPanel.add(new JXLabel(200,50,"Inserisci la metrica"));
		leftPanel.add(metricPanel);
		
		JXPanel scaleNotePanel = new JXPanel(getSubPanelW(),80)
				.setXLayout(BoxLayout.Y_AXIS);
		scaleNotePanel.add(new JXLabel(200,50,"Inserisci la nota della scala"));
		leftPanel.add(scaleNotePanel);
		
		JXPanel scaleAlterationPanel = new JXPanel(getSubPanelW(),80)
				.setXLayout(BoxLayout.Y_AXIS);
		scaleAlterationPanel.add(new JXLabel(200,50,"Inserisci l'alterazione della scala"));
		scaleAlterationComboBox = new JXComboBox<String>(200,20,"n","b","#");
		scaleAlterationPanel.add(scaleAlterationComboBox);
		leftPanel.add(scaleAlterationPanel);
		
		JXPanel scaleTypePanel = new JXPanel(getSubPanelW(),80)
				.setXLayout(BoxLayout.Y_AXIS);
		scaleTypePanel.add(new JXLabel(200,50,"Inserisci la tipologia di scala"));
		scaleTypeComboBox = new JXComboBox<String>(200,20,"MAJ","MIN");
		scaleTypePanel.add(scaleTypeComboBox);
		leftPanel.add(scaleTypePanel);
		
		JXPanel voicesPanel = new JXPanel(getSubPanelW(), 80)
				.setXLayout(BoxLayout.Y_AXIS);
		voicesPanel.add(new JXLabel(200,50,"Quante voci vuoi generare?"));
		voicesSpinner = new JXSpinner(1,1,999,1,100,20);
		voicesPanel.add(voicesSpinner);
		leftPanel.add(voicesPanel);
	}
	
	private void loadRightComponents()
	{
		
		panel.add(rightPanel);
	}
	
	private void setup()
	{
		panel = new JXPanel((int)frameDimension.getWidth(),(int)frameDimension.getHeight())
				.setXLayout(BoxLayout.X_AXIS);
		
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

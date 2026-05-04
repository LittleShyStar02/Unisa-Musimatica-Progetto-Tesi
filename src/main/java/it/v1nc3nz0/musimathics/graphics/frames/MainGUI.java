package it.v1nc3nz0.musimathics.graphics.frames;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import it.v1nc3nz0.musimathics.data.configuration.enums.MessagesData;
import it.v1nc3nz0.musimathics.graphics.components.JXButton;
import it.v1nc3nz0.musimathics.graphics.components.JXComboBox;
import it.v1nc3nz0.musimathics.graphics.components.JXLabel;
import it.v1nc3nz0.musimathics.graphics.components.JXPanel;
import it.v1nc3nz0.musimathics.graphics.components.JXSpinner;
import it.v1nc3nz0.musimathics.graphics.components.JXSubPanel;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.CloseProgramListener;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.GenerateRandomMusicListener;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.PlayMusicListener;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.SaveMusicFileListener;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.SaveMidiListener;
import it.v1nc3nz0.musimathics.graphics.listeners.maingui.StopMusicListener;
import lombok.Getter;

@SuppressWarnings("serial")
public class MainGUI extends JFrame
{

	private Dimension frameDimension;
	private JXPanel leftPanel;
	private JXPanel rightPanel;
	private JXPanel panel;
	
	@Getter
	private GenGUI genGUI;
	
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
	
	public MainGUI()
	{
		frameDimension = new Dimension(600,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMaximumSize(frameDimension);
		setMinimumSize(frameDimension);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(frameDimension);
		setTitle(MessagesData.COMPONENTS_MAINGUI_TITLE.getString());
		
		setup();
		
		genGUI = new GenGUI();
	}
	
	private void loadLeftComponents()
	{
		
		JXSubPanel bpmPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		bpmPanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_BPM.getString()));
		bpmPanel.add((bpmSpinner = new JXSpinner(60,1,999,1)));
		leftPanel.add(bpmPanel);
		
		JXSubPanel metricPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		metricPanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_METRIC.getString()));
		metricPanel.add((metricComboBox = new JXComboBox<String>("2/4","3/4","4/4","3/8","6/8")));
		leftPanel.add(metricPanel);
		
		JXSubPanel scaleNotePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleNotePanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_SCALENOTE.getString()));
		scaleNotePanel.add((scaleNoteComboBox = new JXComboBox<String>("DO","RE","MI","FA","SOL","LA","SI")));
		leftPanel.add(scaleNotePanel);
		
		JXSubPanel scaleAlterationPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleAlterationPanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_SCALEALTERATION.getString()));
		scaleAlterationPanel.add((scaleAlterationComboBox = new JXComboBox<String>("NATURALE","BEMOLLE","DIESIS")));
		leftPanel.add(scaleAlterationPanel);
		
		JXSubPanel scaleTypePanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		scaleTypePanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_SCALETYPE.getString()));
		scaleTypePanel.add((scaleTypeComboBox = new JXComboBox<String>("MAGGIORE","MINORE")));
		leftPanel.add(scaleTypePanel);
		
		JXSubPanel voicesPanel = new JXSubPanel().setXLayout(BoxLayout.Y_AXIS);
		voicesPanel.add(new JXLabel(MessagesData.COMPONENTS_MAINGUI_LABELS_VOICES.getString()));
		voicesPanel.add((voicesSpinner = new JXSpinner(1,1,4,1)));
		leftPanel.add(voicesPanel);
	}
	
	private void loadRightComponents()
	{
		rightPanel.add(Box.createVerticalStrut(30));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_GENERATE.getString())
				.addXMouseListener(new GenerateRandomMusicListener(this)));
		
		rightPanel.add(Box.createVerticalStrut(43));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_PLAY.getString())
				.addXMouseListener(new PlayMusicListener()));
		
		rightPanel.add(Box.createVerticalStrut(46));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_STOPMUSIC.getString())
				.addXMouseListener(new StopMusicListener()));
		
		rightPanel.add(Box.createVerticalStrut(48));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_SAVEFORMATMF.getString())
				.addXMouseListener(new SaveMusicFileListener()));
		
		rightPanel.add(Box.createVerticalStrut(48));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_SAVEFORMATMIDI.getString())
				.addXMouseListener(new SaveMidiListener()));
		
		rightPanel.add(Box.createVerticalStrut(48));
		
		rightPanel.add(new JXButton(MessagesData.COMPONENTS_MAINGUI_BUTTONS_CLOSE.getString())
				.addXMouseListener(new CloseProgramListener()));

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
	
}

package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class JXSpinner extends JSpinner
{

	private static int WIDTH;
	private static int HEIGTH;
	
	private Dimension spinnerDimension;
	
	static {
		JXSpinner.HEIGTH = 30;
		JXSpinner.WIDTH = 250;
	}
	
	public JXSpinner(int defaultValue, int min, int max, int step)
	{
		super(new SpinnerNumberModel(defaultValue,min,max,step));
		
		spinnerDimension = new Dimension(JXSpinner.WIDTH,JXSpinner.HEIGTH);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setMaximumSize(spinnerDimension);
		setMinimumSize(spinnerDimension);
		setSize(spinnerDimension);
		
	}
	
}

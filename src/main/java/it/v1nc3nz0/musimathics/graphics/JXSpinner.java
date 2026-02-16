package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class JXSpinner extends JSpinner
{

	private Dimension spinnerDimension;
	
	public JXSpinner(int defaultValue, int min, int max, int step,int width,int height)
	{
		super(new SpinnerNumberModel(defaultValue,min,max,step));
		
		spinnerDimension = new Dimension(width,height);
		
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setMaximumSize(spinnerDimension);
		setMinimumSize(spinnerDimension);
		setSize(spinnerDimension);
		
	}
	
}

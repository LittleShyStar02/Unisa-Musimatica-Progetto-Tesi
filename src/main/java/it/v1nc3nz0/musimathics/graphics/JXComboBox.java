package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JXComboBox<Type> extends JComboBox<Type>
{

	private Dimension comboDimension;
	
	@SafeVarargs
	public JXComboBox(int width, int height, Type ...values)
	{
		super(values);
		
		comboDimension = new Dimension(width, height);
		
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setMaximumSize(comboDimension);
		setMinimumSize(comboDimension);
		setSize(comboDimension);
	}
	
}

package it.v1nc3nz0.musimathics.graphics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JXComboBox<Type> extends JComboBox<Type>
{

	private static int WIDTH;
	private static int HEIGHT;
	
	private Dimension comboDimension;
	
	static {
		JXComboBox.HEIGHT = 30;
		JXComboBox.WIDTH = 250;
	}
	
	@SafeVarargs
	public JXComboBox(Type ...values)
	{
		super(values);
		
		comboDimension = new Dimension(JXComboBox.WIDTH, JXComboBox.HEIGHT);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setMaximumSize(comboDimension);
		setMinimumSize(comboDimension);
		setSize(comboDimension);
	}
	
}

package it.v1nc3nz0.musimathics.graphics;

import javax.swing.JOptionPane;

public class JXDialog
{

	public static void error(String title,String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void info(String title,String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void plain(String title,String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
}

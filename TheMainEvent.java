import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   plays the game 
*/
public class TheMainEvent
{
	public static void main(String [] args)
	{
		JFrame frame = new Framing();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setSize(800, 800);
      	frame.validate();
      	frame.setVisible(true);
         
	}
}
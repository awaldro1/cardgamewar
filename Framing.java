import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
   the GUI setup
*/
public class Framing extends JFrame
{
	GameSituation game;
	private JButton hitButton, restartButton;
	private JPanel frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8;
	private JLabel cardImageFront1, cardImageFront2, cardImageBack1, cardImageBack2, u1, u2, u1cards, u2cards, text;
	private ImageIcon front1, front2, back;
   
	/**
	   grid layout
	*/
	public Framing()
	{
		game = new GameSituation();

		setLayout(new GridLayout(3, 3));

		setTitle("War of the Warlords");

		frame1 = new JPanel(new BorderLayout());
		u1 = new JLabel("Warlord 1");
		u1cards = new JLabel("Soldier force remaining: " + game.getuserHand1().size());
		frame1.add(u1, BorderLayout.NORTH);
		frame1.add(u1cards, BorderLayout.CENTER);
		back = new ImageIcon("back.jpg");
		cardImageBack1 = new JLabel(back);
		frame1.add(cardImageBack1, BorderLayout.EAST);

		frame2 = new JPanel(new BorderLayout());
		cardImageFront1 = new JLabel();
		frame2.add(cardImageFront1, BorderLayout.EAST);

		frame3 = new JPanel();

		frame4 = new JPanel(new BorderLayout());
		u2 = new JLabel("Warlord 2");
		u2cards = new JLabel("Soldier force remaining: " + game.getuserHand2().size());
		frame4.add(u2, BorderLayout.NORTH);
		frame4.add(u2cards, BorderLayout.CENTER);
		cardImageBack2 = new JLabel(back);
		frame4.add(cardImageBack2, BorderLayout.EAST);

		frame5 = new JPanel(new BorderLayout());
		cardImageFront2 = new JLabel();
		frame5.add(cardImageFront2, BorderLayout.EAST);

		frame6 = new JPanel();


		frame7 = new JPanel();
		hitButton = new JButton("SEND SOLDIER");
		hitButton.addActionListener(new HitButtonListener());
		frame7.add(hitButton);

		frame8 = new JPanel();
		text = new JLabel();
		frame8.add(text);

		add(frame1);
		add(frame2);
		add(frame3);
		add(frame4);
		add(frame5);
		add(frame6);
		add(frame7);
		add(frame8);
	}

	/**
	   HitButtonListener gives direction when the "SEND SOLDIER" button is pressed
	*/
	public class HitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!game.END())
			{
				front1 = game.getuserHand1().check().getCardImage();
				front2 = game.getuserHand2().check().getCardImage();
				cardImageFront1.setIcon(front1);
				cardImageFront2.setIcon(front2);

				int userNumber = 0;

				if(game.getuserHand1().check().getRank() > game.getuserHand2().check().getRank())
					userNumber = 1;
				else if(game.getuserHand1().check().getRank() < game.getuserHand2().check().getRank())
					userNumber = 2;
				else
					userNumber = 0;

				game.turn();

				if(userNumber != 0)
					text.setText("Warlord " + userNumber + " wins this round.");
				else
					text.setText("War! SEND REINFORCEMENTS!");

				u1cards.setText("Soldier force remaining: " + game.getuserHand1().size());
				u2cards.setText("Soldier force remaining: " + game.getuserHand2().size());
			}
			else
				text.setText("Game over.");
		}
	}
}
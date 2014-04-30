import java.util.LinkedList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

/**
   Deck maeks the full deck of cards
*/
public class Deck extends Cardstack
{
	/**
	   creates a deck and fills it with 52 cards
	*/
	public Deck()
	{
		super();
		occupyDeck();
	}

	/**
	   occupyDeck fills all 52 cards to the deck 
	*/
	public void occupyDeck()
	{

	   // add cards that are clubs
      super.addCard(new Card(1, 2, new ImageIcon("2c.jpg")));
		super.addCard(new Card(1, 3, new ImageIcon("3c.jpg")));
		super.addCard(new Card(1, 4, new ImageIcon("4c.jpg")));
		super.addCard(new Card(1, 5, new ImageIcon("5c.jpg")));
		super.addCard(new Card(1, 6, new ImageIcon("6c.jpg")));
		super.addCard(new Card(1, 7, new ImageIcon("7c.jpg")));
		super.addCard(new Card(1, 8, new ImageIcon("8c.jpg")));
		super.addCard(new Card(1, 9, new ImageIcon("9c.jpg")));
		super.addCard(new Card(1, 10, new ImageIcon("10c.jpg")));
		super.addCard(new Card(1, 11, new ImageIcon("jackc.jpg")));
		super.addCard(new Card(1, 12, new ImageIcon("queenc.jpg")));
		super.addCard(new Card(1, 13, new ImageIcon("kingc.jpg")));
		super.addCard(new Card(1, 14, new ImageIcon("acec.jpg")));
      
      // add cards that are diamonds
		super.addCard(new Card(2, 2, new ImageIcon("2d.jpg")));
		super.addCard(new Card(2, 3, new ImageIcon("3d.jpg")));
		super.addCard(new Card(2, 4, new ImageIcon("4d.jpg")));
		super.addCard(new Card(2, 5, new ImageIcon("5d.jpg")));
		super.addCard(new Card(2, 6, new ImageIcon("6d.jpg")));
		super.addCard(new Card(2, 7, new ImageIcon("7d.jpg")));
		super.addCard(new Card(2, 8, new ImageIcon("8d.jpg")));
		super.addCard(new Card(2, 9, new ImageIcon("9d.jpg")));
		super.addCard(new Card(2, 10, new ImageIcon("10d.jpg")));
		super.addCard(new Card(2, 11, new ImageIcon("jackd.jpg")));
		super.addCard(new Card(2, 12, new ImageIcon("queend.jpg")));
		super.addCard(new Card(2, 13, new ImageIcon("kingd.jpg")));
		super.addCard(new Card(2, 14, new ImageIcon("aced.jpg")));
      
      // add cards that are hearts
		super.addCard(new Card(3, 2, new ImageIcon("2h.jpg")));
		super.addCard(new Card(3, 3, new ImageIcon("3h.jpg")));
		super.addCard(new Card(3, 4, new ImageIcon("4h.jpg")));
		super.addCard(new Card(3, 5, new ImageIcon("5h.jpg")));
		super.addCard(new Card(3, 6, new ImageIcon("6h.jpg")));
		super.addCard(new Card(3, 7, new ImageIcon("7h.jpg")));
		super.addCard(new Card(3, 8, new ImageIcon("8h.jpg")));
		super.addCard(new Card(3, 9, new ImageIcon("9h.jpg")));
		super.addCard(new Card(3, 10, new ImageIcon("10h.jpg")));
		super.addCard(new Card(3, 11, new ImageIcon("jackh.jpg")));
		super.addCard(new Card(3, 12, new ImageIcon("queenh.jpg")));
		super.addCard(new Card(3, 13, new ImageIcon("kingh.jpg")));
		super.addCard(new Card(3, 14, new ImageIcon("aceh.jpg")));
      
      // add cards that are spades
		super.addCard(new Card(4, 2, new ImageIcon("2s.jpg")));
		super.addCard(new Card(4, 3, new ImageIcon("3s.jpg")));
		super.addCard(new Card(4, 4, new ImageIcon("4s.jpg")));
		super.addCard(new Card(4, 5, new ImageIcon("5s.jpg")));
		super.addCard(new Card(4, 6, new ImageIcon("6s.jpg")));
		super.addCard(new Card(4, 7, new ImageIcon("7s.jpg")));
		super.addCard(new Card(4, 8, new ImageIcon("8s.jpg")));
		super.addCard(new Card(4, 9, new ImageIcon("9s.jpg")));
		super.addCard(new Card(4, 10, new ImageIcon("10s.jpg")));
		super.addCard(new Card(4, 11, new ImageIcon("jacks.jpg")));
		super.addCard(new Card(4, 12, new ImageIcon("queens.jpg")));
		super.addCard(new Card(4, 13, new ImageIcon("kings.jpg")));
		super.addCard(new Card(4, 14, new ImageIcon("aces.jpg")));

      
      
	

	}
}
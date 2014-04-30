import java.util.Random;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class WarSituation
{
	public static void main(String[] args)
	{
		Deck FDeck = new Deck();
		userHand user1 = new userHand();
		userHand user2 = new userHand();

		giveCards(FDeck, user1, user2);

		while(!user1.isEmpty() && !user2.isEmpty())
		{
			compare(user1, user2);	// take card from each deck and compare
			System.out.println("user 1- " + user1.size() + "\tuser 2- " + user2.size());
		}

		if(user1.isEmpty())
			System.out.println("User 1 has no more cards");
		else
			System.out.println("User 2 has no more cards");

		System.out.println("Game over");
	}

	public static void giveCards(Deck deck, userHand u1, userHand u2)
	{
		while(!deck.isEmpty())
		{
			u1.addCard(deck.giveCard());
			u2.addCard(deck.giveCard());
		}
	}

	public static void compare(userHand u1, userHand u2)
	{
		// take card from top of deck
		Card u1_card1 = u1.takeCard();
		Card u2_card1 = u2.takeCard();

      // holds number after comparing Cards
		int compValue;	

		compValue = u1_card1.compareCard(u2_card1);

		if(compValue > 0)	// user 1's card is higher rank
		{
			u1.addCard(u1_card1);
			u1.addCard(u2_card1);
		}
		else if(compValue < 0)	// user 2's card is higher rank
		{
			u2.addCard(u1_card1);
			u2.addCard(u2_card1);
		}
      //tie
		else	
		{
         // space for the side cards
			userHand side = new userHand();	
			side.addCard(u1_card1);
			side.addCard(u2_card1);

			if(u1.size() >= 3 && u2.size() >= 3)
			{
				System.out.println("First War");
				war(u1, u2, side);
			}
			else if(u1.size() == 2 || u2.size() == 2)
			{
				System.out.println(" First twoCardWar");
				twoCardWar(u1, u2, side);
			}
			else				{
				if(u1.size() < 2)
				{
					System.out.println("User 1 has too little cards to engage War");
					
					while(!u1.isEmpty())
						side.addCard(u1.takeCard());
				}
				else if(u2.size() < 2)
				{
					System.out.println("User 2 has too little cards to engage War");
					
					while(!u2.isEmpty())
						side.addCard(u2.takeCard());
				}
			}
		}
	}

	public static void war(userHand u1, userHand u2, userHand side)
	{

		Card u1_down = u1.takeCard();
		Card u2_down = u2.takeCard();

		side.addCard(u1_down);
		side.addCard(u2_down);

		Card u1_duelist = u1.takeCard();	
		Card u2_duelist = u2.takeCard();	

		int compValue = u1_duelist.compareCard(u2_duelist);

		if(compValue > 0)	
		{
			u1.addCard(u1_duelist);
			u1.addCard(u2_duelist);
			while(!side.isEmpty())
				u1.addCard(side.takeCard());
		}
		else if(compValue < 0)	
      {
			u2.addCard(u1_duelist);
			u2.addCard(u2_duelist);
			while(!side.isEmpty())
				u1.addCard(side.takeCard());
		}
      //tie 
		else	
		{
			side.addCard(u1_duelist);
			side.addCard(u2_duelist);

			if(u1.size() >= 3 && u2.size() >= 3)	
			{
				System.out.println("Second War");
				war(u1, u2, side);
			}
			else if(u1.size() == 2 || u2.size() == 2)	
         {
				System.out.println("Second twoCardWar");
				twoCardWar(u1, u2, side);
			}
			else	
         {
				if(u1.size() < 2)
				{
					System.out.println("User 1 has too little cards to engage War");
					
               while(!u1.isEmpty())
						side.addCard(u1.takeCard());
				}
				else if(u2.size() < 2)
				{
					System.out.println("User 2 has too little cards to engage War");
               
					while(!u2.isEmpty())
						side.addCard(u2.takeCard());
				}
			}
		}
	}

	public static void twoCardWar(userHand u1, userHand u2, userHand side)
	{
		int note = 0;

		Card u1_down = u1.takeCard();
		Card u2_down = u2.takeCard();

		side.addCard(u1_down);
		side.addCard(u2_down);

		Card u1_duelist = u1.takeCard();	
		Card u2_duelist = u2.takeCard();	

		int compValue = u1_duelist.compareCard(u2_duelist);

		if(compValue > 0)	
		{
			u1.addCard(u1_duelist);
			u1.addCard(u2_duelist);
			while(!side.isEmpty())
				u1.addCard(side.takeCard());

			if(u2.isEmpty())	
				note = -1;
		}
		else if(compValue < 0)	
		{
			u2.addCard(u1_duelist);
			u2.addCard(u2_duelist);
			while(!side.isEmpty())
				u1.addCard(side.takeCard());

			if(u1.isEmpty())
				note = -1;
		}
		else	
		{
			if(note != -1)
			{
				System.out.println("coming ut of twoCardWar");
				war(u1, u2, side);
			}
		}
	}
}
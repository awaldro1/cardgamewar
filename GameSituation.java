import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
   GameSituation class is the guts of the game
*/
public class GameSituation
{
	Deck FDeck;	
	userHand u1;	
	userHand u2;	
	boolean END; //determines the end of the game

	/**
	   GameSituation uses two userHands and one Deck, sets END to false
	   while giving cards to both hands
	*/
	public GameSituation()
	{
		END = false;

		u1 = new userHand();
		u2 = new userHand();

		FDeck = new Deck();
		giveCards(FDeck, u1, u2);
	}

	/**
	   giveCards distributes the 52 cards in FDeck to u1 and u2 evenly 26 and 26
  	*/
	public void giveCards(Deck FDeck, userHand u1, userHand u2)
	{
		while(!FDeck.isEmpty())
		{
			u1.addCard(FDeck.giveCard());	
			u2.addCard(FDeck.giveCard());	
		}
	}

	/**
	   END returns the result of END variable
	*/
	public boolean END()
	{
		return END;
	}

	/** makes reference to user's hands
   	*/
	public userHand getuserHand1()
	{
		return u1;
	}



	public userHand getuserHand2()
	{
		return u2;
	}

	/**
	   turn comapres the top cards of each hand then returns to bottom of 
      the deck unless tie
  	*/
	public void turn()
	{
		Card u1Card1 = u1.takeCard();
		Card u2Card1 = u2.takeCard();	
      
      // u1 has higher card
		if(u1Card1.compareCard(u2Card1) > 0)	
		{
			u1.addCard(u1Card1);
			u1.addCard(u2Card1);
			System.out.println("u1 is higher");
		}
      	// u2 has higher card
		else if(u1Card1.compareCard(u2Card1) < 0)
      		{
			u2.addCard(u1Card1);
			u2.addCard(u2Card1);
			System.out.println("u2 is higher");
		}
      //tied which is war
		else	
		{
			userHand side = new userHand();	
			side.addCard(u1Card1);
			side.addCard(u2Card1);

			if(u1.size() >= 3 && u2.size() >= 3)	
 			{
				System.out.println("First War");
				war(u1, u2, side);
			}
			else if(u1.size() == 2 || u2.size() == 2)	
			{
				System.out.println("First twoCardWar");
				twoCardWar(u1, u2, side);
			}
         
         // not enough cards for a war
			else	
			{
				if(u1.size() < 2)
				{
					System.out.println(u1.toString() + " does not have enough cards for war");
					END = true;
				}
				else if(u2.size() < 2)
				{
					System.out.println(u2.toString() + " does not have enough cards for war");
					END = true;
				}
			}
		}
	}

	/**
	   war method takes the two hands and the "side" cards and takes two down cards
	   then takes two face-up cards and compares values
	*/
	public void war(userHand u1, userHand u2, userHand side)
	{
		
		Card u1_down = u1.takeCard();
		Card u2_down = u2.takeCard();

		side.addCard(u1_down);
		side.addCard(u2_down);

		Card u1_duelist = u1.takeCard();
		Card u2_duelist = u2.takeCard();	

		if(u1_duelist.compareCard(u2_duelist) > 0)	
		{
			u1.addCard(u1_duelist);
			u1.addCard(u2_duelist);
			System.out.println("u1 is higher");
			while(!side.isEmpty())	
         u1.addCard(side.takeCard());
		}
		else if(u1_duelist.compareCard(u2_duelist) < 0)	
		{
			u2.addCard(u1_duelist);
			u2.addCard(u2_duelist);
			System.out.println("u2 is higher");
			while(!side.isEmpty())	
				u1.addCard(side.takeCard());
		}
      //another war
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
				System.out.println("Second twoCardWar ");
				twoCardWar(u1, u2, side);
			}
			else	
  			{
				if(u1.size() < 2)
				{
					System.out.println("Player 1 does not have enough cards for war");

					END = true;
				}
				else if(u2.size() < 2)
				{
					System.out.println("Player 2 does not have enough cards for war");

					END = true;
				}
			}
		}
	}

	/**
	   twoCardWar if one of the hands has only
	   two cards 
	*/
	public void twoCardWar(userHand u1, userHand u2, userHand side)
	{

		Card u1_down = u1.takeCard();
		Card u2_down = u2.takeCard();


		side.addCard(u1_down);
		side.addCard(u2_down);

		Card u1_duelist = u1.takeCard();	
		Card u2_duelist = u2.takeCard();	

		if(u1_duelist.compareCard(u2_duelist) > 0)	
		{
			u1.addCard(u1_duelist);
			u1.addCard(u2_duelist);
			System.out.println("u1 is higher");
			while(!side.isEmpty())
				u1.addCard(side.takeCard());

         // end game if u2 has no more cards
			if(u2.isEmpty())	
				END = true;
		}
		else if(u1_duelist.compareCard(u2_duelist) < 0)	
		{
			u2.addCard(u1_duelist);
			u2.addCard(u2_duelist);
			System.out.println("u1 is higher");
			while(!side.isEmpty())
				u1.addCard(side.takeCard());
            
         //end game if u1 has no more cards
			if(u1.isEmpty())	
				END = true;
		}
     // another war
		else
		{
			if(!END)
			{
				System.out.println("coming ut of Second twoCardWar ");
				war(u1, u2, side);
			}
		}
	}
}
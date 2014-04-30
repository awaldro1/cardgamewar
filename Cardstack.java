import java.util.LinkedList;
import java.util.Random;
import java.io.*;

/**
   creates a Cardstack object that can store a list of cards
*/
public class Cardstack
{
	private LinkedList<Card> stack;
	int cardCount;

	/**
	  creates an empty list of cards
	*/
	public Cardstack()
	{
		stack = new LinkedList<Card>();
	}

	/**
	   addCard adds a card to the stack
	*/
	public void addCard(Card card)
	{
		stack.add(card);
		cardCount++;
	}

	/**
	   takeCard removes and returns the first card in the stack
	*/
	public Card takeCard()
	{
		cardCount--;
		return stack.removeFirst();
	}

	/**
	   giveCard randomly selects a card and returns it 
	*/
	public Card giveCard()
	{
		Random rand = new Random();	
      
      //picks the randomly chosen card out of the deck
		Card card = stack.get(rand.nextInt(stack.size()));
		stack.remove(card);

		cardCount--;

		return card;
	}

	/**
	   returns how many cards are in the stack
	*/
	public int size()
	{
		return cardCount;
	}

	/**
		peek returns what the top card in the stack is without removing it
	*/
	public Card check()
	{
		return stack.get(0);
	}

	/**
	   isEmpty checks and returns true or false is the stack is empty
	   
	*/
	public boolean isEmpty()
	{
		if(cardCount == 0)
			return true;
		else 
         return false;
	}
}
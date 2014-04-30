import javax.swing.*;

/**
   the class Card makes an object that holds suit rank and the ImageIcon
*/
public class Card
{
	// value for the suit holder
	public final static int CLUBS = 1;
	public final static int DIAMONDS = 2;
	public final static int HEARTS = 3;
	public final static int SPADES = 4;

	// value for non numerical 
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
   public final static int ACE = 14;


   //suit and rank holders
	private int suit;
	private int rank;	
   
   
	private ImageIcon cardImage;

	/**
      This constructor takes in a suit and rank to make a Card.
    */
	public Card(int tux, int type, ImageIcon pic)
	{
		suit = tux;
		rank = type;
		cardImage = pic;
	}

	/**
      returns the value that is assigned to suit 
	*/
	public int getSuit()
	{
		return suit;
	}

	/**
      returns the value that is assigned to rank
	*/
	public int getRank()
	{
		return rank;
	}

	/**
      returns what image the card is
	*/
	public ImageIcon getCardImage()
  	{
    	return cardImage;
  	}

	/**
     compares the value of the rank if tie; tie returns 0
	*/
	public int compareCard(Card otherCard)
	{
		if(this.getRank() > otherCard.getRank())
			return 1;
		else if(this.getRank() < otherCard.getRank())
			return -1;
		else
			return 0;
	}
}
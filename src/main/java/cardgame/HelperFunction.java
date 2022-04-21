package cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class HelperFunction 
{
	/*
	 * gamePlay function is to implement the game as per rules and the strategy of the players.
	 * @grade1 and @grade2 are the gamer1,gamer2 points.
	 * openCard is mentioned as @topCard.
	 * @declareCard is the suit declared by the gamers who played eight cards.
	 * 
	 * */
	void gamePlay(List<Card> deck,gamer1 play1,gamer2 play2) 
	{
		int i,grade1=0,grade2=0;
		Card.Suit declareCard=null;
		Card topCard;
		topCard=deck.get(0);
		System.out.println("Top card has: "+topCard.getRank()+" "+topCard.getSuit());
		System.out.println(" ");
		deck.remove(0);
		int temp=1;
		while(grade1<200 && grade2<200)
		{  
			for(i=0;i<6;i++)
			{
				if(i%2==1) 
				{
					temp=forLoop(play2,deck,topCard, declareCard);
				}
				else 
				{
					temp=forLoop(play1,deck,topCard, declareCard);
				}
				if(temp==0) 
				{
					if(i<3) 
						i=3;
					else 
						i=6;
				 }
			  }
			 if(play1.gamer1Cards.isEmpty() ||deck.isEmpty()) 
			 {
				 grade2=play2.getScore(grade2);
				 System.out.println(" ");
				 System.out.println("Gamer2 scores:"+grade2);
			 }
			 if(play2.gamer2Cards.isEmpty() ||deck.isEmpty()) 
			 {
				 grade1=play1.getScore(grade1);
				 System.out.println("Gamer1 scores:"+grade1);
				 System.out.println(" ");
			 }
			 if(deck.isEmpty()) 
			 {
				 deck=Card.getDeck();
				 Collections.shuffle(deck);
			 }
		}
		if(grade2>=200) 
		{
			System.out.println("Gamer2 wins");
		}
		else if(grade1>=200) 
		{
			System.out.println("Gamer1 wins");
		}
		System.out.println(" ");
		System.out.println("GAME END...");
	}
	/*
	 * declaring array list for gamer1,gamer2.
	 * shuffle the deck.
	 * Each gamer receives seven cards from deck.
	 * After each gamer receives seven cards,the number of cards will be reduced from deck.
	 */
	
	List<Card> startReStart(List<Card> deckCard, gamer1 play1, gamer2 play2) 
	{
		List<Card> deck = deckCard;
		deck = Card.getDeck();
		Collections.shuffle(deck);
		List<Card>gamer1 = new ArrayList<>();
		List<Card>gamer2 = new ArrayList<>();
		for(int i=0;i<14;i++)
		{
			if(i%2==1)
				gamer1.add(deck.get(0));
			else
				gamer2.add(deck.get(0));
			deck.remove(0);
		}
		/*
		 *getting the cards from the gamers.
		 *allocating the cards for the two gamers.  
		 */
		play1.receiveInitialCards(gamer1);
		play2.receiveInitialCards(gamer2);
		int i;
		System.out.println("Gamer1 has:");
		for(i=0;i<7;i++)
		{
			System.out.print(gamer1.get(i).getRank()+" "+gamer1.get(i).getSuit()+" ");
			System.out.println(" ");
		}
		System.out.println("____________________");
		System.out.println(" ");
		System.out.println("Gamer2 has:");
		for(i=0;i<7;i++) 
		{
			  System.out.print(gamer2.get(i).getRank()+" "+gamer2.get(i).getSuit()+" ");
			  System.out.println(" ");
		}
		System.out.println("____________________");
		System.out.println();
		return deck;
	}
	/*
	 * this function is to decide the suit of rank "8".
	 * When a player plays an "8", they can declare what suit the next player must play to.
	 * If the player played an "8", this is the suit that they declared.
	 */
	private static int forLoop(gamer2 play2,List<Card> deck,Card topCard, Card.Suit declareCard) 
	{
		if(play2.shouldDrawCard(topCard, declareCard)) 
		{
			if(!deck.isEmpty()) 
			{
				play2.receiveCard(deck.get(0));
				deck.remove(0);
			}
			return 1;
        }
		else 
		{
			topCard=play2.playCard();
			System.out.println("Top card has: "+topCard.getRank()+" "+topCard.getSuit());
			System.out.println(" ");
			if(topCard.getRank()==Card.Rank.EIGHT) 
			{
				declareCard=play2.declareSuit();
			}
			return 0;
		}
	}

	private static int forLoop(gamer1 play1,List<Card> deck,Card topCard, Card.Suit declareCard) 
	{
		if(play1.shouldDrawCard(topCard, declareCard)) 
		{
			if(!deck.isEmpty()) 
			{
				play1.receiveCard(deck.get(0));
				deck.remove(0);
			}
			return 1;
		}
		else 
		{
			topCard=play1.playCard();
			System.out.println(" ");
			System.out.println("Top card has: "+topCard.getRank()+" "+topCard.getSuit());
			System.out.println(" ");
			if(topCard.getRank().equals(Card.Rank.EIGHT)) 
			{
				declareCard=play1.declareSuit();
			}
			return 0;
		}
		
	 }
}

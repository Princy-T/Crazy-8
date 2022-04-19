package cardgame;
import java.util.List;
public class gamer1 implements PlayerStrategy
{
	List<Card> gamer1Cards;
	Card topCard;
	Card.Suit changedSuit;
	public void init(int playerId, List<Integer> opponentIds) 
	{
		
	}
	public void receiveInitialCards(List<Card> cards) 
	{
		this.gamer1Cards=cards;		
	}
	public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) 
	{
		this.topCard=topPileCard;
		this.changedSuit=changedSuit;
		if(changedSuit==null) 
		{
			for(int i=0;i<gamer1Cards.size();i++) 
			{
				if(gamer1Cards.get(i).getSuit().equals(topPileCard.getSuit())||gamer1Cards.get(i).getRank().equals(topPileCard.getRank())) 
				{
					return false;
				}
			}
		}
		else 
		{
			for(int i=0;i<gamer1Cards.size();i++) 
			{
				if(gamer1Cards.get(i).getSuit().equals(changedSuit)) 
				{
					return false;
				}
			}
		}
		return true;
	}
	public void receiveCard(Card drawnCard) 
	{
		System.out.println("Gamer2 recieved from Deck:"+drawnCard.getRank()+" "+drawnCard.getSuit());
		gamer1Cards.add(drawnCard);
		System.out.println(" ");
	}
	public Card playCard() 
	{
		int max=Card.Rank.ACE.ordinal();
		Card finalCard=null;
		if(changedSuit==null) 
		{
			for(int i=0;i<gamer1Cards.size();i++) 
			{
				if(gamer1Cards.get(i).getSuit().equals(topCard.getSuit())||gamer1Cards.get(i).getRank().equals(topCard.getRank())) 
				{
					if(gamer1Cards.get(i).getRank().ordinal()>=max) 
					{
						max=gamer1Cards.get(i).getRank().ordinal();
						finalCard=gamer1Cards.get(i);
					}
					System.out.println("Gamer1 placed: "+finalCard.getRank()+" "+finalCard.getSuit());
					finalCard=gamer1Cards.get(i);
					gamer1Cards.remove(finalCard);
					break;
				}
			}
		}
		else 
		{
			for(int i=0;i<gamer1Cards.size();i++) 
			{
				if(gamer1Cards.get(i).getSuit().equals(changedSuit)) 
				{
					System.out.println("Gamer1 placed: "+gamer1Cards.get(i).getRank()+" "+gamer1Cards.get(i).getSuit());
					finalCard=gamer1Cards.get(i);
					gamer1Cards.remove(i);
					break;
				}
			}
		}
		return finalCard;
	}
	public Card.Suit declareSuit()
	{
		// TODO Auto-generated method stub
		int max=Card.Rank.ACE.ordinal();
		Card.Suit declareSuit=null;
		for(int i=0;i<gamer1Cards.size();i++) 
		{
			if(gamer1Cards.get(i).getRank().ordinal()>=max ) 
			{
				max=gamer1Cards.get(i).getRank().ordinal();
				declareSuit=gamer1Cards.get(i).getSuit();
			}
		}
		System.out.println("SUIT declared : "+declareSuit);
		System.out.println(" ");
		return declareSuit;
	}
	public void processOpponentActions(List<PlayerTurn> opponentActions) 
	{
		
	}
	public void reset() 
	{
		 
	}
	@Override
	public int getScore(int grade) 
	{
			for(int i=0;i<gamer1Cards.size();i++) 
			{
				if(grade<=200)
				grade+=gamer1Cards.get(i).getPointValue();
			}
			return grade;
	}
}
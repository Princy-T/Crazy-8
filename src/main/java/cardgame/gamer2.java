package cardgame;

import java.util.List;

public class gamer2 implements PlayerStrategy{
	List<Card> gamer2Cards;
	Card topCard;
	Card.Suit changedSuit;
	public void init(int playerId, List<Integer> opponentIds) {
		
	}
	public void receiveInitialCards(List<Card> cards) {
		this.gamer2Cards=cards;
			
	}
	public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
		this.topCard=topPileCard;
		this.changedSuit=changedSuit;
		if(changedSuit==null) {
			for(int i=0;i<gamer2Cards.size();i++) {
				if(gamer2Cards.get(i).getSuit().equals(topPileCard.getSuit())||gamer2Cards.get(i).getRank().equals(topPileCard.getRank())) {
					return false;
				}
			}
		}
		else {
			for(int i=0;i<gamer2Cards.size();i++) {
				if(gamer2Cards.get(i).getSuit().equals(changedSuit)) {
					return false;
				}
			}
		}
		return true;
		
	}
	public void receiveCard(Card drawnCard) {
		System.out.println("Gamer2 recieved from Deck:"+drawnCard.getRank()+" "+drawnCard.getSuit());
		gamer2Cards.add(drawnCard);
		System.out.println(" ");
	}
	
	
	
	
	public Card playCard() {
		int max=0,count=0;
		Card finalCard=null;
		if(changedSuit==null) {
			for(int i=0;i<gamer2Cards.size();i++) {
				count=0;
				if(topCard.getSuit().equals(gamer2Cards.get(i).getSuit()) || topCard.getRank().equals(gamer2Cards.get(i).getRank())) {
					for(int j=0;j<gamer2Cards.size();j++) {
						if(gamer2Cards.get(i).equals(gamer2Cards.get(j))) {
							count++;
						}
					}
				}
				if(count>max) 
				{
					max=count;
					finalCard=gamer2Cards.get(i);
					break;
				}
			}
		}
		else {
			for(int i=0;i<gamer2Cards.size();i++) {
				if(changedSuit.equals(gamer2Cards.get(i).getSuit()) ) {
					for(int j=0;j<gamer2Cards.size();j++) {
						if(gamer2Cards.get(i).equals(gamer2Cards.get(j))) {
							count++;
						}
					}
				}
				if(count>max) {
					max=count;
					finalCard=gamer2Cards.get(i);
					break;
				}
			}
		}
		System.out.println("Gamer2 placed: "+finalCard.getRank()+" "+finalCard.getSuit());
		System.out.println(" ");
		gamer2Cards.remove(finalCard);
		return finalCard;
}
	
	
	
	
	public Card.Suit declareSuit(){
		// TODO Auto-generated method stub
				int max=Card.Rank.KING.ordinal();
				Card.Suit declareSuit=null;
				for(int i=0;i<gamer2Cards.size();i++) {
					if(gamer2Cards.get(i).getRank().ordinal()<=max ) {
						max=gamer2Cards.get(i).getRank().ordinal();
						declareSuit=gamer2Cards.get(i).getSuit();
					}
				}
				System.out.println("SUIT declared: "+declareSuit);
				System.out.println(" ");
				return declareSuit;

		
	}
	public void processOpponentActions(List<PlayerTurn> opponentActions) {
		
	}
	 public void reset() {
		 
	 }
	 @Override
		public int getScore(int grade) {
			for(int i=0;i<gamer2Cards.size();i++) {
				if(grade<=200)
					grade+=gamer2Cards.get(i).getPointValue();
			}
			return grade;
		}
}





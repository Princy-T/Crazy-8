package cardgame;
import java.util.List;
import java.util.ArrayList;
public class game 
{
	public static void main(String[] args) 
	{     
		HelperFunction gameobj=new HelperFunction();   
		List<Card> Deck = new ArrayList<>();
		gamer1 play1 = new gamer1();
		gamer2 play2 = new gamer2();
		Deck=gameobj.startReStart(Deck,play1,play2);
		gameobj.gamePlay(Deck, play1, play2);  
	}
}

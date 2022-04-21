package cardgame;
import java.util.List;
import java.util.ArrayList;
public class Game 
{
	public static void main(String[] args) 
	{     
		HelperFunction gameobj=new HelperFunction();   
		List<Card> deck = new ArrayList<>();
		gamer1 play1 = new gamer1();
		gamer2 play2 = new gamer2();
		deck=gameobj.startReStart(deck,play1,play2);
		gameobj.gamePlay(deck, play1, play2);  
	}
}

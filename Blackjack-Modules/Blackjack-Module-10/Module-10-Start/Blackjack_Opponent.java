import java.io.*; 
import java.util.*;

public class Blackjack_Opponent{

	public ArrayList <Blackjack_Cards> currentCards = new ArrayList<Blackjack_Cards>();
	public int score = 0;
	public int totalCardValue = 0;

	public void setTotalCardValue(){
		boolean recount = true;
		while(recount == true){
			totalCardValue = 0;
			recount = false;
			for(Blackjack_Cards eachCard : currentCards)
				totalCardValue += eachCard.cardValue;

			for(Blackjack_Cards eachCard : currentCards){
				if(eachCard.card == "ace" && eachCard.cardValue == 11 && totalCardValue >21){
					eachCard.cardValue = 1;
					recount = true;
					break;
				}
			}
		}

	}
}
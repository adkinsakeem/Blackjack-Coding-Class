import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Image;


public class Blackjack_Cards{

	public String cardFront;
	public String cardSuit;
	public String card;
	public int cardValue;

	public void setCardValue(int cValue){
		if(cValue > 10){
			cValue = 10;
		}

		if(cValue == 1){
			cValue = 11;
		}
		
		cardValue = cValue;
	}
}

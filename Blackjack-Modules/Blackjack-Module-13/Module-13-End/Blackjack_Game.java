import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.BufferedImage;


public class Blackjack_Game extends JPanel{

	public static JButton play = new JButton();
	public static JLabel playerText = new JLabel("This is the player's side");
	public static JLabel opponentText = new JLabel("This is the opponent's side");
	public static final String[] Value = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	public static final String[] Suit = {"hearts", "diamonds", "clubs", "spades"};
	public static Blackjack_Player Player = new Blackjack_Player();
	public static Blackjack_Opponent Opponent = new Blackjack_Opponent();
	public static int playerCardCount = 0;
	public static int opponentCardCount = 0;
	public static JPanel playersCards = new JPanel();
	public static JPanel opponentsCards = new JPanel();
	public static ArrayList <JLabel> playerSingleCards = new ArrayList<JLabel>(); 
	public static ArrayList <JLabel> opponentSingleCards = new ArrayList<JLabel>();
	public static JButton hitButton = new JButton("Hit Me");
	public static JButton standButton = new JButton("Stand");
	public static JLabel yourScore = new JLabel("");
	public static JLabel opponentsScore = new JLabel("");



	public static void main(String[] args){

//***Create the Game Window******************************************************************************************
		int frameWidth = 421;
		int frameHeight = 590;
		JFrame frame = new JFrame("BlackJack");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gameLayout = new GridBagLayout();
		GridBagConstraints gameConstraints = new GridBagConstraints();
		frame.setSize(frameWidth, frameHeight);
		JLabel background;
		frame.setResizable(false);
//******************************************************************************************************************



//***Create Background**********************************************************************************************
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/LongBlackjackTable.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setLayout(gameLayout);
//*****************************************************************************************************************
		playersCards.setMinimumSize(new Dimension(428, 222));
		opponentsCards.setMinimumSize(new Dimension(428, 222));
		yourScore.setMinimumSize(new Dimension(239,25));
		opponentsScore.setMinimumSize(new Dimension(239,25));
		yourScore.setPreferredSize(new Dimension(239,25));
		opponentsScore.setPreferredSize(new Dimension(239,25));
//*** Set Up Board************************************************************************************************
//****************************************************************************************************************

//*** Block 1 Start ******************************************
		gameConstraints.weightx = 0.5;
		gameConstraints.weighty = 0.5;
		gameConstraints.gridx = 0;
		gameConstraints.gridy = 0;
		gameConstraints.gridwidth = 3;
		frame.add(yourScore, gameConstraints);
//*** Block 1 End ********************************************


//*** Block 1.5 Start ****************************************
		gameConstraints.gridx = 3;
		frame.add(opponentsScore, gameConstraints);
//*** Block 1.5 End ******************************************




//*** Block 2 Start ******************************************
		gameConstraints.ipadx = 0;
		gameConstraints.fill = GridBagConstraints.HORIZONTAL;
		gameConstraints.gridwidth = 6;
		gameConstraints.gridx = 0;
		gameConstraints.gridy = 1;
		gameConstraints.weighty = 0.0;
		frame.add(opponentText, gameConstraints);

//*** Block 2 End ********************************************




//*** Block 3 Start ******************************************
		gameConstraints.gridy = 2;
		opponentsCards.setOpaque(false);
		frame.add(opponentsCards, gameConstraints);
//*** Block 3 End ********************************************




//*** Block 4 Start ******************************************
		play.setText("Start Game");
		gameConstraints.fill = GridBagConstraints.CENTER;
		gameConstraints.ipady = 30;
		gameConstraints.gridwidth = 2;
		gameConstraints.gridx = 2;
		gameConstraints.gridy = 3;
		frame.add(play, gameConstraints);
//*** Block 4 End ********************************************




//*** Block 5 Start ******************************************
		gameConstraints.fill = GridBagConstraints.HORIZONTAL;
		gameConstraints.ipady = 0;
		gameConstraints.gridwidth = 6;
		gameConstraints.gridx = 0;
		gameConstraints.gridy = 4;
		frame.add(playerText, gameConstraints);

//*** Block 5 End ********************************************





//*** Block 6 Start ******************************************
		gameConstraints.gridy = 5;
		playersCards.setOpaque(false);
		frame.add(playersCards, gameConstraints);
//*** Block 6 End ********************************************




//*** Block 7 Start ******************************************
		gameConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		gameConstraints.gridwidth = 2;
		gameConstraints.gridy = 6;
		gameConstraints.ipady = 10;
		frame.add(hitButton, gameConstraints);
		hitButton.setVisible(false);
//*** Block 7 End ********************************************


//*** Block 7.5 Start ****************************************
		gameConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		gameConstraints.gridx = 4;
		frame.add(standButton, gameConstraints);
		standButton.setVisible(false);
//*** Block 7.5 End ******************************************


//***Formatting***********************************************
		opponentText.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		opponentText.setHorizontalAlignment(JLabel.CENTER);
		opponentText.setOpaque(true);
		opponentText.setBackground(Color.RED);
		opponentText.setForeground(Color.BLUE);
		playerText.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		playerText.setHorizontalAlignment(JLabel.CENTER);
		playerText.setOpaque(true);
		playerText.setBackground(Color.RED);
		playerText.setForeground(Color.BLUE);

		yourScore.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		yourScore.setOpaque(true);
		yourScore.setBackground(Color.WHITE);
		yourScore.setForeground(Color.BLUE);
		opponentsScore.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		opponentsScore.setOpaque(true);
		opponentsScore.setBackground(Color.WHITE);
		opponentsScore.setForeground(Color.BLUE);

		setScore();
//************************************************************

		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				play.setVisible(false);
				hitButton.setVisible(true);
				standButton.setVisible(true);

				String dealTo = "player";

				for(int num1=0; num1 < 4; num1++){
					generateCard(dealTo);
					if(dealTo.equals("player")){
						dealTo = "opponent";
					}else if(dealTo.equals("opponent")){
						dealTo = "player";
					}
				}

			}
		});

		hitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				generateCard("player");
			}

		});

		standButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stand();						
			}

		});




	}

	public static void generateCard(String dealTo){
		Random rand = new Random();
		boolean duplicateCard = false;
		int randCardNum;
		int randSuit;
		String newCard;

		do{
			randCardNum = rand.nextInt(13);
			randSuit = rand.nextInt(4);
			duplicateCard = false;
			newCard = "images\\png\\" + Value[randCardNum] + "_of_" + Suit[randSuit] + ".png";


			for(Blackjack_Cards playerArray : Player.currentCards){
				if(playerArray.cardFront == newCard){
					duplicateCard = true;
				}
			}

			for(Blackjack_Cards opponentArray : Opponent.currentCards){
				if(opponentArray.cardFront == newCard){
					duplicateCard = true;
				}
			}





		}while (duplicateCard == true);

		Blackjack_Cards Card = new Blackjack_Cards();
		Card.cardFront = newCard;
		Card.cardSuit = Suit[randSuit];
		Card.card = Value[randCardNum];
		Card.setCardValue(randCardNum + 1);

		try{
			if(dealTo.equals("player")){
				Player.currentCards.add(Card);
				BufferedImage cardImage = ImageIO.read(new File(Player.currentCards.get(playerCardCount).cardFront));
				playerSingleCards.add(new JLabel(new ImageIcon(cardImage)));
				playersCards.add(playerSingleCards.get(playerCardCount));

				playerCardCount++;

			}else if(dealTo.equals("opponent")){
				Opponent.currentCards.add(Card);
				BufferedImage cardImage = ImageIO.read(new File(Opponent.currentCards.get(opponentCardCount).cardFront));
				opponentSingleCards.add(new JLabel(new ImageIcon(cardImage)));
				opponentsCards.add(opponentSingleCards.get(opponentCardCount));
				opponentCardCount++;
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		calculateCurrentValue();

	}

	public static void calculateCurrentValue(){
		Opponent.setTotalCardValue();
		Player.setTotalCardValue();


		opponentText.setText("Your opponent currently has " + Opponent.totalCardValue);
		playerText.setText("You currently have " + Player.totalCardValue);

		playersCards.repaint();
		playersCards.revalidate();
	}

	public static void stand(){
		while(Opponent.totalCardValue < 16){
			generateCard("opponent");
		}

	}

	public static void setScore(){
		yourScore.setText("Your Wins: " + Player.score);
		opponentsScore.setText("Opponents Wins: " + Opponent.score);

	}
}


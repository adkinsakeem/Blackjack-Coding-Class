import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.BufferedImage;


public class Blackjack_Game extends JPanel{

public static JButton play = new JButton();

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




//*** Set Up Board************************************************************************************************
//****************************************************************************************************************

//*** Block 1 Start ******************************************
gameConstraints.weightx = 0.5;
gameConstraints.weighty = 0.5;
gameConstraints.gridx = 0;
gameConstraints.gridy = 0;
gameConstraints.gridwidth = 3;
//*** Block 1 End ********************************************


//*** Block 1.5 Start ****************************************
gameConstraints.gridx = 3;
//*** Block 1.5 End ******************************************




//*** Block 2 Start ******************************************
gameConstraints.ipadx = 0;
gameConstraints.fill = GridBagConstraints.HORIZONTAL;
gameConstraints.gridwidth = 6;
gameConstraints.gridx = 0;
gameConstraints.gridy = 1;
gameConstraints.weighty = 0.0;
//*** Block 2 End ********************************************




//*** Block 3 Start ******************************************
gameConstraints.gridy = 2;
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
//*** Block 5 End ********************************************





//*** Block 6 Start ******************************************
gameConstraints.gridy = 5;
//*** Block 6 End ********************************************




//*** Block 7 Start ******************************************
gameConstraints.anchor = GridBagConstraints.LAST_LINE_START;
gameConstraints.gridwidth = 2;
gameConstraints.gridy = 6;
gameConstraints.ipady = 10;
//*** Block 7 End ********************************************


//*** Block 7.5 Start ****************************************
gameConstraints.anchor = GridBagConstraints.LAST_LINE_END;
gameConstraints.gridx = 4;
//*** Block 7.5 End ******************************************



play.addMouseListener(new MouseAdapter() {
	@Override
 public void mouseClicked(MouseEvent e) {
 	play.setVisible(false);
 	
 }
});


	}
}

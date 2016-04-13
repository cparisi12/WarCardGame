import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics;
import java.util.Random;

//Card class takes care of the graphics involved with creating
//the cards in the window
public class Cards {

	//x and y coordinates for the card location
	private int x; 
	private int y;
	//height and width of cards
	private final int width = 80, height = 100; 

	//card constructor
	public void setup(int someX, int someY){
		x = someX;
		y = someY;
	}

	//variable to weigh the value of the card played
	int weight;
	//string containing the suit of the card
	String Suit = "";

	//array with all the numeric card values
	int[] Values = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	//array with all the card suits
	String[] Suits = new String[]{"clubs", "hearts", "spades", "diamonds"};


	public int getValue(){ 

		//random value selected between bounds of suits array
		int randomValue = new Random().nextInt(Values.length);
		//get a value from the Values array and sets it to weight
		weight = Values[randomValue];
		return weight;
	}


	public void getSuit(){ 

		//random suit is selected between bounds of Suits array
		int randomSuit = new Random().nextInt(Suits.length); 
		//added to suit
		Suit = Suits[randomSuit]; 
	}


	public void drawFaceDown(Graphics pane){ 

		//draws face down card
		pane.setColor(Color.black); 
		pane.drawRect(x, y, width, height);
		pane.setColor(Color.green);
		pane.fillRect(x, y, width, height);
		//draws design on back of card
		pane.setColor(Color.black); 
		pane.fillArc(x+30, y+30, 20, 20, 0, 180);
		pane.fillArc(x+30, y+50, 20, 20, 0, -180);
	}


	public void drawBlank(Graphics pane){ 

		//draws blank card where face values will appear
		pane.setColor(Color.white);
		pane.drawRect(x, y + 120, width, height);
		pane.fillRect(x, y + 120, width, height); 
	}

	//method that draws the value on the card
	public void drawWeight(Graphics pane){ 

		//text font
		pane.setFont(new Font("Arial Black", 20, 20)); 
		//text color
		pane.setColor(Color.black); 
		//a string will be drawn depending on the value given to weight
		//drawn in upper left and bottom right corners of face up card
		if (weight == 0){
			pane.drawString("2", x + 5, y + 140);
			pane.drawString("2", x + 60, y + 215);
		}
		else if (weight == 1){
			pane.drawString("3", x + 5, y + 140);
			pane.drawString("3", x + 60, y + 215);
		}
		else if (weight == 2){
			pane.drawString("4", x + 5, y + 140);
			pane.drawString("4", x + 60, y + 215);
		}
		else if (weight == 3){
			pane.drawString("5", x + 5, y + 140);
			pane.drawString("5", x + 60, y + 215);
		}
		else if (weight == 4){
			pane.drawString("6", x + 5, y + 140);
			pane.drawString("6", x + 60, y + 215);
		}
		else if (weight == 5){
			pane.drawString("7", x + 5, y + 140);
			pane.drawString("7", x + 60, y + 215);
		}
		else if (weight == 6){
			pane.drawString("8", x + 5, y + 140);
			pane.drawString("8", x + 60, y + 215);
		}
		else if (weight == 7){
			pane.drawString("9", x + 5, y + 140);
			pane.drawString("9", x + 60, y + 215);
		}
		else if (weight == 8){
			pane.drawString("10", x + 5, y + 140);
			pane.drawString("10", x + 50, y + 215);
		}
		else if (weight == 9){
			pane.drawString("J", x + 5, y + 140);
			pane.drawString("J", x + 60, y + 215);
		}
		else if (weight == 10){
			pane.drawString("Q", x + 5, y + 140);
			pane.drawString("Q", x + 60, y + 215);
		}
		else if (weight == 11){
			pane.drawString("K", x + 5, y + 140);
			pane.drawString("K", x + 60, y + 215);
		}
		else if (weight == 12){
			pane.drawString("A", x + 5, y + 140);
			pane.drawString("A", x + 60, y + 215);
		}
	}

	//draws the suit on the card
	public void drawSuit(Graphics pane){ 
		//suit font
		pane.setFont(new Font("arial", 50, 40));
		//a string is drawn depending on which suit is selected
		//suit is drawn in the center and drawn using unicode
		if (Suit == "hearts"){
			pane.setColor(Color.red);
			pane.drawString("\u2764", x + 27, y + 185);
		}
		else if (Suit == "clubs"){
			pane.setColor(Color.black);
			pane.drawString("\u2663", x + 27, y + 185);
		}
		else if (Suit == "diamonds"){
			pane.setColor(Color.red);
			pane.drawString("\u2666", x + 27, y + 185);
		}
		else if (Suit == "spades"){
			pane.setColor(Color.black);
			pane.drawString("\u2660", x + 27, y + 185);
		}
	}

	public void drawCard(Graphics pane){ 
		//calls drawBlank, drawRank, and drawSuit
		drawBlank(pane);
		drawWeight(pane); 
		drawSuit(pane); 
	}

}
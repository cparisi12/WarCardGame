/**
 * The game class takes care of the details regarding the window
 * as well as extends the frame. Also this class creates the computer 
 * card, user card, and rates the value of the two cards to score
 * the game.
 * 
 */
import java.awt.*; //imports awt
import java.awt.Frame; //imports frame
import java.awt.Graphics; //imports graphics
import java.awt.event.MouseEvent; //imports mouse event
import java.awt.event.MouseListener; //imports mouse listener

//extends frame and implements MouseListener
public class Game extends Frame implements MouseListener{ 


	//x and y coordinates for card
	private int x, y; 
	//stores the value of the users card
	private int myNum; 
	//stores the value of the computers card
	private int comNum; 
	//counter for displaying cards face up
	private int counter = -1; 
	//tie counter
	int tieCount = 0; 
	//score counter
	int score = 0; 
	//play button
	private Abutton play; 
	//reset button
	private Abutton reset;
	//quit button
	private Abutton quit; 
	//creates user's card
	private Cards myCard = new Cards(); 
	//creates CPU's card
	private Cards comCard = new Cards();
	//graph displaying the score
	private ScoreGraph graph; 


	//game constructor
	public Game(){

		//sets the title of the window
		setTitle("War Card Game"); 
		//sets location of window
		setLocation(150, 150); 
		//sets size of window
		setSize(400,400); 
		//sets background color
		setBackground(Color.DARK_GRAY); 
		//sets visibility to true
		setVisible(true); 
		//adds mouse listener
		addMouseListener(this); 

		//creates graph to keep score
		graph = new ScoreGraph(200, 315);

		//creates play button
		play = new Abutton("Play", Color.blue, 160, 340, 60, 50); 
		//creates reset button
		reset = new Abutton("Reset", Color.MAGENTA, 240, 340, 60, 50); 
		//creates quit button
		quit = new Abutton("Quit", Color.cyan, 320, 340, 60, 50); 

	}

	//calls the methods necessary to run the game
	public void playGame(){ 

		//gets the user card value
		myCard.getValue(); 
		//gets the computers card value
		comCard.getValue(); 
		//gets the user card suit
		myCard.getSuit(); 
		//gets computers card suit
		comCard.getSuit(); 
		//stores the value of the users card in myNum
		myNum = myCard.getValue(); 
		//stores the value of the computer card in comNum
		comNum = comCard.getValue(); 
		//calls scoreGame method to keep score
		scoreWar(); 

	}

	//paint method to draw the cards and buttons
	public void paint(Graphics pane){ 

		
		//sets font of text
		pane.setFont(new Font("Impact", 30, 30)); 
		//sets color of text
		pane.setColor(Color.yellow); 
		//draws a title string
		pane.drawString("The Game of WAR", 95, 50); 
		pane.setFont(new Font("Impact", 20, 20)); 
		//prints Score right above the graph
		pane.drawString("Score", 175, 305); 
		pane.setFont(new Font("Impact", 15, 15));
		//prints my name in the bottom left corner
		pane.drawString("By: Chris Parisi", 30, 380);
		
		//user card gets setup
		myCard.setup(250, 70); 
		//computer card gets setup
		comCard.setup(70, 70); 
		//draws face down user card
		myCard.drawFaceDown(pane); 
		//draws face down computer card
		comCard.drawFaceDown(pane); 
		//paints the play button
		play.paint(pane); 
		//paints the reset button
		reset.paint(pane);
		//paints the quit button
		quit.paint(pane); 
		//paints the graph
		graph.paint(pane, score);
		//loop to paint every user and computer card drawn
		int i = 0;
		while(i <= counter) { 
			myCard.drawCard(pane);
			comCard.drawCard(pane);
			i++;
		}

	}



	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	//runs war when play is clicked and flips reset button when clicked
	public void mouseClicked(MouseEvent event) { 
		//the game is run if the play button is clicked
		if(play.isInside(x, y)){ 
			play.flip();
			repaint();
			counter++;
			playGame();
		}
		//the game restarts if the reset button is clicked
		if(reset.isInside(x, y)){
			reset.flip();
			repaint();
		}
	}
	
	//restarts window if reset button is pressed
	//exits window if quit button is pressed
	public void mousePressed(MouseEvent event) { 
		x = event.getX();
		y = event.getY();
		//if the reset button is pressed the window restarts
		if(reset.isInside(x, y)){ 
			reset.flip();
			repaint();
			counter = -1;
			score = 0;
		}
		//if the quit button is clicked the window closes
		else if(quit.isInside(x, y)){ 
			System.exit(0);
		}
	}

	//flips play button 
	public void mouseReleased(MouseEvent event) {
		if(play.isInside(x, y)){ 
			play.flip();
			repaint();
		}
	}

	//method to calculate the score
	public void scoreWar(){ 

		//score increases in users favor if the user wins
		if (myNum > comNum){
			score += Math.pow(2, tieCount);
			tieCount = 0;
		}

		//score decreases for user if user loses
		if (myNum < comNum){ 
			score -= Math.pow(2, tieCount);
			tieCount = 0;
		}

		//if there is a tie the tie counter is incremented
		else{ 
			tieCount++;
		}
	}
}

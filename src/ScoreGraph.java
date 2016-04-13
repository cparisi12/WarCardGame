
import java.awt.*;
import java.awt.Color; //imports color
import java.awt.Graphics; //imports graphics

//the ScoreGraph class takes care of everything needed to make
//the bar graph which scores the game
public class ScoreGraph {
	//x and y coordinates for the graph display
	private int x; 
	private int y; 
	//width of the bars in the graph
	private static final int WIDTH = 10; 
	//height of the bars in the graph
	private static final int HEIGHT = 15;
	
	//bar graph constructor 
	public ScoreGraph(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	//paint method that paints different bars in the graph
	//depending on the score when each card is played
	public void paint(Graphics pane, int score){ 
		
		//adds another block to the width depending on the score
		int width = score*WIDTH;
		
		//if the user wins it draws the bars of the left side 
		if (score >= 0){ 
			pane.setColor(Color.red);
			pane.drawRect(x , y, width, HEIGHT);
			pane.fillRect(x, y, width, HEIGHT);
		}
		//if the user loses it draws bars on the right side 
		else { 
			pane.setColor(Color.blue);
			pane.drawRect(x + width, y, Math.abs(width), HEIGHT);
			pane.fillRect(x + width, y, Math.abs(width), HEIGHT);
		}
	}
}
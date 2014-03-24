// Class Name: Ornament
// 
// Author: Padyana Uday Krishna
// 
// Collaborators and/or supporting material: 
// 
// Description of the class: This Class defines a decorative oval ornament that can be of any given color and in any given position.
// 
// Supplementary files: We need to import java.awt files , java.util, java.random, java.swing (not all but selected).
// 
//************************************************************************* 

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ornament extends JPanel{
	private int xPos, yPos;
	private Color clr = Color.RED;
	private final int WIDTH = 15;
	private final int POS = 250;
	private boolean vis = true;
	
	/*Create Ornament - randomly placed*/
	public Ornament(){
		Random r = new Random();
		xPos = r.nextInt(POS);
		yPos = r.nextInt(POS);	
		clr = Color.RED;
	}
	
	/*Create Ornament - Position and Color given*/
	public Ornament(int x, int y, Color c){
		xPos = x;
		yPos = y;
		clr = c;
		
	}
	
	/* Draw Ornament*/
	public void draw (Graphics g){
		
		/* If visibility is true*/
		if(vis==true)
		{
		g.setColor(clr);
	 	g.fillOval(xPos, yPos, WIDTH, WIDTH);	
	 	
		}
	}
	
	/* Set the Visibility of the Ornaments*/
	public void setVisible(boolean v)
	{
		vis=v;

	}
	
}

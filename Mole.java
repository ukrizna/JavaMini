// Class Name: Mole
// 
// Author: Padyana Uday Krishna
// 
// Collaborators and/or supporting material: SI 543 Class Material
// 
// Description of the class: This Class defines a Mole and makes it move, checks if it is clicked on and also gives the hits and miss count based on the clicks.
// 
// Supplementary files: We need to import java.awt Color , Graphics, Random, Polygon
// 
//************************************************************************* 


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Polygon;


public class Mole {
	
	private int xPos, yPos;
	private int moveX, moveY;
	private final int OFFSET = 150;
	private boolean vis = false;
	private Color clr = Color.GRAY;
	private Polygon p1;
	private final int WIDTH = 14;
	private final int HALF = 2;
	private int hit = 0,miss = 0;
	private int ARC_ANGLE = 180;

	

	
	public Mole(int x, int y){
		
		/*Set the x and y position of the Mole*/
		xPos = x;
		yPos = y;
			
	}
	
	public void move(double d1, double d2){
	
		
		/* Random number generation if the x and y position is less than 0 or more than the screen size*/
		if(xPos<=10 || yPos <=10 || xPos > (((int)d1 - OFFSET)) || yPos > ((int)d2 - OFFSET))
		{
			Random range = new Random();
			xPos = range.nextInt((int)(d1/HALF));
			yPos = range.nextInt((int)(d2/HALF));
		}
		
		else{
			
			Random range2 = new Random();
			moveX = range2.nextInt((int)(d1 - OFFSET));
			moveY = range2.nextInt((int)(d2 - OFFSET));
			xPos = moveX;
			yPos = moveY;
			
			System.out.println(yPos);
			System.out.println ((int)d2 - OFFSET);
			
		}
		

	}
	
	
	public void clickedOn(int x, int y){
		
		/* If the Mole is visible*/
		if(vis==true){
			
			/* If the click is within the range of the Polygon*/
			if(p1.contains(x,y)){
				/*count it as a hit*/
				hit++;
				
			}
			
			/* If the click is not within the range of the Polygon*/
			else{
				/*count it as a miss*/
				miss++;
			
			}
		}
		
		/* If the Mole is not visible*/
		else{
			/*count it as a miss*/
			miss++;
		}
	
	}
	

	public void draw (Graphics g){
		
		/* if the Mole is visible*/
		if(vis==true){
	
			int[] xArr = {xPos, xPos, xPos+70, xPos+70};
			int[] yArr = {yPos, yPos+70, yPos+70, yPos};
		
			g.setColor(clr);
			p1 = new Polygon(xArr, yArr, 4);
			g.fillPolygon(xArr, yArr, 4);
				
			g.setColor(Color.white);
		 	g.fillOval(xPos+12, yPos+10, WIDTH, WIDTH);
		 	
	 		g.setColor(Color.white);
	 		g.fillOval(xPos+40, yPos+10, WIDTH, WIDTH);
	 		
		 	g.setColor(Color.black);
		 	g.fillOval(xPos+15, yPos+13, WIDTH/HALF, WIDTH/HALF);
		 		
	 		g.setColor(Color.black);
	 		g.fillOval(xPos+43, yPos+13, WIDTH/HALF, WIDTH/HALF);
	 	
	 		g.setColor(Color.pink);
	 		g.fillArc(xPos+9, yPos+30, 50, 30, -ARC_ANGLE, ARC_ANGLE);
	 		
	 		g.setColor(Color.white);
	 		g.fillRect(xPos+20, yPos+45, 4, 6);
	 	
	 		g.setColor(Color.white);
	 		g.fillRect(xPos+40, yPos+45, 4, 6);
		}
	
		
	}
	
	/*Get the Count of the Misses*/
	public int getMissCount(){
		return miss;
	}
	
	/*Get the Count of the Hits*/
	public int getHitCount(){
		return hit;
	}
	
	/* Set the Visibility of the Ornaments*/
	public void setVisible(boolean v)
	{
		vis=v;
		
	}

}


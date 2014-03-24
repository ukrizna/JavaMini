// Class Name: TreePanel
// 
// Author: Padyana Uday Krishna
// 
// Collaborators and/or supporting material: 
// 
// Description of the class: This Class defines a decorative a panel with a holiday tree and 4 buttons using which one can add ornaments to the tree and control a light show.
// 
// Supplementary files: We need to import java.awt.* files, java.util, java.random and java.swing(not all but selected).
// 
// List of errors that can be expected:
//										
// Expected score: 100.0
//************************************************************************* 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Random;
import java.awt.Polygon;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Timer;


public class TreePanel extends JPanel implements MouseListener, ActionListener {

		private int xPos, yPos;
		private Polygon p1, p2;
		private Color TreeClr,TrunkClr, OrnClr = Color.RED;
		private final int BLINK_DELAY = 100;
		private Timer timer1;
		private ArrayList<Ornament> Ornlist = new ArrayList<Ornament>();
		private boolean blinkState=false;
		private final int WIDTH_SIZE = 625, HEIGHT_SIZE = 625;
		private int count = 0;
		private int[] xArr1, yArr1, xArr2, yArr2;
		private String[] texts = { "Blue", "Red", "Start", "Stop"};
		private JPanel top;
		private JButton button;
		
		public TreePanel(){
			
			this.setPreferredSize(new Dimension(WIDTH_SIZE,HEIGHT_SIZE));
			TreeClr = Color.green;
			TrunkClr = Color.black;
			addMouseListener(this);
			
			/* Add the Buttons*/
			top = new JPanel();
			add(top, BorderLayout.NORTH);
			top.setLayout(new FlowLayout(FlowLayout.LEADING));
			for (int i = 0; i < texts.length; i++){
				top.add(button = new JButton(texts[i]));
				button.addActionListener(this);
			}

		}
		
		public void paintComponent (Graphics g){
			
			super.paintComponent(g);
			this.setBackground(Color.YELLOW);
			xPos=this.getWidth()/2;
			yPos=this.getHeight()/2;
			
			/*Define the points for Tree and Trunk*/
			int[] xArr1 = {xPos, xPos, xPos+10, xPos+10};
			int[] yArr1 = {yPos, yPos-20, yPos-20, yPos};
			int[] xArr2 = {xPos-100, xPos-60, xPos-80, xPos-20, xPos-40, xPos+5, xPos+45, xPos+20, xPos+80, xPos+60, xPos+100};
			int[] yArr2 = {yPos-20, yPos-50, yPos-50, yPos-80, yPos-80, yPos-110, yPos-80, yPos-80, yPos-50, yPos-50, yPos-20};
			
			/*Draw the Tree*/
			g.setColor(TreeClr);
			p2 = new Polygon(xArr2, yArr2, 11);
			g.fillPolygon(xArr2, yArr2, 11);
			
			/*Draw the Trunk*/
			g.setColor(TrunkClr);
			p1 = new Polygon(xArr1, yArr1, 4);
			g.fillPolygon(xArr1, yArr1, 4);

			/* Display the Count*/
			g.drawString("Count "+(count),5,10);
			
			/* Draw the Ornaments*/
			for(Ornament O: Ornlist)
				O.draw(g);
				
			}

		public void mouseClicked(MouseEvent e) {
			
			/* Check for the Polygon region and add ornaments*/
			if (p2.contains(e.getPoint())){
				count++;
				repaint();
				/*Create and add Ornament*/
				Ornament O = new Ornament(e.getPoint().x, e.getPoint().y, OrnClr);
				Ornlist.add(O);	
			}
		
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}


		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}


		public void mousePressed(MouseEvent arg0) {
			
		}


		public void mouseReleased(MouseEvent arg0) {
		
		}

		public void mouseDragged(MouseEvent e) {
			
		}

		public void mouseMoved(MouseEvent e) {
			
		}

		public void actionPerformed (ActionEvent event){
			/* Check for the button pressed and perform corresponding action*/
			switch(event.getActionCommand()){
				case "Blue":	OrnClr = Color.BLUE;
						break;
				case "Red" :	OrnClr = Color.RED;
						break;
				case "Start":   timer1 = new Timer(BLINK_DELAY,new ActionListener(){
									public void actionPerformed(ActionEvent e) {
										blinkState=!blinkState;
										for(int i=0;i<Ornlist.size();i++){						
											Ornlist.get(i).setVisible(blinkState);
											repaint();
										}
									}
								});
								timer1.setInitialDelay(0);
								timer1.start();
								
								break;
						
				case "Stop":   	timer1.stop();
									for(int i=0; i<Ornlist.size();i++){
										Ornlist.get(i).setVisible(true);
									}
								repaint();
								break;
						
				default    :	OrnClr = Color.RED;
	    						break;
		
			}

		}
		
		public static void main(String[] args) {
			JFrame frame = new JFrame ("DECORATE IT");
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			
			frame.getContentPane().add(new TreePanel());

			frame.pack();
			frame.setVisible(true);
		}		

}

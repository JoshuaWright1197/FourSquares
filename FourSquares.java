package FourSquares;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class FourSquares extends JPanel
{
	//Declare class variables
	private int xG;
	private int yG;
	private int xB;
	private int yB;
	private int xR;
	private int yR;
	private int xY;
	private int yY;
	private boolean greenSquare;
	private boolean blueSquare;
	private boolean redSquare;
	private boolean yellowSquare;
    private ArrayList<Integer> GreenlistX;
    private ArrayList<Integer> GreenlistY;
    private ArrayList<Integer> BluelistX;
    private ArrayList<Integer> BluelistY;
    private ArrayList<Integer> redlistX;
    private ArrayList<Integer> redlistY;
    private ArrayList<Integer> yellowlistX;
    private ArrayList<Integer> yellowlistY;
	
    public FourSquares()
    {
    	
    	super();	
	   
    	greenSquare = false;
    	blueSquare = false;
    	redSquare = false;
    	yellowSquare = false;
    	
    	GreenlistX = new ArrayList<Integer>();
    	GreenlistY = new ArrayList<Integer>();
    	BluelistX = new ArrayList<Integer>();
    	BluelistY = new ArrayList<Integer>();
    	redlistX = new ArrayList<Integer>();
    	redlistY = new ArrayList<Integer>();
    	yellowlistX = new ArrayList<Integer>();
    	yellowlistY = new ArrayList<Integer>();
    	

	   	xG = 10;
	   	yG = 10;    
	   	
	   	xB = 60;
	   	yB = 10;   
	   	
	   	xR = 110;
	   	yR = 10;
	   	
		xY = 160;
	   	yY = 10;
	   
	   	setBackground(Color.white);  
      
	   	Dragger listener = new Dragger();
  	  	addMouseListener(listener);  	   
  	  	addMouseMotionListener(listener);      
   }   
   
   public void paintComponent(Graphics g)
   {
	  
	   super.paintComponent(g);  
      
	   trace(g);
	   
    
	  g.setColor(Color.green);
      g.fillRect(xG, yG, 30, 30);
     
     
      g.setColor(Color.BLUE);
      g.fillRect(xB, yB, 30, 30);
      
      
      g.setColor(Color.red);
      g.fillRect(xR, yR, 30, 30);
     
     
      g.setColor(Color.yellow);
      g.fillRect(xY, yY, 30, 30);
      
    
	   g.setColor(Color.black);
	   g.drawRect(xG, yG, 30, 30);
	   g.drawRect(xB, yB, 30, 30);
	   g.drawRect(xR, yR, 30, 30);
	   g.drawRect(xY, yY, 30, 30);
	   
   }
   
   
   public void trace(Graphics g)
   {

	   for(int i = 0 ; i < BluelistX.size() && i < BluelistY.size(); i++)
	   {
		   g.setColor(Color.blue);
		   g.fillRect(BluelistX.get(i), BluelistY.get(i), 30, 30);
	   }
	   for(int i = 0 ; i < GreenlistX.size() && i < GreenlistY.size(); i++)
	   {
		   g.setColor(Color.green);
		   g.fillRect(GreenlistX.get(i), GreenlistY.get(i), 30, 30);
	   }
	   for(int i = 0 ; i < redlistX.size() && i < redlistY.size(); i++)
	   {
		   g.setColor(Color.red);
		   g.fillRect(redlistX.get(i), redlistY.get(i), 30, 30);
	   }
	   for(int i = 0 ; i < yellowlistX.size() && i < yellowlistY.size(); i++)
	   {
		   g.setColor(Color.yellow);
		   g.fillRect(yellowlistX.get(i), yellowlistY.get(i), 30, 30);
	   }
   }
   
  
   private class Dragger implements MouseListener, MouseMotionListener
   {
	  public void mousePressed(MouseEvent evt)
      {     	 
    	 int x = evt.getX();  
    	 int y = evt.getY();
         
         if ((x >= xB && x < xB+30) && (y >= yB && y < yB+30))
         {
            blueSquare = true;
            greenSquare = false;
         	redSquare = false;
         	yellowSquare = false;
         }
         else if ((x >= xG && x < xG+30) && (y >= yG && y < yG+30))
         {  
            greenSquare = true;
         	blueSquare = false;
         	redSquare = false;
         	yellowSquare = false;
         }  
         else if ((x >= xR && x < xR+30) && (y >= yR && y < yR+30))
         {  
            redSquare = true;
            greenSquare = false;
         	blueSquare = false;
         	yellowSquare = false;
         }  
         else if ((x >= xY && x < xY+30) && (y >= yY && y < yY+30))
         {  
            yellowSquare = true;
            greenSquare = false;
         	blueSquare = false;
         	redSquare = false;
         }  
         
         
      }
      
	  public void mouseDragged(MouseEvent evt)
      {
		  
         int Dx = evt.getX();
         int Dy = evt.getY();
       
         if (greenSquare)
         {  
            xG = Dx;
            yG = Dy;
            GreenlistX.add(Dx);
            GreenlistY.add(Dy);  

         }
         else if(blueSquare)
         {   
            xB = Dx;
            yB = Dy;
            BluelistX.add(Dx);
            BluelistY.add(Dy);
            
         }
         else if(redSquare)
         {   
            xR = Dx;
            yR = Dy;
            redlistX.add(Dx);
            redlistY.add(Dy);
           
         }
         else if(yellowSquare)
         {   
            xY = Dx;
            yY = Dy;
            yellowlistX.add(Dx);
            yellowlistY.add(Dy);

         }
         
         repaint();  
      }  

      public void mouseClicked(MouseEvent evt) { }
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { } 
      public void mouseReleased(MouseEvent evt) {}
      public void mouseMoved(MouseEvent evt) { }         
   }
   

   public static void main(String[] args)
  	{
 		JFrame frame = new JFrame();
 		
 		FourSquares panel = new FourSquares();
 		frame.add(panel);
 		
 		frame.setSize(400,400);
 		frame.setLocationRelativeTo(null);	 		
 		frame.setVisible(true);   				
  	}
   
   
   
}//End of class
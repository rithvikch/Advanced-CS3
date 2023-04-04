import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski extends JPanel {

    
   public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */

		JFrame frame = new JFrame("SierpinskyTriangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.BLUE);
				drawTriangle(g, 0, 0, 360,8 );
			}
		};
        panel.setPreferredSize(new Dimension(400, 400));
       panel.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
			
		

    }
    

   public  static void drawTriangle(Graphics g, int x, int y, int size, int count){

    if(count <= 0) return;
 
		g.drawLine(x, y, x+size, y);
		g.drawLine(x, y, x, y+size);
		g.drawLine(x+size, y, x, y+size);
 
		drawTriangle(g, x, y, size/2,count-1);
		drawTriangle(g, x+size/2, y, size/2,count-1);
		drawTriangle(g,  x, y+size/2, size/2, count-1);


      

   }
   
   
    
}
 



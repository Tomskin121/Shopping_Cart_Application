import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class Shopping_Cart {
	
	
	public static void main(String args[])
	{
		Dimension size
        = Toolkit.getDefaultToolkit().getScreenSize();
    
    // width will store the width of the screen
    int width = (int)size.getWidth();
    
    // height will store the height of the screen
    int height = (int)size.getHeight();
		
JFrame frame = new JFrame("Test Frame");
frame.setSize(width,height);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label1 = new JLabel("Image and Text",JLabel.CENTER);
label1.setVisible(true);
label1.setOpaque(true);
label1.setText("test");

	}
}

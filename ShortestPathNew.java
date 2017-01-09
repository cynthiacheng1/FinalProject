import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class ShortestPathNew extends JPanel implements ActionListener{

    int x =0;

	//gui version of sleep method
	//Timer tm = new Timer(5, this); //this= actionlistener
	//int x=0, velX=2;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(100,100,50,50);
		g.setColor(Color.RED);
		g.fillOval(200,50,50,50);
		//tm.start();
		//added twenty to everything to move down
		g.drawLine(120, 120, 220, 70);
		//line at angle

	}

	public void actionPerformed(ActionEvent e) {
		//repaint();
	}

	public static void main(String[] args){
		int x = 0;
		System.out.println("Hello Welcome to the Shortest Path \nFirst Write the number of nodes you will like.");
		Scanner inputNodes = new Scanner(System.in);
		int numOfNodes = inputNodes.nextInt();
		System.out.println(numOfNodes);
		if (numOfNodes == 3) {
			x =5;
		}
		
		if (x == 5) {
			ShortestPathNew s = new ShortestPathNew();
			JFrame jf = new JFrame();
			jf.setTitle("Shortest Path Algorithm");
			jf.setSize(600, 400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(s);
			jf.setVisible(true);
		}
	}

}
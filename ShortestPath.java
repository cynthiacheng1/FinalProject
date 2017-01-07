import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShortestPath extends JPanel implements ActionListener{

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
		g.drawLine(100, 100, 200, 50);
		//line at angle

	}

	public void actionPerformed(ActionEvent e) {
		//repaint();
	}

	public static void main(String[] args){
		ShortestPath s = new ShortestPath();
		JFrame jf = new JFrame();
		jf.setTitle("Shortest Path Algorithm");
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(s);
		jf.setVisible(true);
		s.setLayout(new GridBagLayout());
		GridBagConstraints cl;
		cl = new GridBagConstraints();
		cl.gridy = 0;
		s.add(new JLabel("Hello"), cl);
	}

}
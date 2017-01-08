import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShortestPath extends JPanel implements ActionListener{
	private Container pane;
    private JLabel j;
    private JTextField t;
    int numOfNodes;

   public ShortestPath(){

   }
   public ShortestPath(int x) {
   	JFrame j = new JFrame();
    j.setTitle("Input Your Nodes");
    j.setSize(600,400);
    j.setLocation(100,100);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pane = j.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    JButton b = new JButton("ByteMe");
    b.addActionListener(this);
    b.setActionCommand("Byte");
    JButton b2 = new JButton("No...");
    b2.addActionListener(this);
    b2.setActionCommand("NotByte");
    t = new JTextField(10);
    JCheckBox c = new JCheckBox("OverClock");
    pane.add(c);
    pane.add(t);
    pane.add(b);
    pane.add(b2);
  }

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
		ShortestPath y = new ShortestPath(5);
		y.setVisible(true);
		int x = 0;
		if (x == 5) {
			ShortestPath s = new ShortestPath();
			JFrame jf = new JFrame();
			jf.setTitle("Shortest Path Algorithm");
			jf.setSize(600, 400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(s);
			jf.setVisible(true);
		}

	}

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessPath extends JFrame implements ActionListener{
	JTextField[] path;
	JFrame gooey;
	Container pane;
	int[] guess;
	private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    int origin;
    int end;
    double[][][] edgearray;
    int numNodes;

	public GuessPath(){

		pane = this.getContentPane();
		text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
		pane.setLayout(new BoxLayout(pane, 2));
		//pane.add(new JLabel("What is the Shortest Path?"));
		pane.add(new JLabel("From Node"));
		pane.add(text1);
		pane.add(new JLabel("to Node"));
		pane.add(text2);
		pane.add(new JLabel("The Shortest Path is: "));
		pane.add(text3);

		JButton b = new JButton("Confirm your path!");
		b.addActionListener(this);

		pane.add(b);
		gooey = new JFrame();
		gooey.setSize(800,100);
		gooey.add(pane);

		gooey.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

	}

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessPath extends JFrame implements ActionListener{
	int numNodes;
	JTextField[] path;
	JFrame gooey;
	Container pane;
	int[] guess;

	public GuessPath(int nn){
		numNodes = nn;
		path = new JTextField[numNodes];

		pane = this.getContentPane();
		pane.setLayout(new FlowLayout());

		for(int i = 0; i < path.length; i++){
			path[i] = new JTextField("0");
		}

		for(int i = 0; i < path.length; i++){
			pane.add(path[i]);
		}

		JButton b = new JButton("Confirm your path!");
		b.addActionListener(this);

		pane.add(b);
		gooey = new JFrame();
		gooey.setSize(400,600);
		gooey.add(pane);

		gooey.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < path.length; i++){
			guess[i] = Integer.parseInt(path[i].getText());
		}
	}
}
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

	public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try{
        	Integer.parseInt(s);
 			// s is a valid integer
        	isValidInteger = true;
        }
      	catch (NumberFormatException ex){
        	// s is not an integer
        }
    	return isValidInteger;
   }


	public void actionPerformed(ActionEvent e){
		String originInput = text1.getText();
		String endInput = text2.getText();
		String ans = text3.getText();
		// if (isInteger(originInput)){
		// 	System.out.println(Integer.parseInt(originInput));
		// 	System.out.println(numNodes);
		// 	//numNodes
		// 	if ((Integer.parseInt(originInput)< numNodes) && (Integer.parseInt(originInput) >= 0)) {
		// 		origin = Integer.parseInt(originInput);
		// 		System.out.println(origin);
		// 	}
		// 	else{
		// 		JOptionPane.showMessageDialog(null,"Please Input a Valid Number","Error",JOptionPane.WARNING_MESSAGE);
		// 	}
		// }
		// else{
		// 	JOptionPane.showMessageDialog(null,"Please Input a Valid Number","Error",JOptionPane.WARNING_MESSAGE);
		// }

		origin = Integer.parseInt(originInput);
		end = Integer.parseInt(endInput);
		//List<String> list = new ArrayList<String>(Arrays.asList(ans.split(" , ")));
		//get 3D ARRAY(testedges) AND NUMNODES(6)
		//shortestpathalg correct = new shortestpathalg(origin,end,testedges,6);

	}

}
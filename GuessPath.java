import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


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

	public GuessPath(double[][][] gotit, int nodes){
		edgearray = gotit;
		numNodes = nodes;
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

   	public static boolean compareArrays(int[] array1, Integer[] array2) {
        boolean b = true;
        if (array1 != null && array2 != null){
          if (array1.length != array2.length)
              b = false;
          else
              for (int i = 0; i < array2.length; i++) {
                  if (array2[i] != array1[i]) {
                      b = false;    
                  }                 
            }
        }else{
          b = false;
        }
        return b;
    }

	public static String printArray(int[] array){
		String ans = "[";
		for (int i=0; i < array.length; i++){
			ans += array[i] +",";
		}
		return ans.substring(0,ans.length()-1)  +"]";
	}

	public static String printArray(Integer[] array){
		String ans = "[";
		for (int i=0; i < array.length; i++){
			ans += array[i] +",";
		}
		return ans.substring(0,ans.length()-1)  +"]";
	}

    public static String print2D(double[][] array){
		String ans = "[";
		for (int i=0; i < array.length; i++){
			ans += "[";
			for (int j=0; j < array[0].length; j++){
				ans += array[i][j] +",";
			}
			ans = ans.substring(0,ans.length()-1) + "]";
		}
		return ans + "]";
	}

	public static String print2D(int[][] array){
		String ans = "[";
		for (int i=0; i < array.length; i++){
			ans += "[";
			for (int j=0; j < array[0].length; j++){
				ans += array[i][j] +",";
			}
			ans = ans.substring(0,ans.length()-1) + "]";
		}
		return ans + "]";
	}

	public static String print3D(double[][][] array){
		String ans ="[";
		for (int i =0; i< array.length; i++){
			ans += print2D(array[i]) +",";
		}
		return ans.substring(0,ans.length()) + "]";

	}

	public void actionPerformed(ActionEvent e){
		String originInput = text1.getText();
		String endInput = text2.getText();
		String ans = text3.getText(); //1,2,3,4 --> [1,2,3,4]
		ArrayList<Integer> answerz = new ArrayList<Integer>();
		for(int i = 0; i < ans.length(); i++){
			char numCom = ans.charAt(i);
			if(numCom != ','){
				answerz.add(Integer.parseInt("" + numCom));
			}
		}
		Integer[] userInput = new Integer[answerz.size()];
		answerz.toArray(userInput);
		System.out.println(printArray(userInput));

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

		origin = Integer.parseInt(originInput) -1;
		end = Integer.parseInt(endInput)-1;
		shortestpathalg correct = new shortestpathalg(origin,end,edgearray,numNodes);
		System.out.println(origin);
		System.out.println(end);
		System.out.println(print3D(edgearray));
		System.out.println(numNodes);
		Node[] solved = correct.solver();
		int[] labels = new int[solved.length];
		for(int i = 0; i < solved.length;i++){
			labels[i] = Integer.parseInt(solved[i].getlabel()) - 1;
		}
		System.out.println("correct answer: " + printArray(labels));


		if (compareArrays(labels,userInput)){
			System.out.println("TRUE");
		}
		else{
			System.out.println("FALSE");
		}

		//List<String> list = new ArrayList<String>(Arrays.asList(ans.split(" , ")));
		//List<String> items = Arrays.asList(ans.split("\\s*,\\s*"));

	}

}
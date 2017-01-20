import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ShortestPathInput extends JFrame implements ActionListener{
	private JTextField[][] inputCoords;
	private int[][] coordinates;
	private int numNodes;
	private Container pane;
	static JFrame gooey;

	public ShortestPathInput(int nn){
		numNodes = nn;
		//System.out.println(numNodes);

		pane = this.getContentPane();
		pane.setLayout(new GridLayout(0,2));
		pane.setMaximumSize(new Dimension(1000,1200));

		inputCoords = new JTextField[numNodes][2];
		coordinates = new int[numNodes][2];

		for(int i = 0; i < inputCoords.length; i++){
			inputCoords[i][0] = new JTextField("x" + (i+1));
			inputCoords[i][1] = new JTextField("y" + (i+1));
		}

		for(int i = 0; i < inputCoords.length; i++){
			pane.add(inputCoords[i][0]);
			pane.add(inputCoords[i][1]);
			//System.out.println("Success!");
		}

		JButton b = new JButton("Enter your coordinates!");
		b.addActionListener(this);

		pane.add(b);
		gooey = new JFrame();
		gooey.setSize(400,600);
		gooey.add(pane);

	}

	public void actionPerformed(ActionEvent e){

		for(int i = 0; i < inputCoords.length; i++){
			coordinates[i][0] = (int)Double.parseDouble(inputCoords[i][0].getText());
			coordinates[i][1] = (int)Double.parseDouble(inputCoords[i][1].getText());
		}
		//System.out.println(printArray(coordinates));
		InputGraphics g = new InputGraphics(coordinates, numNodes); 
		JFrame jf = new JFrame();
		jf.setTitle("Shortest Path Algorithm");
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(g); //adding panel ontop of frame
		jf.setVisible(true);	
	}

	public double distanceForm(double x1, double x2, double y1, double y2){
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return distance;
	}

	public boolean checkNewCoord(int x, int y, int numFilled, int[][] coords){
		if(numFilled==0){
			return true;
		}
		for(int i = 0; i < numFilled; i++){
			if(distanceForm(x, coordinates[i][0], y, coordinates[i][1]) <= 70){
				return false;
			}
		}
		return true;
	}


    public String printArray(int[][] data){
        String ans = "";
        int i;
        for (i = 0; i < data.length; i ++) {
            for (int j=0; j < data[0].length; j++) {
                ans += data[i][j] + " ";
            }
            ans += "\n";
        }
        return ans;
    }

	public static void main(String[] args){
		// if (args[0].toUpperCase().equals("RANDOM")){
		// 	ShortestPathNew a = new ShortestPathNew();
		// }
		// else{
			try{
				ShortestPathInput g = new ShortestPathInput(Integer.parseInt(args[0]));
			}
			catch(IndexOutOfBoundsException e){
				ShortestPathInput g = new ShortestPathInput(5);
			}
		// }
		gooey.setVisible(true);
	}

}
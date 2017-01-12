import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ShortestPathNew extends JPanel implements ActionListener{

    String info;
    int firstX, firstY, secondX, secondY;


	//gui version of sleep method
	//Timer tm = new Timer(5, this); //this= actionlistener
	//int x=0, velX=2;

	public ShortestPathNew(){
		
		//b.setActionCommand("")
	}

	// public void actionPerformed(ActionEvent e){
	// 	// firstX = Integer.parseInt(ex1.getText());
	// 	// secondX = Integer.parseInt(ex2.getText());
	// 	// firstY = Integer.parseInt(wai1.getText());
	// 	// secondY = Integer.parseInt(wai2.getText());


	// }

    public String print(String[] array){
        String ans = "[";
 		for (int i =0; i < array.length; i++){
 			ans += array[i] + "/";
 		}
 		return ans.substring(0,ans.length()) + "]";
    }


	public void paintComponent(Graphics g){
		// info = info.substring(0,info.length());
		// String[] nodes = info.split(" ");
		// for (int i =0; i <nodes.length; i++){
		// 	g.setColor(Color.RED);
		// 	g.fillOval(100*i,100*i,75,75);
		// }
		Random rand = new Random();
		int numOfNodes = ThreadLocalRandom.current().nextInt(4, 10 + 1);
		System.out.println(numOfNodes);
		Color[] colors = {Color.red, Color.blue, Color.green, Color.yellow, Color.black, Color.pink, Color.gray};
		int[][] positions = new int[numOfNodes][2]; 
		for (int i=0; i <numOfNodes; i++){
			Color culr = colors[i%colors.length];
			g.setColor(culr);
			int x = rand.nextInt(550/numOfNodes) * i;
			int y = rand.nextInt(300);

			while(!checkNewCoord(x, y, i, positions)){
				x = rand.nextInt(550/numOfNodes) * i;
				y = rand.nextInt(300);
			}

			positions[i][0] = x;
			positions[i][1] = y;
			g.fillOval(x,y,50,50);

			System.out.println("Node " + (i+1) + " "+ x+","+ y);
		}

		for (int i=0; i <numOfNodes-1; i++){
			int x1, y1, x2, y2;
			x1 = positions[i][0] + 25;
			y1 = positions[i][1] + 25;

			x2 = positions[i+1][0] + 25;
			y2 = positions[i+1][1] + 25;

			g.drawLine(x1,y1,x2,y2);
			String distance = "" + distanceForm(x1, x2, y1, y2);
			char[] label = new char[distance.length()];
			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, 10, ((x1 + x2)/2), ((y1 + y2)/2));
		}

		for (int i=0; i <numOfNodes; i++){
			int index1 = (int)(Math.random() * positions.length);
			int index2 = (int)(Math.random() * positions.length);
			int x1, y1, x2, y2;
			x1 = positions[index1][0] + 25;
			y1 = positions[index1][1] + 25;

			x2 = positions[index2][0] + 25;
			y2 = positions[index2][1] + 25;

			g.drawLine(x1,y1,x2,y2);
		}
		
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
			if(distanceForm(x, coords[i][0], y, coords[i][1]) <= 70){
				return false;
			}
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {

	}


	public static void main(String[] args){
		int x = 0;
		// System.out.println("Hello Welcome to the Shortest Path \nFirst Write the number of nodes you will like.");
		// Scanner inputNodes = new Scanner(System.in);
		// int numOfNodes = inputNodes.nextInt();
		// String nodeInfo = "";
		// for (int i =0; i < numOfNodes; i++){
		// 	System.out.println("Input specifications for node " + (i+1) +"\nEx. if node 1 was connected to node 2 by length 5 and connected to node 3 by length 2 would input '2,5;3,2 '");
		// 	Scanner inputInfo = new Scanner(System.in);
		// 	nodeInfo += inputInfo.nextLine();
		// }
		//changeInfo(nodeInfo);
		x =5;
		
		if (x == 5) {
			ShortestPathNew s = new ShortestPathNew();
			JFrame jf = new JFrame();
			jf.setTitle("Shortest Path Algorithm");
			jf.setSize(600, 400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(s); //adding panel ontop of frame
			jf.setVisible(true); 

		}
	}

}
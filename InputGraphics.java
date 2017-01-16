import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputGraphics extends JPanel{

	int[][] coordinates;
	int numOfNodes;

	public InputGraphics(){}

	public InputGraphics(int[][] stuff, int nn){
		coordinates = stuff;
		numOfNodes = nn;
	}
	

	public void paintComponent(Graphics g){

		g.setColor(Color.BLACK);

		for (int i=0; i <numOfNodes-1; i++){
			int x1, y1, x2, y2;
			x1 = coordinates[i][0];
			y1 = coordinates[i][1];

			x2 = coordinates[i+1][0];
			y2 = coordinates[i+1][1];

			g.setColor(Color.black);
			g.fillOval(x1, y1, 50, 50);
			g.fillOval(x2, y2, 50, 50);
			g.drawLine(x1+25,y1+25,x2+25,y2+25);

			String distance = "" + (int)distanceForm(x1, x2, y1, y2);

			char[] label = new char[distance.length()];

			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2+50)/2), ((y1 + y2+50)/2));
		}


		g.setColor(Color.RED);

		for(int j = 0; j < coordinates.length; j++){
				String numba = "" + (j+1);
				char[] nuuumba = {numba.charAt(0)};
				g.drawChars(nuuumba, 0, 1, coordinates[j][0]+50, coordinates[j][1]+50);
				System.out.println("yas");
		}

		for (int i=0; i <numOfNodes; i++){
			int index1 = (int)(Math.random() * coordinates.length);
			int index2 = (int)(Math.random() * coordinates.length);
			int x1, y1, x2, y2;
			x1 = coordinates[index1][0] + 25;
			y1 = coordinates[index1][1] + 25;

			x2 = coordinates[index2][0] + 25;
			y2 = coordinates[index2][1] + 25;
			g.setColor(Color.BLACK);
			g.drawLine(x1,y1,x2,y2);
		}
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

	public double distanceForm(double x1, double x2, double y1, double y2){
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return distance;
	}


	public static void main(String[] args){
		InputGraphics s = new InputGraphics();
		JFrame jf = new JFrame();
		jf.setTitle("Shortest Path Algorithm");
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(s); //adding panel ontop of frame
		jf.setVisible(true);
	}



}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ShortestPathNew extends JPanel implements ActionListener, ComponentListener{

    String info;
    int firstX, firstY, secondX, secondY;
    int width = 600;
    int height = 400;

    ShortestPathNew s;


	//gui version of sleep method
	//Timer tm = new Timer(5, this); //this= actionlistener
	//int x=0, velX=2;

	public ShortestPathNew(){
		
		//b.setActionCommand("")
	}



    public String print(String[] array){
        String ans = "[";
 		for (int i =0; i < array.length; i++){
 			ans += array[i] + "/";
 		}
 		return ans.substring(0,ans.length()) + "]";
    }

    public void componentHidden(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
    public void componentShown(ComponentEvent e){}
    public void componentResized(ComponentEvent e){
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)screenSize.getWidth();
		int h = (int)screenSize.getHeight();
		width = w;
		height = h;
    }


	public void paintComponent(Graphics g){
		// info = info.substring(0,info.length());
		// String[] nodes = info.split(" ");
		// for (int i =0; i <nodes.length; i++){
		// 	g.setColor(Color.RED);
		// 	g.fillOval(100*i,100*i,75,75);
		// }
		s = new ShortestPathNew();
		Random rand = new Random();
		int numOfNodes = ThreadLocalRandom.current().nextInt(4, 9 + 1);
		System.out.println(numOfNodes);
		Color[] colors = {Color.red, Color.blue, Color.green, Color.yellow, Color.black, Color.pink, Color.gray};
		int[][] positions = new int[numOfNodes][2]; 

		for (int i=0; i <numOfNodes; i++){
			Color culr = colors[i%colors.length];
			g.setColor(culr);
			int x = rand.nextInt((width-50)/numOfNodes) * i;
			int y = rand.nextInt(height-100);

			while(!checkNewCoord(x, y, i, positions)){
				x = rand.nextInt((width - 50)/numOfNodes) * i;
				y = rand.nextInt(height - 100);
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
			g.setColor(Color.black);
			g.drawLine(x1,y1,x2,y2);
			String distance = "" + (int)distanceForm(x1, x2, y1, y2);
			char[] label = new char[distance.length()];
			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2)/2), ((y1 + y2)/2));
		}

		g.setColor(Color.RED);
		for(int j = 0; j < positions.length; j++){
				String numba = "" + (j+1);
				char[] nuuumba = {numba.charAt(0)};
				g.drawChars(nuuumba, 0, 1, positions[j][0]+50, positions[j][1]+50);
				//System.out.println("yas");
		}

		for (int i=0; i <numOfNodes; i++){
			int index1 = (int)(Math.random() * positions.length);
			int index2 = (int)(Math.random() * positions.length);
			int x1, y1, x2, y2;
			x1 = positions[index1][0] + 25;
			y1 = positions[index1][1] + 25;

			x2 = positions[index2][0] + 25;
			y2 = positions[index2][1] + 25;

			g.setColor(Color.BLACK);
			g.drawLine(x1,y1,x2,y2);

			String distance = "" + (int)distanceForm(x1, x2, y1, y2);
			char[] label = new char[distance.length()];
			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2)/2), ((y1 + y2)/2));
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
		ShortestPathNew s = new ShortestPathNew();
		JFrame jf = new JFrame();
		jf.setTitle("Shortest Path Algorithm");
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(s); //adding panel ontop of frame
		jf.setVisible(true);

		GuessPath gp = new GuessPath();


	}

}
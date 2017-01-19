import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.*;

public class ShortestPathNew extends JPanel implements ActionListener, ComponentListener{

    int firstX, firstY, secondX, secondY;
    int width = 600;
    int height = 400;
    ArrayList<Integer> info = new ArrayList<Integer>();
    ShortestPathNew s;
    int numOfNodes;
    double[][][] distancesAndNodes;
    static double[][][] disAnNo;
    static int nON;



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

		s = new ShortestPathNew();
		Random rand = new Random();
		numOfNodes = ThreadLocalRandom.current().nextInt(4, 7 + 1);
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

			info.add(i);
			info.add(i+1);
			info.add((int)distanceForm(x1, x2, y1, y2));
			info.add(i+1);
			info.add(i);
			info.add((int)distanceForm(x1, x2, y1, y2));

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

			info.add(index1);
			info.add(index2);
			info.add((int)distanceForm(x1, x2, y1, y2));
			info.add(index2);
			info.add(index1);
			info.add((int)distanceForm(x1, x2, y1, y2));

			g.setColor(Color.BLACK);
			g.drawLine(x1,y1,x2,y2);

			String distance = "" + (int)distanceForm(x1, x2, y1, y2);
			char[] label = new char[distance.length()];
			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2)/2), ((y1 + y2)/2));
		}

		int[][] groupedInfo = new int[info.size()/3][3];
		for (int i=0; i < info.size(); i+=3){
			int[] part = new int[3];
			for (int j =0; j <3; j++){
				part[j] = info.get(i+j);
			}
			groupedInfo[i/3] = part;
		}
		//System.out.println(print2D(groupedInfo));
		groupedInfo = sort(groupedInfo);
		//System.out.println(print2D(groupedInfo));
		distancesAndNodes = makeInto3D(groupedInfo, numPerIndex(groupedInfo, numOfNodes));
		System.out.println(print3D(distancesAndNodes));

		GuessPath gp = new GuessPath(distancesAndNodes, numOfNodes);
		
	}

	public double[][][] getInfo(){
		return distancesAndNodes;
	}

	public int getNumNodes(){
		return numOfNodes;
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

	public static int[] numPerIndex(int[][] aRAY, int numNodes){
		//int[] ans = new int[numNodes];
		int[] ans = new int[numNodes];
		for (int i =0; i < numNodes; i++){
			ans[i] = 0;
		}
		for (int i =0; i < aRAY.length; i++){
			int index = aRAY[i][0];
			ans[index] ++;
		}
		return ans;

	}

	public static double[][][] makeInto3D(int[][] nodes, int[] indexes){
		double[][][] ans = new double[indexes.length][][];
		int ctr = 0;
		for (int i =0; i < indexes.length; i++){
			double[][] temp = new double[indexes[i]][2];
			for (int j=0; j < indexes[i]; j++){
				double[] coords = {nodes[ctr][1], nodes[ctr][2]};
				temp[j] = coords;
				ctr++;
 			}
 			ans[i] = temp;
 			//System.out.println(print2D(ans[i]));
		}
		return ans;
	}

	public static int[][] sort(int[][] theArray){   
	    ArrayList<int[]> tempArray = new ArrayList<int[]>();
	    for(int i = 0; i < 5; i++){

		    for(int[] arr:theArray){
		    	if(arr[0] == i){
		    		if(arr[2] != 0){
		    			tempArray.add(arr);
		    		}
		    	}

		    }
		}
		theArray = tempArray.toArray(new int[5][3]);
		return theArray;
 
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

	public static String print3D(double[][][] array){
		String ans ="[";
		for (int i =0; i< array.length; i++){
			ans += print2D(array[i]) +",";
		}
		return ans.substring(0,ans.length()) + "]";

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
	}

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class InputGraphics extends JPanel{

	int[][] coordinates;
	int numOfNodes;
	//int[][] groupedInfo;
	double[][][] distancesAndNodes;
	ArrayList<Integer> info = new ArrayList<Integer>();


	public InputGraphics(){}

	public InputGraphics(int[][] stuff, int nn){
		coordinates = stuff;
		numOfNodes = nn;
	}
	

	public void paintComponent(Graphics g){
		//System.out.println("enter");

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

			//System.out.println(i);
			info.add(i);
			//System.out.println(i);
			info.add(i+1);
			info.add((int)distanceForm(x1, x2, y1, y2));
			//System.out.println((int)distanceForm(x1, x2, y1, y2));


			char[] label = new char[distance.length()];

			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2+50)/2), ((y1 + y2+50)/2));
		}
		//System.out.println("end of first forloop");


		g.setColor(Color.RED);

		for(int j = 0; j < coordinates.length; j++){
				String numba = "" + (j+1);
				char[] nuuumba = {numba.charAt(0)};
				g.drawChars(nuuumba, 0, 1, coordinates[j][0]+50, coordinates[j][1]+50);
				//System.out.println("yas");
		}
		//System.out.println("end of second forloop");

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

			// int[] firstNodeCoords = {x1-25,y1-25};
			// int[] connectedNodeCoords = {x2-25,y2-25};
			// int firstNode = indexFinder(coordinates, firstNodeCoords);
			// System.out.println()
			// int connectedNode = indexFinder(coordinates, connectedNodeCoords);

			info.add(index1);
			info.add(index2);
			info.add((int)distanceForm(x1, x2, y1, y2));
			System.out.println(printArrayList(info));

			String distance = "" + (int)distanceForm(x1, x2, y1, y2);
			char[] label = new char[distance.length()];
			for(int j = 0; j < distance.length(); j++){
				label[j] = distance.charAt(j);
			}
			g.drawChars(label, 0, label.length, ((x1 + x2)/2), ((y1 + y2)/2));
		}
		//System.out.println("exit");
		//double[][][] distancesAndNodes = new double[numOfNodes][][];
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
		//numPerIndex(distancesAndNodes)
		System.out.println(print3D(distancesAndNodes));

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
 			System.out.println(print2D(ans[i]));
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

	public static int indexFinder(int[][] coordinates, int[] find){
		//System.out.println(print2D(coordinates));
		for (int i =0; i < coordinates.length; i++){
			//System.out.println(printArray(coordinates[i]));
			//System.out.println(printArray(find));
			if (compareArrays(coordinates[i],find)){
				return i;
			}
		}
		return 1000;
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

	public static String printArray(int[] array){
		String ans = "[";
		for (int i=0; i < array.length; i++){
			ans += array[i] +",";
		}
		return ans.substring(0,ans.length()-1)  +"]";
	}

	public static boolean compareArrays(int[] array1, int[] array2) {
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

    public static String printArrayList(ArrayList<Integer> data) {
		String ans = "[ ";
		for (int i = 0; i < data.size(); i++) {
			ans = ans + data.get(i) + ", ";
		}
		ans = ans.substring(0 ,ans.length() - 2) + "]";
		return ans;
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
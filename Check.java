import java.util.*;

public class Check{

	public Check(){}

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

    public static void change(ArrayList<Integer> info){
		//double[][][] distancesAndNodes = new double[3][][];
		System.out.println("" + info.size()/3);
		int[][] groupedInfo = new int[info.size()/3][3];
		for (int i=0; i < info.size(); i+=3){
			int[] part = new int[3];
			for (int j =0; j <3; j++){
				part[j] = info.get(i+j);
			}
			System.out.println(printArray(part));
			System.out.println(i/3);
			groupedInfo[i/3] = part;
		}
		//System.out.println(print2D(groupedInfo));
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

	public static double[][][] sortData(int[][] gI){
		double[][][] dAN;
		ArrayList<Integer> counts = new ArrayList<Integer>();

		for(int i = 0; i < 5; i++){
			int ctr = 0;
			for(int[] blah:gI){
				if(blah[0] == i){
					ctr += 1;
				}
			}
			counts.add(ctr);
		}

		dAN = new double[5][Collections.max(counts)][2];
		int ctr = 0;
		for(int i = 0; i < 5; i++){
			while(gI[ctr][0] == i){
				int threeCounter = 0;
				double[] toAdd = {gI[ctr][1], gI[ctr][2]};
				dAN[i][threeCounter] = toAdd;
				ctr++;
				threeCounter++;
			}
		}

		// for(double [][] array2d : dAN){
  //            for(double[] array : array2d){
  //                Arrays.fill(array, 1);
  //            }
  //        }

  //       System.out.println(Arrays.deepToString(dAN));

		return dAN;

	}

	public static int[] numPerIndex(int[][] aRAY){
		//int[] ans = new int[numNodes];
		int[] ans = new int[5];
		for (int i =0; i < 5; i++){
			ans[i] = 0;
		}
		for (int i =0; i < aRAY.length; i++){
			int index = aRAY[i][0];
			ans[index] ++;
		}
		return ans;

	}

	// public double[][][] static makeInto3D(int[][] nodes, int[] indexes){
	// 	double[][][] final = new double[5][][];
	// 	for (int i =0; i < 5; i++){
	// 		for (int j=0; j < indexes[i]; j++){
	// 			double[][] temp = new double[indexes[i]][2];
	// 			final[i] = 
	// 		}
	// 	}

	// }


	public static void main(String[] args){
		int[][] x = {{1,0}, {2,9}, {0,0}};
		int[] y = {0,0};
		//System.out.println(indexFinder(x,y));
		ArrayList<Integer> hello = new ArrayList<Integer>(Arrays.asList( 0, 1, 697, 1, 2, 721, 2, 3, 689, 3, 4, 711, 0, 2, 324, 0, 2, 324, 1, 2, 721, 3, 2, 689, 2, 2, 0));
		change(hello);
		int[][] test = {{0,1,155},{1,2,214},{2,3,123},{3,4,320},{1,1,0},{2,1,214},{1,1,0},{4,0,386},{2,1,214}};
		test = sort(test);
		System.out.print(print2D(test));
		System.out.println("yeiuh");
		//double[][][] blah = sortData(test);
		int[] indexes = new int[5];
		indexes = numPerIndex(test);
		System.out.println(printArray(indexes));


	}
}
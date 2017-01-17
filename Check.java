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
		System.out.println(print2D(groupedInfo));
	}

	public static void sort(Integer[][] theArray){   
	    //Integer[][] theArray = {{0,10},{1,9},{2,9},{3,9},{4,15},{5,10},{6,4},{7,8},{8,11},{9,12}};;
	    Arrays.sort(theArray, new Comparator<Integer[]>()
	    {
	        @Override
	        public int compare(Integer[] int1, Integer[] int2)
	        {
	            Integer numOfKeys1 = int1[1];
	            Integer numOfKeys2 = int2[1];
	            return numOfKeys1.compareTo(numOfKeys2);
	        }
	    });

	    //System.out.println("====");
	    //dump(theArray);     
	}


	public static void main(String[] args){
		int[][] x = {{1,0}, {2,9}, {0,0}};
		int[] y = {0,0};
		//System.out.println(indexFinder(x,y));
		ArrayList<Integer> hello = new ArrayList<Integer>(Arrays.asList( 0, 1, 697, 1, 2, 721, 2, 3, 689, 3, 4, 711, 0, 2, 324, 0, 2, 324, 1, 2, 721, 3, 2, 689, 2, 2, 0));
		change(hello);
		Integer[][] test = {{0,1,155},{1,2,214},{2,3,123},{3,4,320},{1,1,0},{2,1,214},{1,1,0},{4,0,386},{2,1,214}};
		sort(test);
		//System.out.print(print2D(test));


	}
}
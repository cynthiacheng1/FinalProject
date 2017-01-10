import java.util.List;
import java.util.ArrayList;


public class shortestpathalg{
	private Node origin;
	private Node end;
	//private List<Edge>edges;
	private int nnodes;
	private List<Node> solvedpath;
	private double distance;
	private Node[] nodes;
	private List<Node> solved;
	private Node[] finale;

	public shortestpathalg(int a, int b, double[][][] e, int n){
		nodes = new Node[n];
		for (int i = 0; i < n; i++){
			nodes[i] = new Node(Integer.toString(i), e[i]);
			if (i == a){
				//System.out.println("origin");
				origin = nodes[i];
				nodes[i].makesolved();
				//System.out.println(nodes[i].issolved());
			}
			if (i == b){
				//System.out.println("end");
				end = nodes[i];
			}
			//System.out.println(nodes[i]);
		}
		/*Object[][][] edges = new Object[e.length];
		for (int k = 0; k < edges.length; k++){
			edges[k] = new Object[e[k].length][2];
			for (int m = 0; m < edges.length; m++){
				edges[k][m][0] = nodes[(int)e[k][m][0]];
				edges[k][m][1] = e[k][m][1];
			}
			nodes[k].addAD(edges[k]);
		}*/
		solved = new ArrayList<Node>();
		finale = solver();
	}

	public static double[] findmin(double[] arrayy){
	    double minA = arrayy[0];
	    double index = 0;
	    for(int i = 1; i < arrayy.length; i++){
	        if (minA > arrayy[i] && arrayy[i] != -1){
	            minA = arrayy[i];
	            index = i;
	        }
	    }
	    return new double[]{minA, index};
	}

	public boolean findnextsolved(){                                 
		int[]closestnodes = new int[solved.size()];
		double[]nodesdist = new double[solved.size()];
		for (int i = 0; i < solved.size(); i++){
			//System.out.println("HELLOO");
			double[]close = solved.get(i).findclosestunsolved(nodes);
			//System.out.println(close[0]);
			closestnodes[i] = (int)close[0];
			nodesdist[i] = close[1];
		}
		double[]close = findmin(nodesdist);
		int bestnode = (int)closestnodes[(int)close[1]];
		double bestdist = nodesdist[(int)close[1]];
		solved.add(nodes[bestnode]);
		nodes[bestnode].makesolved();
		//System.out.println("CHEEEEEECK " + end.issolved());
		//System.out.println("Solved: " + nodes[bestnode]);
		if (nodes[bestnode] == end){
			return true;
		}
		return false;
	}

	public Node[] solver(){
		solved.add(origin);
		boolean done = false;
		while (!done){
			done = findnextsolved();
		}
		Node[] fin = new Node[solved.size()];
		fin = solved.toArray(fin);
		return fin;
	}

	public String toString(){
		if (finale.length == 0){return "[]";}
		String fin = "[";
		for (int i = 0; i < finale.length-1; i++){
			fin += finale[i].getlabel() + ", ";
		}
		fin += finale[finale.length-1] + "]";
		return fin;
	}

	public static void main(String[]arrgggg){
		double[][][]testedges = new double[6][][];
		testedges[0] = new double[][]{{1,5},{3,2},{4,15}};
		testedges[1] = new double[][]{{0,5},{2,20},{3,9}};
		testedges[2] = new double[][]{{1,20},{3,1},{5,10}};
		testedges[3] = new double[][]{{0,2},{1,9},{2,1}};
		testedges[4] = new double[][]{{0,15},{5,6}};
		testedges[5] = new double[][]{{2,10},{4,6}};
		//System.out.println(testedges);
		shortestpathalg test1 = new shortestpathalg(1,5,testedges,6);
		System.out.println(test1);
	}

}
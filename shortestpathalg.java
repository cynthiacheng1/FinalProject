import java.util.List;
import java.util.ArrayList;


public class shortestpathalg{
	private Node origin;
	private Node end;
	private List<Edge>edges;
	private int nnodes;
	private int[]adjedges;
	private int[]adjedgeslen;
	private int[]sadjedges;
	private int[]sadjedgeslen;
	private List<Node> solvedpath;
	private int distance;
	private Node[] nodes;
	private ArrayList<Node> solved;

	public shortestpath(int a, int b, double[][][] e, int [] l, int n){
		nnodes = n;
		nodes = new Node[nnodes];
		for (int i = 0; i < nnodes; i++){
			nodes[i] = new Node(Integer.toString(i), e[i]);
			if (i == a){origin = nodes[i];}
			if (i == b){end = nodes[i];}
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
	}

	/*public int static findmin(arand, alength){
	    minA = arand[0]
	    index = 0
	    for(int i = 1; i < length.1,alength){
	        if minA>arand[i]{
	            minA=arand[i]
	            index = i
	        }
	    }
	    return minA, index;
	}

	public String[] solver(){
		solved.add(origin);


	}*/
}
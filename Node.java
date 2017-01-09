import java.util.List;
public class Node extends shortestpath{
	private String label;
	private Edge[] adjEdges;
	private double spdist;
	private List<Node> spath;
	private boolean solved;

	public Node(String name, double[][] adjE){
		label = name;
		spdist = Double.POSITIVE_INFINITY;
		adjEdges = new Edge[adjE.length];
		for (int i = 0; i < adjE.length; i++){
			adjEdges[i] = new Edge((int)adjE[i][0], adjE[i][1]);
		}
	}

	public void makesolved(){
		solved = true;
	}

	public void setSP(List<Node> sp){
		spath = sp
	}

	public void setSPD(double spd){
		spdist = spd;
	}

	public double[] findclosestunsolved(){
		//add case for when there are no adjEdges
		if (!solved){return {-1, 0;}}
		minl = Double.POSITIVE_INFINITY;
	    iminlen = 0;
	    for (int i = 0; i < adjEdges.length; i++){
	        if ((minl > adjEdges[i].length) && !(nodes[i].solved)){
	            min = adjEdge[i].length;
	            node = adjEdge[i].node;
	        }
	    }
	    return {node, minl}
	}


	public String toString(){
		return label;
	}
}
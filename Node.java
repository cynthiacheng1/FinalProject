import java.util.List;
public class Node{
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
			//System.out.println(adjEdges[i].getnode());
		}
	}

	public boolean issolved(){
		return solved;
	}

	public String getlabel(){
		return label;
	}

	public void makesolved(){
		solved = true;
	}

	public void setSP(List<Node> sp){
		spath = sp;
	}

	public void setSPD(double spd){
		spdist = spd;
	}

	public double[] findclosestunsolved(Node[] nodes){
		//add case for when there are no adjEdges
		if (!issolved()){return new double[] {-1, 0};}
		double minl = Double.POSITIVE_INFINITY;
	    double node = 710;
	    for (int i = 0; i < adjEdges.length; i++){
	        if ((minl > adjEdges[i].getlength()) && !(nodes[adjEdges[i].getnode()].issolved())){
	            minl = adjEdges[i].getlength();
	            node = adjEdges[i].getnode();
	        }
	        if (nodes[i].issolved()){
	        	adjEdges[i].setsolved();
	        }
	    }
	    if (node == 710){
	    	//System.out.println("NUMBER " + adjEdges.length);
	    	for (int i = 0; i < adjEdges.length; i++){
	    		//System.out.println("FROM " + label + adjEdges[i]);
	    		//System.out.println("LENGTH " + adjEdges[i].getlength());
	    	}
	    }
	    return new double[]{node, minl};
	}


	public String toString(){
		return label;
	}
}
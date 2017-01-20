import java.util.List;
import java.util.ArrayList;

public class Node{
	private String label;
	private Edge[] adjEdges;
	private double spdist;
	private List<Node> spath;
	private boolean solved;

	public Node(String name, double[][] adjE){
		label = name;
		spdist = 0;
		solved = false;
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
		List<Node> fin = new ArrayList<Node>();
        for (int i = 0; i < sp.size(); i++){
            fin.add(sp.get(i));
        }
		spath = fin;
	}

	public List<Node> getSP(){
		return spath;
	}

	public void setSPD(double spd){
		spdist = spd;
	}

	public double getSPD(){
		return spdist;
	}

	public double[] findclosestunsolved(Node[] nodes){
		//add case for when there are no adjEdges
		if (!issolved()){return new double[] {-1, 0};}
		double minl = Double.POSITIVE_INFINITY;
	    double node = 100;
	    for (int i = 0; i < adjEdges.length; i++){
	        if ((minl > adjEdges[i].getlength()+spdist) && !(nodes[adjEdges[i].getnode()].issolved())){
	            minl = adjEdges[i].getlength()+spdist;
	            node = adjEdges[i].getnode();
	        }
	        //if (nodes[i].issolved()){
	        //	adjEdges[i].setsolved();
	        //}
	    }
	    if (node == 100){
	    	//System.out.println("NUMBER " + adjEdges.length);
	    	for (int i = 0; i < adjEdges.length; i++){
	    		//System.out.println("FROM " + label + adjEdges[i]);
	    		//System.out.println("LENGTH " + adjEdges[i].getlength());
	    	}
	    	return new double[]{Double.parseDouble(label),Double.POSITIVE_INFINITY};

	    }
	    System.out.println("*" + node);
	    return new double[]{node, minl, Double.parseDouble(label)};
	}


	public String toString(){
		return label;
	}
}
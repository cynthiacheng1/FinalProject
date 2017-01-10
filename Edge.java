public class Edge{
	private int node;
	private double length;
	public Edge( int e, double l){
		node = e;
		length = l;
	}
	public double getlength(){
		return length;
	}
	public int getnode(){
		return node;
	}
	public void setsolved(){
		length = Double.POSITIVE_INFINITY;
	}
	public String toString(){
		return " TO " + node;
	}
}
import java.awt.Point;

public class MyPoint extends Point implements Comparable<Object>{
	private int heuristicValue;
	
	public MyPoint(int x, int y) {
		super(x,y);
	}
	
	public MyPoint(int x, int y, int heuristicValue) {
		super(x,y);
		this.heuristicValue = heuristicValue;
	}
	
	@Override
	public int compareTo(Object o) {
		MyPoint p = (MyPoint) o;
		return this.heuristicValue - p.heuristicValue;
	}
	
	public void setHeuristicValue(int x) {
		heuristicValue = x;
	}

	public MyPoint[] getAdjPoints(){
		    MyPoint[] adj = new MyPoint[4];
    		adj[0] = new MyPoint(x + 1, y);
    		adj[1] = new MyPoint(x - 1, y);
    		adj[2] = new MyPoint(x, y + 1);
    		adj[3] = new MyPoint(x, y - 1);
    		return adj;
	}

}

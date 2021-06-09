package application;

public class Edge implements Comparable<Edge>{
	private Nodee target;
	 private double distance;
	 private double Heuristic;
	 private double updatedDistance;
	public Edge(Nodee target,double distance,double x,double y) {
		super();
		this.target=target;
		this.Heuristic=Math.sqrt(Math.pow(x-target.getX(),2)+Math.pow((y-target.getY()),2))*20;
		this.distance = distance;
	}
	
	public double getHeuristic() {
		return Heuristic;
	}

	public void setHeuristic(double x,double y) {
		this.Heuristic=Math.sqrt(Math.pow(x-target.getX(),2)+Math.pow((y-target.getY()),2));
	}

	public Nodee getTarget() {
		return target;
	}
	public void setTarget(Nodee v1) {
		target = v1;
	}
	
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		updatedDistance = distance;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.getDistance() < o.getDistance()) {
			return 1;
		}else if(this.getDistance() > o.getDistance()) {
			return -1;
			}
		return 0;
	}

	
}

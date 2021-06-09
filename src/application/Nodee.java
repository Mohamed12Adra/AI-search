package application;

import java.util.LinkedList;

public class Nodee {
	private String name;
	private int x;
	private int y;
	private LinkedList<Edge> neighbors;
	public Nodee(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		neighbors = new LinkedList<Edge>();
	}
	public void addNeighbor(Nodee v, double dis) {
		Edge de = new Edge(v,dis,x,y);
		neighbors.add(de);
		//System.out.println(this.getName()+" "+de.getTarget().getName());
	}
	
	public LinkedList getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(LinkedList neighbors) {
		this.neighbors = neighbors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

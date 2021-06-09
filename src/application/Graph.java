package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {
	private ArrayList<Nodee> cities;
	private ArrayList<Boolean> visited;
	private int max=0;
	private int TimeCount=0;
	private int SizeCount=0;
	private int[] parentVertex;
	public Graph() {
		cities = new ArrayList<>();
		visited = new ArrayList<>();
	}

	public void add(Nodee x) {
		cities.add(x);
		visited.add(false);
		parentVertex = new int[cities.size()];
	}
	//Uniform Cost Search
	public double UniformCostSearch(Nodee start, Nodee destination) {

		double distance[] = new double[cities.size()];
		//set all the distances to the max and the visited to false
		for (int x = 0; x < distance.length; x++) {
			distance[x] = Integer.MAX_VALUE;
			visited.set(x, false);
		}
		//if the start is the same as the destination
		if (start.getName().contains(destination.getName())) {
			TimeCount++;
			System.out.println(TimeCount);
			return 0;
		} else {
			// priority queue (min heap) using the comparable
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1, e2) -> (int)e1.getDistance() - (int)e2.getDistance());
			distance[getIndex(start)] = 0; // the distance of the start always zero
			parentVertex[getIndex(start)] = -1; // set the parent of the start to -1
			pq.add(new Edge(start, 0,start.getX(),start.getY())); // adding the start vertix to the priority queue
			while (pq.isEmpty() == false) { // while the priority queue is not empty
				
				Nodee vert = pq.poll().getTarget(); // remove the edge from the queue
				if(vert.getName().contains(destination.getName())) {// if the target vertix of the edge equals the destination then break
					break;
				}
				int index = getIndex(vert);
				visited.set(index, true);//set the visit status of the target vertix to true
				LinkedList<Edge> adj = vert.getNeighbors();// get the adjacent of the target vertix
				for (int x = 0; x < adj.size(); x++) {// loop to the adjacent
					Edge v = adj.get(x);
					System.out.println(v.getTarget().getName());
					double dist = v.getDistance();
					if (visited.get(getIndex(adj.get(x).getTarget())) != true) {
						if (distance[index] + dist < distance[getIndex(adj.get(x).getTarget())]) {// if the total distance is less than the distance to the next vertix then update the distance
							distance[getIndex(adj.get(x).getTarget())] = distance[index] + dist;
							v.setDistance(distance[index] + dist);
							parentVertex[getIndex(adj.get(x).getTarget())] = index;
							
							pq.add(v);
							TimeCount++;
							System.out.println(TimeCount);
						}
						TimeCount++;
						System.out.println(TimeCount);
					}
				}
				if(max<pq.size()) {
					max=pq.size();
				}
			}
			
		}

		return distance[getIndex(destination)];

	}
	public double AStarSearch(Nodee start, Nodee destination) {

		double distance[] = new double[cities.size()];
		for (int x = 0; x < distance.length; x++) {
			distance[x] = Integer.MAX_VALUE;
			visited.set(x, false);
		}
		
		if (start.getName().contains(destination.getName())) {
			TimeCount++;
			return 0;
		} else {

			PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1, e2) -> ((int)e1.getDistance()+(int)e1.getHeuristic()) - ((int)e2.getDistance()+(int)e2.getHeuristic()));
			distance[getIndex(start)] = 0;
			parentVertex[getIndex(start)] = -1;
			pq.add(new Edge(start, 0,start.getX(),start.getY()));
			while (pq.isEmpty() == false) {
				Nodee vert = pq.poll().getTarget();
				if(vert.getName().contains(destination.getName())) {
					break;
				}
				int index = getIndex(vert);
				visited.set(index, true);
				LinkedList<Edge> adj = vert.getNeighbors();
				for (int x = 0; x < adj.size(); x++) {
					Edge v = adj.get(x);
					double dist = v.getDistance()+v.getHeuristic();//same for the ucs but add the heuristic
					if (visited.get(getIndex(adj.get(x).getTarget())) != true) {
						if (distance[index] + dist < distance[getIndex(adj.get(x).getTarget())]+adj.get(x).getHeuristic()) {
							distance[getIndex(adj.get(x).getTarget())] = distance[index] + v.getDistance();
							v.setDistance(distance[index] + v.getDistance());
							parentVertex[getIndex(adj.get(x).getTarget())] = index;
							pq.add(v);
							TimeCount++;
						}
						TimeCount++;
					}
				}
				if(max<pq.size()) {
					max=pq.size();
				}
			}
			
		}

		return distance[getIndex(destination)];

	}
	public String[] path(Nodee destination) {
		int parent = parentVertex[getIndex(destination)];
		String[] arr = new String[cities.size()];
		System.out.print(cities.get(getIndex(destination)).getName() + " ");
		arr[0]=cities.get(getIndex(destination)).getName();
		for (int x = 1; x < parentVertex.length; x++) {
			arr[x]=cities.get(parent).getName();
			parent = parentVertex[parent];
			if (parent == -1)
				break;
		}
		return arr;
	}
	public int[] getParents() {
		return parentVertex;
	}
	public int getIndex(Nodee v) {
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getName().contains(v.getName())) {
				return i;
			}
		}
		return 0;
	}

	public int getTimeCount() {
		return TimeCount;
	}

	public void setTimeCount(int timeCount) {
		TimeCount = timeCount;
	}

	public int getSizeCount() {
		return max;
	}

	public void setSizeCount(int sizeCount) {
		SizeCount = sizeCount;
	}
	
}

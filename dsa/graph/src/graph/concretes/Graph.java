package graph.concretes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private boolean directed;
	private ArrayList<LinkedList<Integer>> adjLists;

	public Graph(int numberOfVertex, boolean directed) {
		this.directed = directed;
		adjLists = new ArrayList<>(numberOfVertex);
		adjLists.forEach((list) -> list = new LinkedList<>());
	}

	public void addEdge(int source, int destination) {
		if (isInvalid(source, destination)) return;

		if (adjLists.get(source).contains(destination))
			adjLists.get(source).add(destination);

		if (directed && adjLists.get(destination).contains(source)) 
			adjLists.get(destination).add(source);
	}

	public void removeEdge(int source, int destination) {
		if (isInvalid(source, destination)) return;

		if (adjLists.get(source).contains(destination))
			adjLists.get(source).removeFirstOccurrence(destination);

		if (directed && adjLists.get(destination).contains(source)) 
			adjLists.get(destination).removeFirstOccurrence(source);
	}

	private boolean isInvalid(int source, int destination) {
		return (source < 0 || destination < 0 ||
				source >= adjLists.size() || destination >= adjLists.size() ||
				source == destination);
	}

	public void printGraph() {
		for (int i = 0; i < adjLists.size(); i++) {
			System.out.println("\nVertex " + i + ":");
			for (int j = 0; j < adjLists.get(i).size(); j++) {
				System.out.print(" -> " + adjLists.get(i).get(j));
			}
			System.out.println();
		}
	}
}

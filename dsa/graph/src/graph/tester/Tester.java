package graph.tester;

import graph.concretes.Graph;

public class Tester {

	public static void main(String[] args) {
		
		Graph g = new Graph(6, true);
		
		g.addEdge(0, 5);
		g.addEdge(2, 5);
		g.addEdge(1, 5);
		g.addEdge(4, 3);
		g.addEdge(0, 4);
		g.addEdge(4, 5);
		g.printGraph();
	}

}

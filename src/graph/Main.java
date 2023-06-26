package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addEdge("A", "B");
        //myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        //myGraph.addEdge("C", "D");
        myGraph.addEdge("C", "E");
        //myGraph.removeEdge("A", "B");
        //myGraph.removeVertex("D");
        myGraph.addEdge("D", "E");
        myGraph.addEdge("A", "C");
        myGraph.printGraph();


        System.out.println();
        System.out.println(myGraph.hasPathDFS("A", "D"));
        System.out.println(myGraph.hasPathDFS("B", "E"));

        System.out.println();
        System.out.println(myGraph.hashPathBFS("A", "D"));
        System.out.println(myGraph.hashPathBFS("B", "E"));

        System.out.println();
        System.out.println(myGraph.connectedComponentsCount());

        System.out.println();
        System.out.println(myGraph.largestComponent());

        System.out.println();
        System.out.println(myGraph.shortestPath("A", "C"));

        System.out.println();
        System.out.println(shortestPath(myGraph, "A", "B"));


    }

    public static int shortestPath(Graph graph, String src, String dst) {
        HashSet<String> visited = new HashSet<>();
        Queue<Map<String, Integer>> queue = new LinkedList<>();

        queue.add(Map.of(src, 0));

        while (!queue.isEmpty()) {
            Map<String, Integer> current = queue.remove();
            String key = String.valueOf(current.keySet().toArray()[0]);
            int distance = current.get(key);
            if (key.equals(dst)) {
                return distance;
            }

            for (String child: graph.adjList.get(key)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(Map.of(child, distance + 1));
                }
            }

        }

        return -1;

    }
}

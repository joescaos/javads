package graph;

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
        myGraph.printGraph();


        System.out.println();
        System.out.println(myGraph.hasPathDFS("A", "D"));
        System.out.println(myGraph.hasPathDFS("B", "E"));

        System.out.println();
        System.out.println(myGraph.hashPathBFS("A", "D"));
        System.out.println(myGraph.hashPathBFS("B", "E"));

        System.out.println();
        System.out.println(myGraph.connectedComponentsCount());


    }
}

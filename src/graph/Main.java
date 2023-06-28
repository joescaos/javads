package graph;

import java.util.*;

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

        int[][] islandGrid = new int[][] {
                {0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0}
        };

        System.out.println("Number of island: " + islandCount(islandGrid));

        System.out.println("Min size island in grid is: " + minIslandCount(islandGrid));

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

    public static int islandCount(int[][] grid) {
        //HashSet<String> visited = new HashSet<>();
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (explore(grid, r, c)) count += 1;
            }

        }
        return count;
    }

    private static boolean explore(int[][] grid, int r, int c) {
        boolean rowInbounds = 0 <= r && r < grid.length;
        boolean columnInbounds = 0 <= c && c < grid[0].length;

        if(!rowInbounds || !columnInbounds) return false;

        if (grid[r][c] == 0)return false;
        //String position = String.valueOf(r) + ',' + c;

        grid[r][c] = 0;
        explore(grid, r - 1, c);
        explore(grid, r + 1, c);
        explore(grid, r, c - 1);
        explore(grid, r, c + 1);

        return true;
    }

    public static int minIslandCount(int[][] grid) {
        HashSet<String> visited = new HashSet<>();
        int min = Integer.MAX_VALUE;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int islandSize = exploreSize(grid, r, c, visited);
                if (islandSize > 0 && islandSize < min) {
                    min = islandSize;
                }
            }

        }
        return min;
    }

    private static int exploreSize(int[][] grid, int r, int c, Set<String> visited) {
        boolean rowInbounds = 0 <= r && r < grid.length;
        boolean columnInbounds = 0 <= c && c < grid[0].length;

        if(!rowInbounds || !columnInbounds) return 0;

        if (grid[r][c] == 0)return 0;
        String position = String.valueOf(r) + ',' + c;

        if (visited.contains(position)) return 0;

        visited.add(position);

        int size = 1;

        size += exploreSize(grid, r - 1, c, visited);
        size += exploreSize(grid, r + 1, c, visited);
        size += exploreSize(grid, r, c - 1, visited);
        size += exploreSize(grid, r, c + 1, visited);

        return size;
    }
}

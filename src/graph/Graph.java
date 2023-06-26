package graph;

import java.util.*;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex: adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    public boolean hasPathDFS(String src, String dest) {
        HashSet<String> visited = new HashSet<>();
        return hasPathDFS(src, dest, visited);
    }

    private boolean hasPathDFS(String src, String dest, HashSet<String> visited) {
        if (visited.contains(src)) return false;

        visited.add(src);
        if (src.equals(dest)) return true;
        for (String child : adjList.get(src)) {
            if (hasPathDFS(child, dest, visited)) return true;
        }

        return false;
    }

    public boolean hashPathBFS(String src, String dest) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.equals(dest)) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            for (String child : adjList.get(current)) {
                queue.add(child);
            }
        }
        return false;

    }

    public int connectedComponentsCount() {
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        for (String key : adjList.keySet()) {
            if (explore(key, visited)) count++;
        }
        return  count;
    }

    private boolean explore(String key, HashSet<String> visited) {
        if (visited.contains(key)) return false;

        visited.add(key);
        for (String child : adjList.get(key)) {
            explore(child, visited);
        }
        return true;
    }
}

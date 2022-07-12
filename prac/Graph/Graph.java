package prac.Graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> graph; // n개의 vertex가 있는 경우 원소의 개수 : n + 1 (0은 안씀)

    public Graph(ArrayList<ArrayList<Integer>> graph, int vertex) {
        this.graph = graph;
        for(int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }

    public boolean isExist(ArrayList<Integer> arr, int vertex) {
        for(int i : arr) {
            if(i == vertex) return true;
        }
        return false;
    }

    public void add(int from, int to) {
        if(graph.size() < from || graph.size() < to) {
            System.out.println("Error");
        }
        else if(isExist(graph.get(from), to)) {
            System.out.println("Already Exist");
        }
        else if(from == to) {
            System.out.println("from == to");
        }
        else {
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    public void draw() {
        System.out.println("그래프 출력");
        for(int i = 1; i < graph.size(); i++) {
            System.out.print("[" + i + "] : ");
            for(int j : graph.get(i)) {
                System.out.print(j + " -> ");
            }
            System.out.println("");
        }
    }
}

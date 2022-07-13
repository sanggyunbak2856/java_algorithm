package prac.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class AdjacentListGraph implements Graph{
    private ArrayList<ArrayList<Integer>> graph;

    public AdjacentListGraph(int numOfVertex) {
        this.graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numOfVertex + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    @Override
    public boolean isExist(int from, int to) {
        for(int i : graph.get(from)) {
            if(i == to) return true;
        }
        return false;
    }

    @Override
    public void add(int from, int to) {
        if(isExist(from, to)) {
            System.out.println("Already Exist");
            return;
        }
        
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    @Override
    public void draw() {
        System.out.println("Graph");
        for(int i = 1; i < graph.size(); i++) {
            System.out.print("[" + i + "] : ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public void BFS() {
        // TODO Auto-generated method stub
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " -> ");
            for(int i = 0; i < graph.get(x).size(); i++) {
                if(visited[graph.get(x).get(i)] == false) {
                    visited[graph.get(x).get(i)] = true;
                    queue.add(graph.get(x).get(i));
                }
            }
        }
        System.out.println("");
    }

    @Override
    public void DFS() {
        // TODO Auto-generated method stub
    }
}

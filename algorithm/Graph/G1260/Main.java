package algorithm.Graph.G1260;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.*;
import java.util.ArrayList;

public class Main {
    public static LinkedList[] graph;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void bfs(LinkedList[] g, int v){
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()) {
            int w = queue.poll();
            System.out.print(w + " ");
            Iterator<Integer> iter = graph[w].listIterator();
            while(iter.hasNext()) {
                int x = iter.next();
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        System.out.println("");
    }
    public static void dfs(LinkedList[] g, int v){
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> iter = graph[v].listIterator();
        while(iter.hasNext()) {
            int w = iter.next();
            if(!visited[w]) bfs(g, w);
        }
    }
    public static void print(){
        for(int i = 1; i < graph.length; i++) {
            System.out.print(i + " : ");
            for(int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j) + " -> ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>(); // n, m, v
        Stream.of(sc.nextLine().split(" "))
              .forEach(i -> arr.add(Integer.parseInt(i)));
        graph = new LinkedList[arr.get(0) + 1]; // 그래프 생성
        visited = new boolean[arr.get(0) + 1];
        for(int i = 0; i < arr.get(0) + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < arr.get(1); i++) { // 그래프 생성
            String[] input = sc.nextLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(graph, arr.get(2));
        visited = new boolean[arr.get(1) + 1];
        bfs(graph, arr.get(2));

        // dfs

    }
}

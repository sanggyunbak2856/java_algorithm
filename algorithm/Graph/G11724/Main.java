package algorithm.Graph.G11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int count = 0;
    public static void bfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);

        while(!q.isEmpty()) {
            int v = q.poll();
            visited[v] = true;
            ArrayList<Integer> list = graph.get(v);
            for(int i = 0; i < list.size(); i++) {
                int result = list.get(i);
                if(visited[result] == false) {
                    q.add(result);
                }
            }
        }

        count++;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        visited = new boolean[n + 1];

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            String[] vertex = br.readLine().split(" ");
            int from = Integer.parseInt(vertex[0]);
            int to = Integer.parseInt(vertex[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i < n + 1; i++) {
            if(visited[i] == false) bfs(i);
        }

        System.out.println(count);
        br.close();
    }
}

package algorithm.Graph.G18352;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;
    static void dijkstra(int start) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0];});
        pq.add(new Integer[] {start, 0});
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Integer[] v = pq.poll();

            int current_vertex = v[0];
            int current_distance = v[1];

            if(current_distance >= distance[current_vertex]) continue;
            ArrayList<Integer> adjacent = graph.get(current_vertex);

            for(Integer i : adjacent) {
                if(distance[i] > current_distance + 1) distance[i] = current_distance + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        dijkstra(x);
        boolean isExist = false;
        for(int i = 1; i < n + 1; i++) {
            if(distance[i] == k) {
                isExist = true;
                System.out.println(i);
            }
        }

        if(isExist == false) System.out.println(-1);
        br.close();
    }
}

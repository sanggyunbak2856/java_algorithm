package algorithm.Graph.G1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>();
    static int[] distance;
    static void dijkstra(int start) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new Integer[] {start, 0});
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Integer[] v = pq.poll();
            int current_vertex = v[0];
            int current_weight = v[1];

            ArrayList<Integer[]> adjacentList = graph.get(current_vertex);
            for(Integer[] a : adjacentList) {
                if(distance[a[0]] >= current_weight + a[1]) {
                    distance[a[0]] = current_weight + a[1];
                    pq.add(new Integer[] {a[0], distance[a[0]]});
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 1번에서 n번 까지
        int e = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer[]>());
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Integer[] {to, weight}); // (adjacent vertex, weight)
            graph.get(to).add(new Integer[] {from, weight});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        boolean dist1Inf = false , dist2Inf = false;

        dijkstra(1);
        int dist1 = distance[v1];
        if(distance[v1] == Integer.MAX_VALUE) dist1Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(v1);
        dist1 += distance[v2];
        if(distance[v2] == Integer.MAX_VALUE) dist1Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(v2);
        dist1 += distance[n];
        if(distance[n] == Integer.MAX_VALUE) dist1Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(1);
        int dist2 = distance[v2];
        if(distance[v2] == Integer.MAX_VALUE) dist2Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(v2);
        dist2 += distance[v1];
        if(distance[v1] == Integer.MAX_VALUE) dist2Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(v1);
        dist2 += distance[n];
        if(distance[n] == Integer.MAX_VALUE) dist2Inf = true;
        Arrays.fill(distance, Integer.MAX_VALUE);
        if (dist1Inf && dist2Inf) System.out.println(-1);
        else System.out.println(Math.min(dist1, dist2));
        br.close();
    }
}

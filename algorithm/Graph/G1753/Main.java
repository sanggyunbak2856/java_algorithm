package algorithm.Graph.G1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Integer[]>> graph;
    static void dijkstra(int[] distance, int start) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1])); // [vertex, weight]
        distance[start] = 0;
        pq.add(new Integer[] {start, distance[start]});

        while(!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int current_vertex = current[0];
            int current_weight = current[1];

            if(current_weight > distance[current_vertex]) continue;

            ArrayList<Integer[]> adjacentList = graph.get(current_vertex);

            for(Integer[] v : adjacentList) {
                if(distance[v[0]] > current_weight + v[1]) {
                    distance[v[0]] = current_weight + v[1];
                    pq.add(new Integer[] {v[0], distance[v[0]]});
                }
                
            }

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i < vertex + 1; i++) { // 0은 비움
            graph.add(new ArrayList<Integer[]>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Integer[] {to, weight});
        }

        int[] distance = new int[vertex + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(distance, start);
        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }

        br.close();
    }
}

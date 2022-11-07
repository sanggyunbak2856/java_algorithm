package prac.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static int[] dijkstra(List<ArrayList<Integer[]>> graph, int start) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        pq.add(new Integer[] {start, 0});

        while(!pq.isEmpty()) {
            Integer[] p = pq.poll();
            int cur_node = p[0];
            int cur_weight = p[1];

            if(cur_weight > distance[cur_node]) continue;
            ArrayList<Integer[]> adjacentList = graph.get(cur_node);
            for(Integer[] adjacent : adjacentList) {
                if(adjacent[1] + cur_weight < distance[adjacent[0]]) {
                    distance[adjacent[0]] = adjacent[1] + cur_weight;
                    pq.add(new Integer[] {adjacent[0], distance[adjacent[0]]});
                }
            }
        }

        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<ArrayList<Integer[]>> graph = new ArrayList<>();
        for(int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<Integer[]>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Integer[] {to, weight});
        }

        int[] distance = dijkstra(graph, start);

        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }

        br.close();
    }
}

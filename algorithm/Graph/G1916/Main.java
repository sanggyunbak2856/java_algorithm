package algorithm.Graph.G1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer[]>> map;
    static int[] distance;
    static void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new Integer[] {start, 0});

        while(!pq.isEmpty()) {
            Integer[] v = pq.poll();
            int current_vertex = v[0];
            int current_weight = v[1];

            if(current_weight > distance[current_vertex]) continue;

            ArrayList<Integer[]> adjacentList = map.get(current_vertex);
            for(Integer[] a : adjacentList) {
                if(distance[a[0]] > current_weight + a[1]) {
                    distance[a[0]] = current_weight + a[1];
                    pq.add(new Integer[] {a[0], distance[a[0]]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new ArrayList<ArrayList<Integer[]>>();
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++) { // 1 부터 n 까지
            map.add(new ArrayList<Integer[]>());
        }

        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            map.get(from).add(new Integer[] {to, weight});
        }

        String[] minCost = br.readLine().split(" ");
        dijkstra(Integer.parseInt(minCost[0]));
        System.out.println(distance[Integer.parseInt(minCost[1])]);

        br.close();
    }
}

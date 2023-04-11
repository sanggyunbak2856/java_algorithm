package algorithm.Baekjun.B5972;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>();
    static void dijkstra(int[] distance) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new Integer[] {1, 0}); // current node, current weight
        distance[1] = 0;

        while(!q.isEmpty()) {
            Integer[] current = q.poll();
            int currentNode = current[0];
            int currentWeight = current[1];

            if(distance[currentNode] < currentWeight) continue;
            ArrayList<Integer[]> adjacentList = graph.get(currentNode);
            for(Integer[] p : adjacentList) {
                if(distance[p[0]] > currentWeight + p[1]) {
                    distance[p[0]] = currentWeight + p[1];
                    q.add(new Integer[] {p[0], distance[p[0]]});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Integer[] {to, weight});
            graph.get(to).add(new Integer[] {from, weight});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(distance);
        bw.write(distance[n] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

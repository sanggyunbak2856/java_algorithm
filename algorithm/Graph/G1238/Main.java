package algorithm.Graph.G1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    static int n, m, x;
    static ArrayList<ArrayList<Integer[]>> map;
    static int[] bfs(int vertex) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Integer[]> q = new PriorityQueue<>((o1, o2) -> {return o1[1] - o2[1];});
        q.add(new Integer[] {vertex, 0});
        distance[vertex] = 0;

        while(!q.isEmpty()) {
            Integer[] v = q.poll();
            int currentVertex = v[0];
            int currentTime = v[1];

            if(distance[currentVertex] < currentTime) continue;

            ArrayList<Integer[]> adjacentVertexes = map.get(currentVertex);
            for(Integer[] a : adjacentVertexes) {
                if(distance[a[0]] > currentTime + a[1]) {
                    distance[a[0]] = currentTime + a[1];
                    q.add(new Integer[] {a[0], distance[a[0]]});
                }
            }
        }

        return distance;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();

        for(int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            map.get(from).add(new Integer[] {to, time});
        }


        int[] distanceFromX = bfs(x);
        int max = distanceFromX[1];
        for(int i = 1; i < n + 1; i++) {
            int[] distance_1 = bfs(i);
            max = Math.max(max, distanceFromX[i] + distance_1[x]);
        }

        System.out.println(max);
        
        br.close();
    }
}

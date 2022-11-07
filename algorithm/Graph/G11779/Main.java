package algorithm.Graph.G11779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static List<ArrayList<Integer[]>> graph;
    static int[] parent;
    static int[] dijkstra(int start) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(
            (o1, o2) -> o2[1] - o1[1]);
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.add(new Integer[] {start, 0});

        while(!pq.isEmpty()) {
            Integer[] p = pq.poll();
            int cur_node = p[0];
            int cur_weight = p[1];

            if(cur_weight > distance[cur_node]) continue;
            ArrayList<Integer[]> adjacentList = graph.get(cur_node);
            for(Integer[] v : adjacentList) {
                if(v[1] + cur_weight < distance[v[0]]) {
                    distance[v[0]] = v[1] + cur_weight;
                    pq.add(new Integer[] {v[0], distance[v[0]]});
                    parent[v[0]] = cur_node;
                }
            }
        }

        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        parent = new int[n + 1];
        Arrays.fill(parent, Integer.MAX_VALUE);

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer[]>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Integer[] {to, weight});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = dijkstra(start);
        List<Integer> path = new ArrayList<> ();

        int cur_node = end;
        path.add(cur_node);
        while(true) {
            int prev_node = parent[cur_node];
            if(prev_node == Integer.MAX_VALUE) break;
            path.add(prev_node);
            cur_node = prev_node;
        }

        System.out.println(distance[end]);
        System.out.println(path.size());
        for(int i = path.size() - 1; i > -1; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();

        br.close();
    }
}

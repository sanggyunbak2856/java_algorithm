package algorithm.Baekjun.B1197;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if(xRoot <= yRoot) parent[yRoot] = xRoot;
        else parent[xRoot] = yRoot;
    }
    static boolean isUnion(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] parent = new int[v + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[e];
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v1, v2, weight);
        }

        Arrays.sort(edges, (e1, e2) -> e1.weight - e2.weight);

        int sum = 0;
        int countEdge = 0;
        for(Edge edge : edges) {
            if(countEdge == v - 1) break;
            if(isUnion(parent, edge.v1, edge.v2)) continue;
            else {
                union(parent, edge.v1, edge.v2);
                sum += edge.weight;
                countEdge += 1;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static class Edge {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
}

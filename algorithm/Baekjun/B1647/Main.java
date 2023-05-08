package algorithm.Baekjun.B1647;

import java.util.*;
import java.io.*;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        Edge[] edges = new Edge[m];
        for(int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, (e1, e2) -> e1.cost - e2.cost);
        int sum = 0;
        int count = 0;
        for(Edge e : edges) {
            if(count == n - 2) break;
            if(isUnion(parent, e.a, e.b)) continue;
            else {
                union(parent, e.a, e.b);
                sum += e.cost;
                count++;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static class Edge {
        public int a;
        public int b;
        public int cost;
        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}

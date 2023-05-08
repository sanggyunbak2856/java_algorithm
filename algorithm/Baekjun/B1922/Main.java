package algorithm.Baekjun.B1922;

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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[m];
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(n1, n2, cost);
        }

        Arrays.sort(edges, (e1, e2) -> e1.cost - e2.cost);

        int sum = 0;
        int count = 0;
        for(Edge e : edges) {
            if(count == n - 1) break;
            if(isUnion(parent, e.n1, e.n2)) continue;
            else {
                union(parent, e.n1, e.n2);
                sum += e.cost;
                count += 1;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static class Edge {
        int n1;
        int n2;
        int cost;
        public Edge(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
    }
}

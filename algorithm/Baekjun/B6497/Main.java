package algorithm.Baekjun.B6497;

import java.util.*;
import java.io.*;

public class Main {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;
            int[] parent = new int[m];
            for(int i = 0; i < m; i++) {
                parent[i] = i;
            }

            List<Edge> edges = new ArrayList<>();
            int totalAmount = 0;
            boolean zeroInput = false;
            int count = 0;

            while(true) {
                if(count == n) break;
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                if(n1 == 0 && n2 == 0) {
                    zeroInput = true;
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                totalAmount += distance;
                edges.add(new Edge(n1, n2, distance));
                count++;
            }

            Collections.sort(edges, (e1, e2) -> e1.distance - e2.distance);
            int sum = 0;
            int cnt = 0;
            for(Edge e : edges) {
                if(count == m - 1) break;
                if(!isUnion(parent, e.n1, e.n2)) {
                    union(parent, e.n1, e.n2);
                    sum += e.distance;
                    cnt++;
                }
            }
            bw.write((totalAmount - sum) + "\n");
            bw.flush();

            if(zeroInput) break;
        }
        br.close();
        bw.close();
    }
    static class Edge {
        int n1;
        int n2;
        int distance;
        public Edge(int n1, int n2, int distance) {
            this.n1 = n1;
            this.n2 = n2;
            this.distance = distance;
        }
    }
}

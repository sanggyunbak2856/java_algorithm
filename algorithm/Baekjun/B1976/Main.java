package algorithm.Baekjun.B1976;

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
        if(xRoot < yRoot) parent[yRoot] = xRoot;
        else parent[xRoot] = yRoot;
    }
    static boolean isUnion(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for(int i = 1; i < n + 1; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                int connection = Integer.parseInt(st.nextToken());
                if(connection == 1) union(parent, i, j);
            }
        }

        boolean isPossible = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            int city = Integer.parseInt(st.nextToken());
            if(!isUnion(parent, start, city)) {
                isPossible = false;
                break;
            }
        }
        if(isPossible) bw.write("YES\n");
        else bw.write("NO\n");

        br.close();
        bw.close();
    }
}

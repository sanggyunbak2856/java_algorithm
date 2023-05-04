package algorithm.Baekjun.B17352;

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
        int[] parent = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(parent, x, y);
        }

        boolean isFound = false;
        for(int i = 1; i < n + 1; i++) {
            for(int j = i + 1; j < n + 1; j++) {
                if(!isUnion(parent, i, j)) {
                    bw.write(i + " " + j + "\n");
                    bw.flush();
                    isFound = true;
                    break;
                }
            }
            if(isFound) break;
        }

        br.close();
        bw.close();
    }
}

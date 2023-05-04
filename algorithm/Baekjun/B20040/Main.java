package algorithm.Baekjun.B20040;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean isGameEnded = false;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(isUnion(parent, x, y)) {
                bw.write((i + 1) + "\n");
                bw.flush();
                isGameEnded = true;
                break;
            }
            else {
                union(parent, x, y);
            }
        }
        if(!isGameEnded) bw.write("0\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

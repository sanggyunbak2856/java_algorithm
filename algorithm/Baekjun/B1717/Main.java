package algorithm.Baekjun.B1717;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else {
            return parent[x] = find(parent, parent[x]);
        }
    }
    static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if(xRoot < yRoot) {
            parent[yRoot] = xRoot;
        }
        else {
            parent[xRoot] = yRoot;
        }
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
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operand = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(operand == 0) {
                union(parent, x, y);
            }
            else if(operand == 1) {
                if(isUnion(parent, x, y)) {
                    bw.write("YES\n");
                }
                else {
                    bw.write("NO\n");
                }
            }
            bw.flush();
        }

        br.close();
        bw.close();
    }
}

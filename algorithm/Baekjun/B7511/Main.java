package algorithm.Baekjun.B7511;

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

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int users = Integer.parseInt(br.readLine());
            int[] parent = new int[users + 1];
            for(int j = 0; j < users + 1; j++) {
                parent[j] = j;
            }

            int relations = Integer.parseInt(br.readLine());
            for(int j = 0; j < relations; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(parent, x, y);
            }

            int checkUserNumber = Integer.parseInt(br.readLine());
            bw.write("Scenario " + (i + 1) + ":\n");

            for(int j = 0; j < checkUserNumber; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(isUnion(parent, x, y)) bw.write("1\n");
                else bw.write("0\n");
            }
            bw.write("\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}

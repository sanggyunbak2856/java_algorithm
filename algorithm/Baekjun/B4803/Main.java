package algorithm.Baekjun.B4803;

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

        find(parent, y);
        find(parent, x);
    }
    static boolean isUnion(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            int[] parent = new int[n + 1];
            boolean[] isCycle = new boolean[n + 1];
            for(int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }

            Set<Integer> cycleSet = new HashSet<>();
            Set<Integer> cycleChildSet = new HashSet<>();
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(!isUnion(parent, x, y)) union(parent, x, y);
                else {
                    union(parent, x, y);
                    cycleChildSet.add(x);
                    cycleChildSet.add(y);
                }
            }

            for(Integer i : cycleChildSet) {
                cycleSet.add(parent[i]);
            }

            Set<Integer> notCycleSet = new HashSet<>();
            for(int i = 1; i < parent.length; i++) {
                if(cycleSet.contains(parent[i])) isCycle[i] = true;
                else notCycleSet.add(parent[i]);
            }
            if(notCycleSet.size() == 0) {
                bw.write("Case " + idx + ": No trees.\n");
            }
            else if(notCycleSet.size() == 1) {
                bw.write("Case " + idx + ": There is one tree.\n");
            }
            else {
                bw.write("Case " + idx + ": A forest of " + notCycleSet.size() + " trees.\n");
            }
            bw.flush();
            idx += 1;
        }

        br.close();
        bw.close();
    }
}

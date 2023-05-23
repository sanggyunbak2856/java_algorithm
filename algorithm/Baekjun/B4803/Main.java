package algorithm.Baekjun.B4803;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int find(int[] parent, int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent, parent[a]);
    }
    static void union(int[] parent, int a, int b) {
        int aRoot = find(parent, a);
        int bRoot = find(parent, b);

        if(aRoot <= bRoot) parent[bRoot] = aRoot;
        else parent[aRoot] = bRoot;
    }
    static boolean isUnion(int[] parent, int a, int b) {
        return find(parent, a) == find(parent, b);
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
            for(int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            Set<Integer> cycleSet = new HashSet<>();
            Set<String> edgeSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int[] edge = new int[2];
                if (x <= y) {
                    edge[0] = x;
                    edge[1] = y;
                } else {
                    edge[0] = y;
                    edge[1] = x;
                }

                String edgeString = Arrays.toString(edge);

                if (edgeSet.contains(edgeString)) {
                    continue; // 이미 존재하는 간선이므로 무시합니다.
                } else {
                    edgeSet.add(edgeString); // 간선을 추가합니다.
                }

                if(isUnion(parent, x, y)) {
                    cycleSet.add(find(parent, x));
                }
                else {
                    union(parent, x, y);
                }
            }

            Set<Integer> treeSet = new HashSet<>();
            for(int i = 1; i < parent.length; i++) {
                int root = find(parent, i);
                if(cycleSet.contains(root)) continue;
                treeSet.add(root);
            }

            if(treeSet.size() == 0) bw.write("Case " + idx + ": No trees.\n");
            else if(treeSet.size() == 1) bw.write("Case " + idx + ": There is one tree.\n");
            else bw.write("Case " + idx + ": A forest of " + treeSet.size() + " trees" +  ".\n");
            idx++;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

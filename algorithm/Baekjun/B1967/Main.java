package algorithm.Baekjun.B1967;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static void dfs(int currentNode, int sum) {
        for(Integer[] p : graph.get(currentNode)) {
            if(!visited[p[0]]) {
                visited[p[0]] = true;
                dfs(p[0], sum + p[1]);
            }
        }
        max = sum > max ? sum : max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new Integer[] {child, weight});
            graph.get(child).add(new Integer[] {parent, weight});
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

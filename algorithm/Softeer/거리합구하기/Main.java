package algorithm.Softeer.거리합구하기;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>(); // 0 : node, 1: weight(거리)
    static int[] dist;
    static int sum = 0;
    static void dfs(int start, int currentSum, boolean[] visited) {
        visited[start] = true;
        sum += currentSum;
        ArrayList<Integer[]> adjacent = graph.get(start);
        for(Integer[] v : adjacent) {
            if(visited[v[0]]) continue;
            visited[v[0]] = true;
            dfs(v[0], currentSum + v[1], visited);
            visited[v[0]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Integer[] {to, weight});
            graph.get(to).add(new Integer[] {from, weight});
        }

        for(int i = 1; i < n + 1; i++) {
            dfs(i, 0, new boolean[n + 1]);
            bw.write(sum + "\n");
            sum = 0;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

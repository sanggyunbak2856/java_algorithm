package algorithm.Baekjun.B13023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer; 

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean checkAllVisited() {
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
    static boolean relationExist = false;
    static void dfs(int start, int depth) {
        if(depth == 4) {
            relationExist = true;
            return;
        }

        visited[start] = true;
        for(int i : graph[start]) {
            if(visited[i]) continue;
            dfs(i, depth + 1);
        }
        visited[start] = false;
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 0; i < n; i++) {
            dfs(i, 0);
            if(relationExist) break;
        }

        if(relationExist) bw.write("1\n");
        else bw.write("0\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

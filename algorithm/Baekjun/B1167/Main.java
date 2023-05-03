package algorithm.Baekjun.B1167;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int node = 0;
    static void dfs(int currentNode, int length) throws IOException {
        ArrayList<Integer[]> adjacentList = graph.get(currentNode);

        boolean hasChild = false;
        for(int i = 0; i < adjacentList.size(); i++) {
            Integer[] p = adjacentList.get(i);
            if(visited[p[0]]) continue;
            visited[p[0]] = true;
            hasChild = true;
            dfs(p[0], length + p[1]);
            visited[p[0]] = false;
        }

        if(!hasChild) {
            if(max < length) {
                max = length;
                node = currentNode;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentNode = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                graph.get(currentNode).add(new Integer[] {to, weight});
            }
        }

        visited[graph.size() / 2] = true;
        dfs(graph.size() / 2, 0);
        visited[graph.size() / 2] = false;
        visited[node] = true;
        dfs(node, 0);
        visited[node] = false;
        
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

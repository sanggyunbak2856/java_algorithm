package algorithm.swexpert.S2814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    static int N;
    static int M;
    static List<ArrayList<Integer>> graph; // idx 0 : node, idx 1 : visited
    static boolean[] visited;
    static int max = 0;
    static void dfs(int start, int end, int depth) {
        if(start == end) {
            max = depth > max ? depth : max;
            return;
        }

        List<Integer> adjacentList = graph.get(start);
        for(Integer p : adjacentList) {
            if(visited[p]) continue;
            visited[p] = true;
            dfs(p, end, depth + 1);
            visited[p] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            visited = new boolean [N + 1];
            for(int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            for(int i = 1; i < N + 1; i++) {
                for(int j = 1; j < N + 1; j++) {
                    dfs(i, j, 0);
                }
            }

            if(N == 1) System.out.printf("#%d %d\n", test_case, 1);
            else System.out.printf("#%d %d\n", test_case, max);
            max = 0;
        }
        
        br.close();
    }
}

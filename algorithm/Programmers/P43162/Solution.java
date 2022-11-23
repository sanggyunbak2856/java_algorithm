package algorithm.Programmers.P43162;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count = 0;
    static void bfs(int n) {
        if(visited[n]) return;
        count+=1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        
        while(!q.isEmpty()) {
            int p = q.poll();
            visited[p] = true;
            
            List<Integer> adjacentList = graph.get(p);
            for(Integer v : adjacentList) {
                if(visited[v]) continue;
                q.add(v);
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        graph = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for(int j = 0; j < n; j++) {
                if(j != i && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++ ){
            bfs(i);
        }
        
        
        return count;
    }

    public static void main(String[] args) {
        int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        int ans = solution(n, computers);
        System.out.println(ans);
    }
}

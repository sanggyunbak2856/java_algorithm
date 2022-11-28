package algorithm.Programmers.P1844;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    static int n;
    static int m;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static void bfs(int[][] map) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 0, 0});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;
            dp[p[0]][p[1]] = p[2];

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
                if(map[newY][newX] == 1) continue;

                if((dp[newY][newX] != 0 && p[2] + 1 < dp[newY][newX]) || dp[newY][newX] == 0) {
                    dp[newY][newX] = p[2] + 1;
                    q.add(new Integer[] {newY, newX, p[2] + 1});
                }
            }

        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i][j] == 1) dp[i][j] = -1;
            }
        }

        bfs(maps);
        answer = dp[n - 1][m - 1];
        return answer;
    }

    public static void main(String[] args) {
        
    }
}

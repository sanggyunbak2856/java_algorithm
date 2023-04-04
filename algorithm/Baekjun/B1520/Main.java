package algorithm.Baekjun.B1520;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int dfs(int y, int x) {
        if(y == n - 1 && x == m - 1) {
            return 1;
        }

        if(dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] < map[y][x]) {
                dp[y][x] += dfs(newY, newX);
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int sum = dfs(0, 0);
        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

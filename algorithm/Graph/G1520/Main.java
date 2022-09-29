package algorithm.Graph.G1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dp;
    static int[][] map;
    static int w, h;
    static int dfs(int y, int x) {
        dp[y][x] = 0;

        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if((newY >= 0 && newY < h) && (newX >= 0 && newX < w)) {
                if(map[y][x] > map[newY][newX]) {
                    if(newY == h - 1 && newX == w - 1) {
                        dp[newY][newX] += 1;
                    }
                    if(dp[newY][newX] >= 0) dp[y][x] += dp[newY][newX];
                    else {
                        dp[y][x] += dfs(newY, newX);
                    }
                }
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        dp = new int[h][w];
        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = dfs(0, 0);

        bw.write(ans+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

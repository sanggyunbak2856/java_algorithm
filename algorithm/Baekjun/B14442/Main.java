package algorithm.Baekjun.B14442;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] dist;
    static boolean[][][] visited;
    static int n, m, k;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 0, 0, 1});
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(p[0] == n - 1 && p[1] == m - 1) {
                min = p[3] < min ? p[3] : min;
            }

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[p[2]][newY][newX]) continue;
                if(map[newY][newX] == 1) {
                    if(p[2] + 1 <= k && visited[p[2] + 1][newY][newX] == false) {
                        q.add(new Integer[] {newY, newX, p[2] + 1, p[3] + 1});
                        visited[p[2] + 1][newY][newX] = true;
                    }
                }
                else {
                    q.add(new Integer[] {newY, newX, p[2], p[3] + 1});
                    visited[p[2]][newY][newX] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        // visited = new boolean[n][m][15];
        visited = new boolean[k + 1][n][m];

        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

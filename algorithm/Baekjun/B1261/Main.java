package algorithm.Baekjun.B1261;

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int m;
    static void bfs() {
        Queue<int[]> q = new LinkedList<>(); // 0 : y, 1 : x, 2 : wall, 3: move
        q.add(new int[] {0, 0, 0, 0});

        while(!q.isEmpty()) {
            int[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length) continue;
                if(map[newY][newX] >= 1) continue;
                if(newY == n - 1 && newX == m - 1) { // n, m에 도달
                    min = p[2] < min ? p[2] : min;
                    continue;
                }
                if(map[newY][newX] == -1) { // 벽일 떄
                    map[newY][newX] = p[3] + 1;
                    q.add(new int[] {newY, newX, p[2] + 1, p[3] + 1});
                }
                else if(map[newY][newX] == 0) { // 빈 칸
                    map[newY][newX] = p[3] + 1;
                    q.add(new int[] {newY, newX, p[2], p[3] + 1});
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
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                int value = Integer.parseInt(str[j]);
                if(value == 1) {
                    map[i][j] = -1;
                }
            }
        }

        bfs();
        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

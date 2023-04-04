package algorithm.Baekjun.B14923;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int posY, posX;
    static int eY, eX;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {-0, -1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {posY, posX, 0, 0}); // y, x, count, used

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(p[0] == eY && p[1] == eX) {
                min = p[2] < min ? p[2] : min;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[p[3]][newY][newX]) continue;

                if(map[newY][newX] == 0) {
                    q.add(new Integer[] {newY, newX, p[2] + 1, p[3]});
                    visited[p[3]][newY][newX] = true;
                }
                else {
                    if(p[3] == 0) {
                        q.add(new Integer[] {newY, newX, p[2] + 1, 1});
                        visited[1][newY][newX] = true;
                    }
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
        st = new StringTokenizer(br.readLine());
        posY = Integer.parseInt(st.nextToken()) - 1;
        posX = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        eY = Integer.parseInt(st.nextToken()) - 1;
        eX = Integer.parseInt(st.nextToken()) - 1;

        map = new int[n][m];
        visited = new boolean[2][n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
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

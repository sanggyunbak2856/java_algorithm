package algorithm.Baekjun.B1261;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static void bfs() {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (o1, o2) -> o1[2] - o2[2]
        );
        pq.add(new Integer[] {0, 0, 0});
        visit[0][0] = 0;

        while(!pq.isEmpty()) {
            Integer[] p = pq.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(map[newY][newX] == 1) {
                    if(p[2] + 1 < visit[newY][newX]) {
                        pq.add(new Integer[] {newY, newX, p[2] + 1});
                        visit[newY][newX] = p[2] + 1 < visit[newY][newX] ? p[2] + 1 : visit[newY][newX];
                    }
                }
                else if(map[newY][newX] == 0) {
                    if(p[2] < visit[newY][newX]) {
                        pq.add(new Integer[] {newY, newX, p[2]});
                        visit[newY][newX] = p[2] < visit[newY][newX] ? p[2] : visit[newY][newX];
                    }
                }
            }
        }

        min = visit[n - 1][m - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        bfs();
        bw.write(min + "\n");
        br.close();
        bw.close();
    }
}

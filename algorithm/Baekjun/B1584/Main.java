package algorithm.Baekjun.B1584;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 1 : 위험, 2 : 죽음
    static int[][] visit;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs() {
        PriorityQueue<Integer[]> q = new PriorityQueue<>(
            (o1, o2) -> {return o1[2] - o2[2];}
        );
        q.add(new Integer[] {0, 0, 0}); // y, x, count
        visit[0][0] = 0;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(p[2] > min) continue;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if(newY < 0 || newX < 0 || newY >= 501 || newX >= 501) continue;
                if(map[newY][newX] == 2) continue;
                if(map[newY][newX] == 1) {
                    if(p[2] + 1 < visit[newY][newX]) {
                        q.add(new Integer[] {newY, newX, p[2] + 1});
                        visit[newY][newX] = p[2] + 1 < visit[newY][newX] ? p[2] + 1 : visit[newY][newX];
                    }

                }
                else if(map[newY][newX] == 0) {
                    if(p[2] < visit[newY][newX]) {
                        q.add(new Integer[] {newY, newX, p[2]});
                        visit[newY][newX] = p[2] < visit[newY][newX] ? p[2] : visit[newY][newX];
                    }
                }
            }
        }
        min = visit[500][500];
    }
    static void fillMap(int y1, int x1, int y2, int x2, int mode) {
        if(y1 <= y2) {
            if(x1 <= x2) {
                for(int i = y1; i <= y2; i++) {
                    for(int j = x1; j <= x2; j++) {
                        map[i][j] = mode;
                    }
                }
            }
            else {
                for(int i = y1; i <= y2; i++) {
                    for(int j = x1; j >= x2; j--) {
                        map[i][j] = mode;
                    }
                }
            }
        }
        else {
            if(x1 <= x2) {
                for(int i = y1; i >= y2; i--) {
                    for(int j = x1; j <= x2; j++) {
                        map[i][j] = mode;
                    }
                }
            }
            else {
                for(int i = y1; i >= y2; i--) {
                    for(int j = x1; j >= x2; j--) {
                        map[i][j] = mode;
                    }
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[501][501];
        visit = new int[501][501];
        for(int i = 0; i < 501; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillMap(y1, x1, y2, x2, 1);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillMap(y1, x1, y2, x2, 2);
        }
        bfs();
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

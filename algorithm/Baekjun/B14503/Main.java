package algorithm.Baekjun.B14503;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int count = 0;
    static boolean[][] isCleaned;
    static int robotX, robotY, robotD;
    static int isNearCleaned(int y, int x) { // -1 : 청소 안됨, 정수(방향) : 청소 됨
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(map[newY][newX] == 1) continue;
            if(!isCleaned[newY][newX]) return i;
        }
        return -1;
    }
    static void bfs() throws IOException {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {robotY, robotX, robotD});
        isCleaned[robotY][robotX] = true;
        count++;

        while(true) {
            Integer[] p = q.poll();
            isCleaned[p[0]][p[1]] = true;

            int near = isNearCleaned(p[0], p[1]);
            if(near == -1) {
                int newY = p[0] - dy[p[2]];
                int newX = p[1] - dx[p[2]];

                if(map[newY][newX] == 1) break;
                else {
                    q.add(new Integer[] {newY, newX, p[2]});
                }
            }
            else {
                int d = p[2] - 1;
                if(d == -1) d = 3;
                while(true) {
                    int newY = p[0] + dy[d];
                    int newX = p[1] + dx[d];
                    if(map[newY][newX] == 1 || isCleaned[newY][newX]) {
                        d -= 1;
                        if(d == -1) d = 3;
                    }
                    if(map[newY][newX] == 0 && !isCleaned[newY][newX]) {
                        break;
                    }
                }

                int newY = p[0] + dy[d];
                int newX = p[1] + dx[d];

                q.add(new Integer[] {newY, newX, d});
                count++;
                isCleaned[newY][newX] = true;
            }
            bw.flush();
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isCleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        robotY = Integer.parseInt(st.nextToken());
        robotX = Integer.parseInt(st.nextToken());
        robotD = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        bw.write(count + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

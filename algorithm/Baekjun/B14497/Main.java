package algorithm.Baekjun.B14497;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int y1, x1; // 주난
    static int y2, x2; // 범인
    static int[][] map;
    static boolean[][] visited;
    static boolean isFound = false;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y1, x1});
        visited[y1][x1] = false;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;

                if(map[newY][newX] == 1) {
                    map[newY][newX] = 0;
                }
                else if(map[newY][newX] == 2) {
                    isFound = true;
                    break;
                }
                else if(map[newY][newX] == 0) {
                    q.add(new Integer[] {newY, newX});
                }
                visited[newY][newX] = true;
            }
            if(isFound) break;
        }
    }
    static void draw() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void countJump() {
        while(true) {
            bfs();
            // System.out.println("-------------------");
            // draw();
            // System.out.println("-------------------");
            count++;
            if(isFound) break;
            else {
                visited = new boolean[n][m];
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
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                if(strs[j].equals("#")) {
                    map[i][j] = 2;
                    y2 = i; x2 = j;
                }
                else if(strs[j].equals("*")) {
                    map[i][j] = 7;
                    y1 = i; x1 = j;
                }
                else {
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }
        }

        countJump();
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

package algorithm.Baekjun.B2573;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static int year = 0;
    static int checkCount(int y, int x) { // 주변의 0의 개수를 센다
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] == 0) count++;
        }
        return count;
    }
    static boolean bfs(int y, int x) {
        if(map[y][x] == 0 || visited[y][x]) return false;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            int checkNearZeros = checkCount(p[0], p[1]);
            if(map[p[0]][p[1]] > checkNearZeros) newMap[p[0]][p[1]] = map[p[0]][p[1]] - checkNearZeros;
            else newMap[p[0]][p[1]] = 0;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == 0) continue;
                q.add(new Integer[] {newY, newX});
                visited[newY][newX] = true;
            }
        }
        return true;
    }
    
    static boolean checkAllZero() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) return false;
            }
        }
        return true;
    }

    static void countYear() {
        while(true) {
            int count = 0; // 빙산의 개수
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(bfs(i, j)) count += 1;
                }
            }
            if(checkAllZero()) {
                year = 0;
                break;
            }
            if(count >= 2) break;
            else {
                map = newMap;
                newMap = new int[n][m];
                visited = new boolean[n][m];
                year += 1;
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
        newMap = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        countYear();
        bw.write(year + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

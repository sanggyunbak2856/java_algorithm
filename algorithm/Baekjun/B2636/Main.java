package algorithm.Baekjun.B2636;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static int lastCheese;
    static void bfs_0(int y, int x, int k) { // k = 0이면 map[y][x] = 0, 2면 map[y][x] = 2
        if(visited[y][x]) return;
        Queue<Integer[]> q = new LinkedList<>();
        map[y][x] = k;
        visited[y][x] = true;
        q.add(new Integer[] {y, x});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                
                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] != 0) continue;

                map[newY][newX] = k;
                visited[newY][newX] = true;
                q.add(new Integer[] {newY, newX});
            }
        }
    }
    static boolean isAirExistNear(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] == 0) return true;
        }
        return false;
    }
    static void meltCheese(int y, int x, int[][] newMap) {
        if(visited[y][x]) return;
        if(map[y][x] != 1) return;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        visited[y][x] = true;
        if(isAirExistNear(y, x)) newMap[y][x] = 0;
        else newMap[y][x] = 1;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(isAirExistNear(p[0], p[1])) newMap[p[0]][p[1]] = 0;
            else newMap[p[0]][p[1]] = 1;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] != 0) continue;

                q.add(new Integer[] {newY, newX});
                visited[newY][newX] = true;
            }
        }
        
    }
    static void labelling() {
        bfs_0(0, 0, 0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) bfs_0(i, j, 2);
            }
        }
    }
    static int countCheese(int[][] newMap) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(newMap[i][j] == 1) count++;
            }
        }
        return count;
    }
    static void countHour() {
        while(true) {
            count+=1;
            int[][] newMap = new int[n][m];
            labelling();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    meltCheese(i, j, newMap);
                }
            }
            int cheese = countCheese(newMap);
            if(cheese == 0) {
                lastCheese = countCheese(map);
                break;
            }
            else {
                map = newMap;
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
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countHour();
        bw.write(count + "\n");
        bw.write(lastCheese + "\n");
        bw.flush();
        bw.flush();
        br.close();
        bw.close();
    }
}

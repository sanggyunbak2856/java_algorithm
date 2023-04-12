package algorithm.Baekjun.B2638;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void labellingBfs(int y, int x, int k) {
        if(map[y][x] != 0) return;
        if(visited[y][x]) return;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        visited[y][x] = true;
        map[y][x] = k;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(map[newY][newX] != 0) continue;
                if(visited[newY][newX]) continue;
                map[newY][newX] = k;
                visited[newY][newX] = true;
                q.add(new Integer[] {newY, newX});
            }
        }
    }
    static void labelling() {
        labellingBfs(0, 0, 0);
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                labellingBfs(i, j, 2);
            }
        }
    }
    static boolean canMeltCheese(int y, int x) {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] == 0) count++;
            if(count == 2) return true;
        }
        return false;
    }
    static void meltCheese(int y, int x, int[][] newMap) {
        if(map[y][x] != 1) return;
        if(visited[y][x]) return;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        visited[y][x] = true;
        if(canMeltCheese(y, x)) newMap[y][x] = 0;
        else newMap[y][x] = 1;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] != 1) continue;

                q.add(new Integer[] {newY, newX});
                visited[newY][newX] = true;
                if(canMeltCheese(newY, newX)) newMap[newY][newX] = 0;
                else newMap[newY][newX] = 1;
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
    static void draw(int[][] newMap) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(newMap[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int countHour() {
        int count = 0;
        while(true) {
            count++;
            int[][] newMap = new int[n][m];
            labelling();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    meltCheese(i, j, newMap);
                }
            }
            System.out.println();
            draw(newMap);
            if(countCheese(newMap) == 0) break;
            else {
                map = newMap;
                visited = new boolean[n][m];
            }
        }
        return count;
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

        int answer = countHour();
        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

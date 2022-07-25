package algorithm.Graph.G10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static boolean[][] visited_1;
    static boolean[][] visited_2;
    static int count_1 = 0, count_2 = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs_1(int y, int x) {
        if(visited_1[y][x] == true) return;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        int color = map[y][x];

        while(!q.isEmpty()) {
            Integer[] v = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = v[0] + dy[i];
                int newX = v[1] + dx[i];

                if(newX < 0 || newX >= map.length || newY < 0 || newY >= map.length) continue;
                if(visited_1[newY][newX]) continue;
                if(map[newY][newX] == color) {
                    q.add(new Integer[] {newY, newX});
                    visited_1[newY][newX] = true;
                }
            }
        }
        count_1++;
    }
    static void bfs_2(int y, int x) {
        if(visited_2[y][x] == true) return;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        int color = map[y][x];

        while(!q.isEmpty()) {
            Integer[] v = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = v[0] + dy[i];
                int newX = v[1] + dx[i];
                if(newY < 0 || newY >= map.length || newX < 0 || newX >= map.length) continue;
                if(visited_2[newY][newX] == true) continue;
                if(color == 0 || color == 1) {
                    if(map[newY][newX] == 0 || map[newY][newX] == 1) {
                        q.add(new Integer[] {newY, newX});
                        visited_2[newY][newX] = true;
                    }
                }
                if(color == 2) {
                    if(map[newY][newX] == color) {
                        q.add(new Integer[] {newY, newX});
                        visited_2[newY][newX] = true;
                    }
                }
            }
        }
        count_2++;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited_1 = new boolean[n][n];
        visited_2 = new boolean[n][n];

        for(int i = 0; i < n; i++) { // R: 0, G: 1, B: 2
            char[] str = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                if(str[j] == 'R') map[i][j] = 0;
                if(str[j] == 'G') map[i][j] = 1;
                if(str[j] == 'B') map[i][j] = 2;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                bfs_1(i, j);
                bfs_2(i, j);
            }
        }
        System.out.println(count_1 + " " + count_2);
 
        br.close();
    }
}

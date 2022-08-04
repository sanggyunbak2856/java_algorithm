package algorithm.Graph.G2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visitedWallBroken;
    static int minDistance = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean arrived = false;
    static void print() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 0}); // y, x, count, broke(0 -> no, 1 -> yes)

        while(!q.isEmpty()) {
            int[] v = q.poll();
            if(v[0] == map.length - 1 && v[1] == map[0].length - 1) {
                arrived = true;
                minDistance = Math.min(minDistance, v[2]);
            }

            for(int i = 0; i < 4; i++) {
                int newY = v[0] + dy[i];
                int newX = v[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length) continue; // bound
                if(map[newY][newX] == 0 && v[3] == 0 && visited[newY][newX] == false) {
                    visited[newY][newX] = true;
                    q.add(new int[] {newY, newX, v[2] + 1, v[3]});
                }
                if(map[newY][newX] == 1 && v[3] == 0 && visitedWallBroken[newY][newX] == false) {
                    visitedWallBroken[newY][newX] = true;
                    q.add(new int[] {newY, newX, v[2] + 1, 1});
                }
                if(map[newY][newX] == 0 && v[3] == 1 && visitedWallBroken[newY][newX] == false) {
                    visitedWallBroken[newY][newX] = true;
                    q.add(new int[] {newY, newX, v[2] + 1, 1});
                }
                
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        visitedWallBroken = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        if(arrived) System.out.println(minDistance + 1);
        else System.out.println(-1);
        br.close();
    }
}

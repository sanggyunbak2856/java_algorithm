package algorithm.Graph.G2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static void print() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    static void bfs(int y, int x, int base){
        if(map[y][x] < base) return;
        if(visited[y][x]) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});

        while(!q.isEmpty()) {
            int[] v = q.poll();
            visited[v[0]][v[1]] = true;
            
            for(int i = 0; i < 4; i++) {
                int newY = v[0] + dy[i];
                int newX = v[1] + dx[i];
                if(newY < 0 || newX < 0 || newY >= map.length || newX >= map.length) continue;
                if(visited[newY][newX] == false && map[newY][newX] >= base) {
                    visited[newY][newX] = true;
                    q.add(new int[] {newY, newX}); 
                }
            }
        }
        count++;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 1; i < 101; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    bfs(j, k, i);
                }
            }
            max = Math.max(max, count);
            count = 0;
            visited = new boolean[n][n];
        }

        System.out.println(max);

        br.close();
    }
}

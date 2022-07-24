package algorithm.Graph.G1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static void bfs(int x, int y){
        if(visited[x][y]) return;
        if(map[x][y] == 0) return;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {x, y});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;
            for(int i = 0; i < 4; i++) {
                int newX = p[0] + dx[i];
                int newY = p[1] + dy[i];

                if(newX < 0 || newY < 0 || newX >= map.length || newY >= map[0].length) continue;
                if(map[newX][newY] == 0) continue;
                if(visited[newX][newY] == false && map[newX][newY] == 1) {
                    q.add(new Integer[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        count++;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];
            int k = Integer.parseInt(st.nextToken());

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int j = 0; j < m; j++) {
                for(int l = 0; l < n; l++) {
                    bfs(j, l);
                }
            }

            System.out.println(count);
            count = 0;
        }

        br.close();
    }
}

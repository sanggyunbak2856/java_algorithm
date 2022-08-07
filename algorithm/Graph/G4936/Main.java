package algorithm.Graph.G4936;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static int w;
    static int h;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};
    static int count = 0;
    static void bfs(int y, int x) {
        if(map[y][x] == 0 || map[y][x] == 2) return; // 0 : 바다, 2 : 방문했던곳

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});

        while(!q.isEmpty()) {
            int[] v = q.poll();

            for(int i = 0; i < 8; i++) {
                int newY = v[0] + dy[i];
                int newX = v[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= h || newX >= w) continue;
                if(map[newY][newX] == 1) {
                    q.add(new int[] {newY, newX});
                    map[newY][newX] = 2;
                }
            }
        }
        count++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    bfs(i, j);
                }
            }

            System.out.println(count);

            // 초기화
            count = 0;

        }

        br.close();
    }
}

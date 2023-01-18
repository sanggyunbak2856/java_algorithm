package algorithm.Graph.G7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] map;
    static void bfs(int startY, int startX, int endY, int endX) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {startY, startX, 0});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(p[0] == endY && p[1] == endX) {
                min = p[2] < min ? p[2] : min;
                continue;
            }

            for(int i = 0; i < 8; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;

                if(map[newY][newX] == 0) {
                    map[newY][newX] = p[2] + 1;
                    q.add(new Integer[] {newY, newX, p[2] + 1});
                }
                else {
                    int count = map[newY][newX];
                    if(p[2] + 1 < count) {
                        q.add(new Integer[] {newY, newX, p[2] + 1});
                        map[newY][newX] = p[2] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            bfs(startY, startX, endY, endX);
            bw.write(min + "\n");
            bw.flush();

            min = Integer.MAX_VALUE;
        }

        br.close();
        bw.close();
    }
}

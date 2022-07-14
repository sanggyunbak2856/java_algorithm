package algorithm.Graph.G1012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static int[][] map;
    public static int count = 1; // count - 1
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(int x, int y) {
        if(map[x][y] != 1) return;
        count++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int px = p[0]; int py = p[1];
            map[px][py] = count; 

            for(int i = 0; i < 4; i++) {
                int newX = px + dx[i];
                int newY = py + dy[i];
                if(newX < 0 || newY < 0 || newX >= map.length || newY >= map[0].length) {
                    continue;
                }
                if(map[newX][newY] == 1) {
                    queue.add(new int[] {newX, newY});
                }
            }
        }
    }

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) { // t회 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 수
            map = new int[m][n]; // 지도
            for(int j = 0; j < k; j++) { // 지도 만들기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for(int a = 0; a < m; a++) {
                for(int b = 0; b < n; b++) {
                    bfs(a, b);
                }
            }
            bw.write(count -1 + "");
            bw.flush();
            count = 1;
        }

        br.close();
        bw.close();
    }
}

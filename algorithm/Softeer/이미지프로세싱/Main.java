package algorithm.Softeer.이미지프로세싱;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int height;
    static int width;
    static void changeColor(int y, int x, int c) {
        boolean[][] visited = new boolean[height][width];
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        int oldColor = map[y][x];

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;
            map[p[0]][p[1]] = c;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= height || newX >= width) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] != oldColor) continue;
                q.add(new Integer[] {newY, newX});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        for(int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            changeColor(y - 1, x - 1, c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

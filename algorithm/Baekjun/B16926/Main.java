package algorithm.Baekjun.B16926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, r;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static void draw() throws IOException{
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
    }
    static void rotate(int l) {
        if(visited[l][l]) return;

        Deque<Integer> dq = new LinkedList<>();
        int currentY = l;
        int currentX = l;
        int currentD = 0;
        if((n % 2 == 1) && (m % 2 == 1) && (currentY == n / 2) && (currentX == m / 2)) return;
        dq.addLast(map[currentY][currentX]);
        visited[currentY][currentX] = true;

        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == l && newX == l) break;
            if(newY < l || newX < l || newY >= n - l || newX >= m - l) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            if(visited[newY][newX]) return;
            else {
                dq.addLast(map[newY][newX]);
                visited[newY][newX] = true;
                currentY = newY;
                currentX = newX;
            }
        }

        int last = dq.removeFirst();
        dq.addLast(last);

        currentY = l;
        currentX = l;
        currentD = 0;
        map[currentY][currentX] = dq.removeFirst();
        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == l && newX == l) break;
            if(newY < l || newX < l || newY >= n - l || newX >= m - l) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            else {
                map[newY][newX] = dq.poll();
                currentY = newY;
                currentX = newX;
            }
        }
        
        rotate(l + 1);
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < r; i++) {
            rotate(0);
            visited = new boolean[n][m];
        }
        draw();

        br.close();
        bw.close();
    }
}

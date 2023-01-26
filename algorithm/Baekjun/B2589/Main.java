package algorithm.Baekjun.B2589;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs(int y, int x) {
        if(map[y][x] == 'W') return;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x, 0});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                int count = p[2] + 1;

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == 'W') continue;

                q.add(new Integer[] {newY, newX, count});
                max = count > max ? count : max;
                visited[newY][newX] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bfs(i, j);
                visited = new boolean[n][m];
            }
        }

        bw.write(max+ "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

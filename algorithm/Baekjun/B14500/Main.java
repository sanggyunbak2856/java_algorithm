package algorithm.Baekjun.B14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static boolean checkLine(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(visited[newY][newX]) return true;
        }
        return false;
    }
    static void findMaxDfs(int y, int x, int depth, int sum) {
        if(depth == 4) {
            max = sum > max ? sum : max;
            return;
        }

        for(int i = 0; i < 8; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(visited[newY][newX]) continue;
            if(!checkLine(newY, newX)) continue;
            visited[newY][newX] = true;
            findMaxDfs(newY, newX, depth + 1, sum + map[newY][newX]);
            visited[newY][newX] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                findMaxDfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        bw.write(max + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

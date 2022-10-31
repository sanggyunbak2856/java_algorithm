package algorithm.Backtracking.B1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int r;
    static int m;
    static int max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static void dfs (int y, int x, int count) {
        boolean isEnd = true;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= r || newX >= m) continue;
            char target = map[newY][newX];
            int order = target - 'A';
            if(visited[order]) continue;
            visited[order] = true;
            isEnd = false;
            dfs(newY, newX, count + 1);
            visited[order] = false;
        }
        if(isEnd) {
            max = count > max ? count : max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[r][m];

        for(int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = str[j].charAt(0);
            }
        }

        char target = map[0][0];
        int order = target  - 'A';
        visited[order] = true;
        dfs(0, 0, 1);
        System.out.println(max);

        br.close();
    }
}

package algorithm.Baekjun.B14502;

import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int[][] bfs(int[][] map, int n, int m,  List<int[]> viruses) {
        Queue<int[]> q = new LinkedList<>();
        for(int[] p : viruses) q.add(p);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] newMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()) {
            int[] p = q.poll();
            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(newMap[newY][newX] != 0) continue;
                newMap[newY][newX] = 2;
                q.add(new int[] {newY, newX});
            }
        }

        return newMap;
    }
    static void backtracking(int[][] map, int n, int m,  List<int[]> viruses, int depth) {
        if(depth == 3) {
            int[][] newMap = bfs(map, n, m, viruses);
            int emptySpace = count(newMap, n, m);
            max = emptySpace > max ? emptySpace : max;
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) continue;
                map[i][j] = 1;
                backtracking(map, n, m, viruses, depth + 1);
                map[i][j] = 0;
            }
        }
    }
    static int count(int[][] map, int n, int m) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> viruses = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) viruses.add(new int[] {i, j});
            }
        }

        backtracking(map, n, m, viruses, 0);
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

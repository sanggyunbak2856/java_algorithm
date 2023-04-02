package algorithm.Baekjun.B16946;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;
    static Map<Integer, Integer> zeroMap = new HashMap<>();
    static int num = 2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void zeroMap(int y, int x) {
        if(visited[y][x]) return;
        if(map[y][x] != 0) return;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        visited[y][x] = true;
        map[y][x] = num;
        int count = 1;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m ) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == 1) continue;
                if(map[newY][newX] == 0) {
                    map[newY][newX] = num;
                    visited[newY][newX] = true;
                    q.add(new Integer[] {newY, newX});
                    count++;
                }
            }
        }
        zeroMap.put(num, count);
        num += 1;
    }
    static void countZeros(int y, int x) {
        if(map[y][x] != 1) return;
        Set<Integer> pick = new HashSet<>();
        int total = 0;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] != 1) {
                int zeroNum = map[newY][newX];
                if(!pick.contains(zeroNum)) {
                    total += zeroMap.get(zeroNum);
                    pick.add(zeroNum);
                }
            }
        }
        answer[y][x] = (total + 1) % 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        // zero map
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                zeroMap(i, j);
            }
        }

        // 벽 부수기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                countZeros(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

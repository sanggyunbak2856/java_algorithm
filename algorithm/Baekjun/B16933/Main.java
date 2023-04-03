package algorithm.Baekjun.B16933;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 0, 0, 1, 0}); // 낮 -> 0, 밤 -> 1
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(p[0] == n - 1 && p[1] == m - 1) {
                min = p[3] < min ? p[3] : min;
            }
            
            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[p[2]][newY][newX]) continue;
                if(p[4] == 0) { // 낮
                    // 낮일 때는 이동을 멈출 이유가 없다 (벽은 그냥 부수면됨)
                    if(map[newY][newX] == 0) { // 벽 아닌 경우
                        q.add(new Integer[] {newY, newX, p[2], p[3] + 1, 1});
                        visited[p[2]][newY][newX] = true;
                    }
                    else { // 벽인 경우
                        if(p[2] + 1 <= k && !visited[p[2] + 1][newY][newX]) {
                            q.add(new Integer[] {newY, newX, p[2] + 1, p[3] + 1, 1});
                            visited[p[2] + 1][newY][newX] = true;
                        }
                    }

                }
                else { // 밤
                    // 이동을 멈출 수 있다
                    // 벽이 있을 때는 이동 불가능
                    if(map[newY][newX] == 0) {
                        q.add(new Integer[] {newY, newX, p[2], p[3] + 1, 0});
                        visited[p[2]][newY][newX] = true;
                        
                    }
                    else { // 벽인 경우, 이동 불가능하므로 대기하기
                        q.add(new Integer[] {p[0], p[1], p[2], p[3] + 1, 0});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[k + 1][n][m];
        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

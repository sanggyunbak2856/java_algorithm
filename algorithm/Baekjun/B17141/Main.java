package algorithm.Baekjun.B17141;

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int totalCalled = 0;
    static void bfs(Set<int[]> selectedViruses, int[][] map) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (o1, o2) -> o1[2] - o2[2]
        );
        int currentMax = 0;
        for(int[] virus : selectedViruses) {
            q.add(new int[] {virus[0], virus[1], 1});
            map[virus[0]][virus[1]] = 1;
        }

        while(!q.isEmpty()) {
            int[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= map.length || newX >= map.length) continue;
                if(map[newY][newX] != 0) continue;
                map[newY][newX] = p[2] + 1;
                q.add(new int[] {newY, newX, p[2] + 1});
                currentMax = map[newY][newX] > currentMax ? map[newY][newX] : currentMax;
            }
        }

        if(isMapFilled(map)) {
            if(currentMax == 0) min = 1;
            else if(currentMax < min) min = currentMax;
        }
    }
    // 바이러스 
    static void backtracking(List<int[]> viruses, Set<int[]> selectedViruses, int depth, int m, int prev, int[][] map, boolean[] visited) {
        totalCalled += 1;
        if(depth == m) {
            int[][] newMap = new int[map.length][map.length];
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map.length; j++) {
                    if(map[i][j] == 1) newMap[i][j] = -1;
                }
            }
            bfs(selectedViruses, newMap);
            return;
        }
        for(int i = prev; i < viruses.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selectedViruses.add(viruses.get(i));
            backtracking(viruses, selectedViruses, depth + 1, m, i + 1, map, visited);
            selectedViruses.remove(viruses.get(i));
            visited[i] = false;
        }
    }
    static boolean isMapFilled(int[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]> viruses = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) viruses.add(new int[] {i, j});
            }
        }
        backtracking(viruses, new HashSet<int[]>(), 0, m, 0, map, new boolean[viruses.size()]);
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(min - 1 + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

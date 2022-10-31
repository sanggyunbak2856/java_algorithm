package algorithm.Graph.G16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int day = 0;
    static boolean unionFormed = false;
    static void checkUnion(int y, int x) { // 연합 찾기, 계산
        if (visited[y][x]) return;
        Queue<Integer[]> queue = new LinkedList<>();
        List<Integer[]> unionList = new LinkedList<>();
        int populationSum = 0;

        queue.add(new Integer[] {y, x});
        unionList.add(new Integer[] {y, x});
        populationSum += map[y][x];

        while(!queue.isEmpty()) {
            Integer[] p = queue.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
                if(visited[newY][newX]) continue;

                int diff = Math.abs(map[p[0]][p[1]] - map[newY][newX]);

                if(diff >= l && diff <= r) {
                    queue.add(new Integer[] {newY, newX});
                    unionList.add(new Integer[] {newY, newX});
                    unionFormed = true;
                    populationSum += map[newY][newX];
                    visited[newY][newX] = true;
                }
            }
        }

        if(unionList.size() > 1) {
            for(Integer[] p : unionList) {
                map[p[0]][p[1]] = populationSum / unionList.size();
            }
        }
    }
    static void movementByDay() {
        while(true) {
            unionFormed = false;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        checkUnion(i, j);
                    }
                }
            }
            if (!unionFormed) return;
            day++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        movementByDay();
        System.out.println(day);

        br.close();
    }
}

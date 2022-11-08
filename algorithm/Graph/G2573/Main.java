package algorithm.Graph.G2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    // 빙산이 두 덩이로 나뉘어지는 시간을 구하는 것
    // bfs 이용
        // 맵 전체 순회하여 녹는 것 계산
        // 빙산이 나뉘어졌다면 day 출력
        // 빙산이 나뉘어지지 않았다면 day + 1하고 다시 녹는것 계산
        // 빙산 count 변수로 확인

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static int day = 0;
    static boolean isAllZero = true;
    static void bfs(int y, int x) {
        if(visited[y][x]) return;
        if(map[y][x] == 0) return;
        
        isAllZero = false;
        count+=1;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(map[newY][newX] == 0 && map[p[0]][p[1]] > 0 && !visited[newY][newX]) {
                    map[p[0]][p[1]] -= 1;
                    continue;
                }
                if(visited[newY][newX]) continue;

                q.add(new Integer[] {newY, newX});
                visited[newY][newX] = true;
            }
        }
    }
    static void draw() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void countDay() {
        while(true) {
            isAllZero = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    bfs(i, j);
                }
            }
            System.out.println("_____________________");
            draw();
            if(count > 1) break;
            else if(isAllZero) {
                System.out.println(count);
                break;
            }
            else {
                day += 1;
                count = 0;
                visited = new boolean[n][m];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        countDay();
        draw();
        System.out.println(day);
        br.close();
    }
}

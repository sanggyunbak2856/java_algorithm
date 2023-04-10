package algorithm.Baekjun.B16236;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int sharkY, sharkX;
    static int sharkSize = 2;
    static int sharkFishes = 0;
    static int countSeconds = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        PriorityQueue<Integer[]> fishes = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[2] == o2[2]) { // 거리가 같을 때
                    if(o1[0] == o2[0]) { // y값이 같을 때
                        return o1[1] - o2[1]; // x값으로 정렬 (오름차순)
                    }
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        );

        q.add(new Integer[] {sharkY, sharkX, 0, sharkSize, sharkFishes});
        visited[sharkY][sharkX] = true;
        map[sharkY][sharkX] = 0;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == 0) {
                    q.add(new Integer[] {newY, newX, p[2] + 1, p[3], p[4]});
                    visited[newY][newX] = true;
                }
                else if(map[newY][newX] < p[3]) { // 물고기 먹음 
                    if(p[4] + 1 >= p[3]) {  // 물고기 먹었을 때 자기 자신의 크기만큼 먹음
                        q.add(new Integer[] {newY, newX, p[2] + 1, p[3] + 1, 0});
                        fishes.add(new Integer[] {newY, newX, p[2] + 1, p[3] + 1, 0});
                        visited[newY][newX] = true;
                    }
                    else {
                        q.add(new Integer[] {newY, newX, p[2] + 1, p[3], p[4] + 1});
                        fishes.add(new Integer[] {newY, newX, p[2] + 1, p[3], p[4] + 1});
                        visited[newY][newX] = true;
                    }
                }
                else if(map[newY][newX] == p[3]) {
                    q.add(new Integer[] {newY, newX, p[2] + 1, p[3], p[4]});
                    visited[newY][newX] = true;
                }
                else {
                    continue;
                }
            }
        }

        if(fishes.isEmpty()) {
            return false;
        }
        else {
            Integer[] p = fishes.poll();
            sharkY = p[0];
            sharkX = p[1];
            sharkSize = p[3];
            sharkFishes = p[4];
            countSeconds += p[2];
            visited = new boolean[n][n];
            map[sharkY][sharkX] = 0;
            return true;
        }
    }
    static void count() {
        while(true) {
            if(!bfs()) break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                }
            }
        }

        count();
        bw.write(countSeconds + "\n");

        br.close();
        bw.close();
    }
}

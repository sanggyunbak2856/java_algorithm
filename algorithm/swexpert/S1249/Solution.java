package algorithm.swexpert.S1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 0, 0});

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;
            int curTime = p[2];

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= N || newX >= N) continue;
                int newDist = curTime + map[newY][newX];
                if(newDist < dist[newY][newX]) {
                    dist[newY][newX] = newDist;
                    q.add(new Integer[] {newY, newX, newDist});
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];

            for(int j = 0; j < N; j++) {
                String[] nums = br.readLine().split("");
                for(int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(nums[k]);
                    dist[j][k] = Integer.MAX_VALUE;
                }
            }

            bfs();

            System.out.printf("#%d %d\n", test_case, dist[N - 1][N - 1]);


        }
        br.close();
    }
}

package algorithm.dp.D17070;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static int n;
    static int count = 0;
    static void bfs() {
        if(map[n][n] == 1) return;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {1, 2, 0}); // v[2] 0 -> 가로 1 -> 세로 2 - > 대각선

        while(!q.isEmpty()){
            Integer[] v = q.poll();
            if(v[0] == n && v[1] == n && map[v[0]][v[1]] == 0) {
                count++;
                continue;
            }

            // 가로
            if(v[2] == 0) {
                // 가로 -> 가로
                if(v[1] + 1 < n + 1) {
                    if(map[v[0]][v[1] + 1] == 0) 
                            q.add(new Integer[] {v[0], v[1] + 1, 0});
                }
                // 가로 -> 대각선
                // 대각선 bound 확인
                if((v[0] + 1 < n + 1) && (v[1] + 1 < n + 1)) {
                    // 벽 존재 확인
                    if(map[v[0]][v[1] + 1] == 0 && 
                    map[v[0] + 1][v[1]] == 0 && 
                    map[v[0] + 1][v[1] + 1] == 0 
                   ) {
                        // (n, n) 인지 확인
                            q.add(new Integer[] {v[0] + 1, v[1] + 1, 2});
                    }
                }
            }
            // 세로 -> 대각선
            if(v[2] == 1) {
                // 세로 -> 세로
                if(v[0] + 1 < n + 1) {
                    if(map[v[0] + 1][v[1]] == 0) {
                            q.add(new Integer[] {v[0] + 1, v[1], 1});
                    }
                }
                // 세로 -> 대각선
                // bound 확인
                if(v[1] + 1 < n + 1 && v[0] + 1 < n + 1) {
                    // 벽 확인
                    if(map[v[0]][v[1] + 1] == 0 && map[v[0] + 1][v[1]] == 0 && map[v[0]+1][v[1]+1] == 0) {
                            q.add(new Integer[] {v[0] + 1, v[1] + 1, 2});
                    }
                }
            }
            // 대각선
            if(v[2] == 2) {
                // 가로
                if(v[1] + 1 < n + 1) {
                    if(map[v[0]][v[1] + 1] == 0) {
                            q.add(new Integer[] {v[0], v[1] + 1, 0});
                    }
                }
                // 세로
                if(v[0] + 1 < n + 1) {
                    if(map[v[0] + 1][v[1]] == 0) {
                            q.add(new Integer[] {v[0] + 1, v[1], 1});
                    }
                }
                // 대각선
                if(v[0] + 1 < n + 1 && v[1] + 1 < n + 1) {
                    if(map[v[0] + 1][v[1] + 1] == 0 && map[v[0] + 1][v[1]] == 0 && map[v[0]][v[1] + 1] == 0) {
                            q.add(new Integer[] {v[0] + 1, v[1] + 1, 2});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1]; // (1,2)에서 시작, (n,n)까지
        
        for(int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(count);

        br.close();
    }
}

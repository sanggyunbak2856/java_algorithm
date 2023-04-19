package algorithm.Baekjun.B14430;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int calc() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int leftX = j - 1;
                int upY = i - 1;

                if(leftX < 0 && upY < 0) continue;
                else if(leftX < 0 && upY >= 0) {
                    map[i][j] = Math.max(map[i][j], map[i][j] + map[upY][j]);
                }
                else if(leftX >= 0 && upY < 0) {
                    map[i][j] = Math.max(map[i][j], map[i][j] + map[i][leftX]);
                }
                else if(leftX >= 0 && upY >= 0){
                    map[i][j] = Math.max(map[i][j] + map[upY][j], map[i][j] + map[i][leftX]);
                }
            }
        }
        return map[n - 1][m - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        int answer = calc();
        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

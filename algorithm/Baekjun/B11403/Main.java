package algorithm.Baekjun.B11403;

import java.io.*;
import java.util.*;

public class Main {
    static void floydWarshall(int[][] map) {
        int n = map.length;
        for(int i = 0; i < n; i++) { // 거쳐가는 노드
            for(int j = 0; j < n; j++) { // 출발 노드
                for(int k = 0; k < n; k++) { // 도착 노드
                    if((map[j][i] == 1) && (map[i][k] == 1)) map[j][k] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall(map);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

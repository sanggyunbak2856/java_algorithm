package algorithm.Baekjun.B1956;

import java.util.*;
import java.io.*;

public class Main {
    static int v, e;
    static int[][] map;
    static void floydWarshall() {
        for(int i = 0; i < v; i++) { // 거쳐가는 노드
            for(int j = 0; j < v; j++) { // 출발 노드
                for(int k = 0; k < v; k++) { // 도착 노드
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        map = new int[v][v];
        for(int i = 0; i < v; i++) {
            Arrays.fill(map[i], 9999999);
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map[from][to] = cost;
        }

        floydWarshall();

        int min = 9999999;
        for(int i = 0; i < v; i++) {
            min = map[i][i] < min ? map[i][i] : min;
        }

        if(min != 9999999) bw.write(min + "\n");
        else bw.write("-1\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

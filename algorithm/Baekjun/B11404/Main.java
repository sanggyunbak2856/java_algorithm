package algorithm.Baekjun.B11404;

import java.io.*;
import java.util.*;

public class Main {
    static void floydWarshall(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = 100001;
            }
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[from - 1][to - 1] = Math.min(arr[from - 1][to - 1], cost);
        }

        floydWarshall(arr);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 100001) bw.write(0 + " ");
                else bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

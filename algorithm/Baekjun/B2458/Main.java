package algorithm.Baekjun.B2458;

import java.io.*;
import java.util.*;

public class Main {
    static int INF = 100000;
    static void floydWarshall(int[][] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                for(int k = 1; k < n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
    }
    static int countPerson(int[][] arr, int n) {
        int sum = 0;
        int size = arr.length;
        // col
        for(int i = 1; i < size; i++) {
            if(arr[n][i] != INF) sum += 1;
            if(arr[i][n] != INF) sum += 1;
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                arr[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
        }

        floydWarshall(arr);
        int count = 0;
        for(int i = 1; i < n + 1; i++) {
            if(countPerson(arr, i) == n - 1) count+=1;
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

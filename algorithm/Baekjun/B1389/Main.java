package algorithm.Baekjun.B1389;

import java.io.*;
import java.util.*;

public class Main {
    static void floydWarshall(int[][] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                for(int k = 1; k < n; k++) {
                    if(arr[j][i] >= 1 && arr[i][k] >= 1) {
                        arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                    }
                }
            }
        }
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
                if(i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = 10000;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        floydWarshall(arr);
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<>( // idx, count
            (o1, o2) -> {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        );

        for(int i = 1; i < n + 1; i++) {
            int sum = 0;
            for(int j = 1; j < n + 1; j++) {
                sum += arr[i][j];
            }
            pq.add(new Integer[] {i, sum});
        }
        bw.write(pq.poll()[0] + "\n");

        br.close();
        bw.close();
    }
}

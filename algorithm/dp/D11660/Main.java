package algorithm.dp.D11660;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int base = 0;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = base;
            for(int j = 1; j <= n; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
            base = arr[i][n];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            System.out.println(arr[y2][x2] - arr[y1][x1]);
        }

        // for(int i = 1; i < n + 1; i++) {
        //     for(int j = 1; j < n + 1; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     } 
        //     System.out.println();
        // }

        br.close();
    }
}

package algorithm.Baekjun.B1025;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int max = 0;
    static boolean isPowFound = false;
    static void dfs(int num, int row, int col, int rowdiff, int coldiff) {
        // 완전제곱수 확인
        double sqrt = Math.sqrt(num);
        if(sqrt % 1 == 0) {
            isPowFound = true;
            max = num > max ? num : max;
        }

        // 다음 위치가 벗어났는지 확인
        int newRow = row + rowdiff;
        int newCol = col + coldiff;
        if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) return;

        // 다음 위치
        dfs(10 * num + arr[newRow][newCol], newRow, newCol, rowdiff, coldiff);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int rowdiff = (-1) * n; rowdiff < n; rowdiff++) {
                    for(int coldiff = (-1) * m; coldiff < m; coldiff++) {
                        // if(i == 1 && j == 2 && rowdiff == 0 && coldiff == -2) {
                        //     int x = 1;
                        // }
                        if(rowdiff == 0 && coldiff == 0) continue;
                        dfs(arr[i][j], i, j, rowdiff, coldiff);
                    }
                }
            }
        }
        if(isPowFound) bw.write(max + "\n");
        else bw.write("-1\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

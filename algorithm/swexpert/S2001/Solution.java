package algorithm.swexpert.S2001;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int sum(int[][] map, int m) {
        int max = 0;
        for(int i = 0; i <= map.length - m; i++) {
            for(int j = 0; j <= map.length - m; j++) {
                int sum = 0;
                for(int k = i; k < i + m; k++) {
                    for(int l = j; l < j + m; l++) {
                        sum += map[k][l];
                    }
                }
                max = sum > max ? sum : max;
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = sum(map, m);
            bw.write("#" + (t + 1) + " " + answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

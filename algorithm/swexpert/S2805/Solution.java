package algorithm.swexpert.S2805;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for(int j = 0; j < n; j++) {
                String[] nums = br.readLine().split("");
                for(int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(nums[k]);
                }
            }

            int sum = 0;
            for(int j = 0; j < n / 2; j++) {
                for(int k = n / 2 - j; k <= n / 2 + j; k++) {
                    sum += map[j][k];
                }
            }
            for(int j = 0; j < n; j ++) {
                sum += map[n / 2][j];
            }
            for(int j = n / 2; j > 0; j--) {
                for(int k = n / 2 - j + 1; k <= n / 2 + j - 1; k++) {
                    sum += map[n - j][k];
                }
            }

            if(n == 1) sum = map[0][0];
            bw.write("#" + (i + 1) + " " + sum + "\n");
        }

        br.close();
        bw.close();
    }
}

package algorithm.swexpert.S1209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            int max = 0;
            for(int i = 0; i < 100; i++) { // 각 행을 더한 값의 최대 
                StringTokenizer st = new StringTokenizer(br.readLine());
                int rowSum = 0;
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += arr[i][j];
                }
                max = rowSum > max ? rowSum : max;
            }

            for(int i = 0; i < 100; i++) { // 열
                int colSum = 0;
                for(int j = 0; j < 100; j++) {
                    colSum += arr[j][i];
                }
                max = colSum > max ? colSum : max;
            }

            int diagSum1 = 0;
            for(int i = 0; i < 100; i++) {
                diagSum1 += arr[i][i];
            }

            max = diagSum1 > max ? diagSum1 : max;

            int diagSum2 = 0;
            for(int i = 0; i < 100; i++) {
                diagSum2 += arr[i][99 - i];
            }

            max = diagSum2 > max ? diagSum2 : max;

            System.out.printf("#%d %d\n", n, max);

        }
        br.close();
    }
}

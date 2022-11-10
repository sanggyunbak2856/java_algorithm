package algorithm.swexpert.S1859;

import java.util.Scanner;

public class Solution {
    static long maxProfit(int[] arr) {
        long max = 0;
        long cur_max = arr[arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > cur_max) {
                cur_max = arr[i];
            }
            max += (cur_max - arr[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(sc.next());
            }

            long max = maxProfit(arr);
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ").append(max);
            System.out.println(sb);
        }
    }
}

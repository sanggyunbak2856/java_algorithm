package algorithm.swexpert.S2071;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());

            int sum = 0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }

            double avg = (double) sum / 10;
            int intavg = (int) Math.round(avg);
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ").append(intavg);
            System.out.println(sb);
        }
    }
}

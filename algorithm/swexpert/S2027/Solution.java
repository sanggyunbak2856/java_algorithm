package algorithm.swexpert.S2027;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int sum = 0;

            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if(n % 2 == 1) {
                    sum += n;
                }
            }

            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ").append(sum);
            System.out.println(sb);
        }
        
    }
}

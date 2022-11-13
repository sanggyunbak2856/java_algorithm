package algorithm.swexpert.S1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int game(int num) {
        int count = 0;

        while(num > 0) {
            int left = num % 10;
            num /= 10;

            if(left == 0) continue;
            if(left % 3 == 0) count++;
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");

        for(int i = 1; i <= n; i++) {
            int count = game(i);
            if(count == 0) sb.append(i).append(" ");
            else {
                for(int j = 0; j < count; j++) {
                    sb.append("-");
                }
                sb.append(" ");
            }

        }
        System.out.println(sb);

        br.close();
    }
}

package algorithm.swexpert.S1289;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            char[] chars = br.readLine().toCharArray();

            int index = 0;
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == '1') {
                    index = i;
                    break;
                }
            }

            int count;
            char cur_val = chars[index];
            if(cur_val == '0') count = 0;
            else count = 1;
            for(int i = index; i < chars.length; i++) {
                if(chars[i] == cur_val) continue;
                else {
                    count+=1;
                    cur_val = chars[i];
                }
            }

            System.out.printf("#%d %d\n", test_case, count);
        }

        br.close();
    }
}

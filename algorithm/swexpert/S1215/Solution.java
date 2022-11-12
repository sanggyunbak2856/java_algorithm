package algorithm.swexpert.S1215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static char[][] map;
    static int n;
    static boolean checkPalindromeMap(int start, int end, int k, boolean mode) { // mode true -> horizontal, false -> verticle
        int len = end - start;
        if (mode) {
            for(int i = 0; i < len / 2; i++) {
                if(map[k][i] == map[k][end - i]) continue;
                else return false;
            }
            return true;
        }
        else {
            for(int i = 0; i < len / 2; i++) {
                if(map[i][k] == map[end - i][k]) continue;
                else return false;
            }
            return true;
        }
    }
    static int countPalindrome() {
        int count = 0;

        // 가로, 세로
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8 - n + 1; j++) {
                if(checkPalindromeMap(j, j + n - 1, i, true)) count+=1;
                if(checkPalindromeMap(j, j + n - 1, i, false)) count+=1;
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            map = new char[8][];
            for(int i = 0; i < 8; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int count = countPalindrome();
            System.out.printf("#%d %d", test_case, count);

        }

        br.close();
    }
}

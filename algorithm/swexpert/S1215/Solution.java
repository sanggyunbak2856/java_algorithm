package algorithm.swexpert.S1215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int n;
    static char[][] map;
    static boolean checkPalindromeHorizontal(int start, int end, int row) { // start, end는  x인덱스
        int len = (end - start + 1) / 2;
        for(int i = 0; i < len; i++){
            if(map[row][start + i] == map[row][end - i]) continue;
            else return false;
        }
        return true;
    }
    static boolean checkPalindromeVerticle(int start, int end, int column) { // start, end는  y인덱스
        int len = (end - start + 1) / 2;
        for(int i = 0; i < len; i++){
            if(map[start + i][column] == map[end - i][column]) continue;
            else return false;
        }
        return true;
    }
    static int countPalindrome() {
        int count = 0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8 - n + 1; j++) {
                if(checkPalindromeHorizontal(j, j + n - 1, i)) count++;
            }
        }

        for(int i = 0; i < 8 - n + 1; i++) {
            for(int j = 0; j < 8; j++) {
                if(checkPalindromeVerticle(i, i + n - 1, j)) count++;
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            map = new char[8][];
            for(int i = 0; i < 8; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int count = countPalindrome();
            System.out.printf("#%d %d\n", test_case, count);
        }

        br.close();
    }
}

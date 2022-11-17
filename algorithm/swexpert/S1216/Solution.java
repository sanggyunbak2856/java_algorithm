package algorithm.swexpert.S1216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int max = 1;
    static char[][] map;
    static boolean checkPalindromeHorizontal(int start, int end, int row) {
        for(int i = 0; i < (end - start) / 2; i++) {
            if(map[row][start + i] == map[row][end - i]) continue;
            else return false;
        }
        return true;
    }
    static boolean checkPalindromeVerticle(int start, int end, int col) {
        for(int i = 0; i < (end - start) / 2; i++) {
            if(map[start + i][col] == map[end - i][col]) continue;
            else return false;
        }
        return true;
    }
    static void findMax() {
        // horizontal
        for(int i = 0; i < 100; i++) {
            for(int start = 0; start < 100; start++) {
                for(int end = start; end < 100; end++) {
                    if(end - start + 1 <= max) continue;
                    if(checkPalindromeHorizontal(start, end, i)) {
                        max = (end - start + 1) > max ? (end - start + 1) : max;
                    }
                    if(checkPalindromeVerticle(start, end, i)) {
                        max = (end - start + 1) > max ? (end - start + 1) : max;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            int t = Integer.parseInt(br.readLine());
            map = new char[100][];
            for(int j = 0; j < 100; j++) {
                map[j] = br.readLine().toCharArray();
            }

            findMax();
            System.out.printf("#%d %d\n", t, max);
            max = 1;
        }

        br.close();
    }
}

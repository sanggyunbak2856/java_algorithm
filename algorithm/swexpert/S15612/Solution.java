package algorithm.swexpert.S15612;

import java.util.Scanner;


public class Solution {
    static int[] arr;
    static boolean isPossible() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            arr = new int[8];
            int count = 0;

            for(int i = 0; i < 8; i++) {
                String[] str = sc.next().split("");
                for(int j = 0; j < 8; j++) {
                    if(str[j].equals('O')) {
                        arr[i] = j;
                        count += 1;
                    }
                }
                if(count > 8) break;
            }
        }
    }
}

package algorithm.swexpert.S2806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int n;
    static int[] arr;
    static int count = 0;
    static void dfs(int depth) {
        if(depth == n) {
            count += 1;
            return;
        }

        for(int i = 0; i < n; i++) {
            boolean isPossible = true;
            for(int j = 0; j < depth; j++) {
                if(arr[j] == i) { // 열이 같은 경우
                    isPossible = false;
                    break;
                }
                if(Math.abs(depth - j) == Math.abs(i - arr[j])) {
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible) continue;
            arr[depth] = i;
            dfs(depth + 1);
            arr[depth] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            dfs(0);
            System.out.printf("#%d %d\n", test_case, count);
            count = 0;
        }

        br.close();
    }
}

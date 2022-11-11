package algorithm.swexpert.S14361;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Solution {
    static int num;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static boolean isPossible = false;
    static void dfs(int depth) {
        if(isPossible) return;
        if(depth == arr.length) {
            StringBuilder sb = new StringBuilder("");
            Arrays.stream(ans).forEach(i -> sb.append(i));
            int newNum = Integer.parseInt(sb.toString());
            if((newNum % num == 0) && (newNum > num)) isPossible = true;

            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            ans[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            String strNum = br.readLine();
            num = Integer.parseInt(strNum);
            String[] arrNum = strNum.split("");
            ans = new int[arrNum.length];
            arr = new int[arrNum.length];
            visited = new boolean[arrNum.length];

            for(int i = 0; i < arrNum.length; i++) {
                arr[i] = Integer.parseInt(arrNum[i]);
            }

            dfs(0);

            if(isPossible) System.out.printf("#%d possible\n", test_case);
            else System.out.printf("#%d impossible\n", test_case);

            isPossible  = false;
        }

        br.close();
    }
}

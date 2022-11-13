package algorithm.swexpert.S2817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int num;
    static int count = 0;
    static int[] arr;
    static boolean[] visited;
    static void dfs(int depth, int sum, int k) {
        if(sum == num) {
            count++;
            return;
        }
        if(depth == n) {
            return;
        }

        for(int i = k; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, sum + arr[i], i);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visited = new boolean[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);

            System.out.printf("#%d %d\n", test_case, count);
            count = 0;
        }

        br.close();
    }
}

package algorithm.swexpert.S13428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringJoiner;

public class Solution {
    static String num;
    static String[] nums;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static void dfs(int n, int depth) {
        if(depth == 1) {
            if(nums[0].equals("0")) return;

            StringJoiner sj = new StringJoiner("");
            for(int i = 0; i < nums.length; i++) {
                sj.add(nums[i]);
            }
            int newNum = Integer.parseInt(sj.toString());
            min = min > newNum ? newNum : min;
            max = newNum > max ? newNum : max;
            return;
        }

        for(int i = n + 1; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            String tmp = nums[i];
            nums[i] = nums[n];
            nums[n] = tmp;
            dfs(n, depth + 1);
            visited[i] = false;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            num = br.readLine();
            nums = num.split("");
            visited = new boolean[nums.length];

            for(int i = 0; i < nums.length; i++) {
                dfs(i, 0);
                nums = num.split("");
            }

            int intNum = Integer.parseInt(num);
            min = min > intNum ? intNum : min;
            max = intNum > max ? intNum : max;

            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ").append(min).append(" ").append(max);
            System.out.println(sb);

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        br.close();
    }
}

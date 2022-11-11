package algorithm.swexpert.S1244;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.StringJoiner;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int change;
    static String[] nums;
    static void dfs(int k, int depth) {
        if(depth == change) {
            StringJoiner sj = new StringJoiner("");
            for(int i = 0; i < nums.length; i++) {
                sj.add(nums[i]);
            }
            int newNum = Integer.parseInt(sj.toString());
            max = newNum > max ? newNum : max;
            return;
        }

        for(int i = k; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(Integer.parseInt(nums[i]) <= Integer.parseInt(nums[j])) {
                    String tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    dfs(i, depth + 1);
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            nums = num.split("");
            change = Integer.parseInt(st.nextToken());

            dfs(0, 0);
            int intNum = Integer.parseInt(num);
            max = intNum > max ? intNum : max;
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ").append(max);
            System.out.println(sb);

            max = Integer.MIN_VALUE;
        }

        br.close();
    }
}

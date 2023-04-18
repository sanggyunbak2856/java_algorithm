package algorithm.Baekjun.B7490;

import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<String> answer = new PriorityQueue<>();
    static int calc(StringBuilder sb) {
        String str = sb.toString().replace(" ", "");
        StringTokenizer st = new StringTokenizer(str, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            if(s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            }
            else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        return sum;
    }
    static void dfs(int n, int depth, StringBuilder sb) {
        if(depth == n + 1) {
            int result = calc(sb);
            if(result == 0) {
                answer.add((sb.append("\n")).toString());
            }
            return;
        }

        StringBuilder newSb = sb.append(depth);
        if(depth < n) {
            dfs(n, depth + 1, (new StringBuilder(newSb)).append("+"));
            dfs(n, depth + 1, (new StringBuilder(newSb)).append("-"));
            dfs(n, depth + 1, (new StringBuilder(newSb)).append(" "));
        }
        else {
            dfs(n, depth + 1, newSb);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n, 1, new StringBuilder());
            for(String s : answer) {
                bw.write(s);
            }
        }

        br.close();
        bw.close();
    }
}

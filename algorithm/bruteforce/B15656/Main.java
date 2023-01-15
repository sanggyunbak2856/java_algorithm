package algorithm.bruteforce.B15656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();
    static void dfs(int depth, StringBuilder sb) {
        if(depth == m) {
            answer.append(sb).append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            dfs(depth + 1, (new StringBuilder(sb)).append(arr[i]).append(" "));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, new StringBuilder());
        bw.write(answer.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

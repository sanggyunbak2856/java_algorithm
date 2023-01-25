package algorithm.Baekjun.B15666;

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
    static void dfs(int depth, StringBuilder s, int idx, int prev) {
        if(depth == m) {
            if(!answer.toString().contains(s)) 
                answer.append(s).append("\n");
            return;
        }

        for(int i = idx; i < n; i++) {
            if(arr[i] < prev) continue;
            StringBuilder newString = new StringBuilder(s);
            newString.append(arr[i]).append(" ");
            dfs(depth + 1, newString, idx, arr[i]);
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
        dfs(0, new StringBuilder(), 0, 0);
        bw.write(answer.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

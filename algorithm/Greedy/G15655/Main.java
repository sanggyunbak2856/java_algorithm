package algorithm.Greedy.G15655;

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
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth, int curIdx, StringBuilder s) {
        if(depth == m) {
            sb.append(s).append("\n");
            return;
        }

        for(int i = curIdx; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            StringBuilder newSb = (new StringBuilder(s)).append(arr[i]).append(" ");
            dfs(depth + 1, i + 1, newSb);
            visited[i] = false;
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
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0, new StringBuilder());
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

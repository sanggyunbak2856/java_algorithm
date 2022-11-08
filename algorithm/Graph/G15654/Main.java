package algorithm.Graph.G15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static void dfs(int depth, StringBuilder sb) {
        if(depth == m) {
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(arr[i]).append(" ");
            dfs(depth + 1, newSb);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, new StringBuilder());

        br.close();
    }
}

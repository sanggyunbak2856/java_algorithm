package algorithm.Greedy.G1049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] price;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static void dfs(int curAmount, int curPrice) {
        if(curAmount >= n) {
            min = curPrice < min ? curPrice : min;
            return;
        }

        if(curPrice >= min) return;

        for(int i = 0; i < m; i++) {
            dfs(curAmount + 6, curPrice + price[i][0]);
            dfs(curAmount + 1, curPrice + price[i][1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        price = new int[m][2];
        visited = new boolean[m];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken()); // 패키지
            price[i][1] = Integer.parseInt(st.nextToken()); // 낱개
        }

        dfs(0, 0);
        bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

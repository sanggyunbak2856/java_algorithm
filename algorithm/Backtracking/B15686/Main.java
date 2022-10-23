package algorithm.Backtracking.B15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static List<Integer[]> chicken;
    static List<Integer[]> home;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static void dfs(int depth, int idx) {
        if(depth == m) {
            int sum = 0;
            for(int i = 0; i < home.size(); i++) {
                Integer[] curHome = home.get(i);
                int curHomeMin = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(!visited[j]) continue;
                    Integer[] curChicken = chicken.get(j);
                    int dist = Math.abs(curChicken[0] - curHome[0]) + Math.abs(curChicken[1] - curHome[1]);
                    curHomeMin = dist < curHomeMin ? dist : curHomeMin;
                    if (curHomeMin == 1) break;
                }
                sum += curHomeMin;
                if (sum > min) break;
            }
            min = sum < min ? sum : min;
            return;
        }
        
        for(int i = idx; i < chicken.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        visited = new boolean[100];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                if(p == 1) home.add(new Integer[] {i, j});
                if(p == 2) chicken.add(new Integer[] {i, j});
            }
        }

        dfs(0, 0);
        System.out.println(min);

        br.close();
    }
}

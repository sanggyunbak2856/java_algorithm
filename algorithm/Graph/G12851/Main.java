package algorithm.Graph.G12851;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] visited = new int[100001];
    static int answer = 0;
    static int n;
    static int k;
    static int count = 0;
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {n, 0});

        while(!q.isEmpty()) {
            Integer[] v = q.poll();
            if(v[0] == k) {
                if(count == 0) answer = v[1];
                if(v[1] == answer) count++;
                continue;
            }

            int[] next_pos = {v[0] - 1, v[0] + 1, 2 * v[0]};
            for(int i = 0; i < 3; i++) {
                if(next_pos[i] < 0 || next_pos[i] > 100000) continue;
                if(visited[next_pos[i]] == 0 || visited[next_pos[i]] == v[1] + 1) {
                    visited[next_pos[i]] = v[1] + 1;
                    q.add(new Integer[] {next_pos[i], v[1] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(answer);
        System.out.println(count);
        br.close();
    }
    
}

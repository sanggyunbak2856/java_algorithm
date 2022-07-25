package algorithm.Graph.G1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int answer = 0;
    static int n;
    static int k;
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {n, 0});

        while(!q.isEmpty()) {
            Integer[] v = q.poll();
            if(v[0] == k) {
                answer = v[1];
                break;
            }

            int new_pos_0 = v[0] + 1;
            int new_pos_1 = v[0] - 1;
            int new_pos_2 = v[0] * 2;

            if(new_pos_0 < 100001) {
                if(!visited[new_pos_0]){
                    q.add(new Integer[] {new_pos_0, v[1] + 1});
                    visited[new_pos_0] = true;
                }
            }
            if(new_pos_1 > -1 && new_pos_1 < 100001) {
                if(!visited[new_pos_1]) {
                    q.add(new Integer[] {new_pos_1, v[1] + 1});
                    visited[new_pos_1] = true;
                }
            }
            if(new_pos_2 < 100001) {
                if(!visited[new_pos_2]) {
                    q.add(new Integer[] {new_pos_2, v[1] + 1});
                    visited[new_pos_2] = true;
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
        br.close();
    }
    
}

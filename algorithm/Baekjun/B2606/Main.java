package algorithm.Baekjun.B2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int bfs(ArrayList<ArrayList<Integer>> graph) {
        int cnt = 0;
        boolean[] visited = new boolean[graph.size() + 1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);

        while(!q.isEmpty()) {
            Integer p = q.poll();

            for(Integer a : graph.get(p)) {
                if(visited[a]) continue;
                q.add(a);
                cnt++;
                visited[a] = true;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < p; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int answer = bfs(graph);

        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

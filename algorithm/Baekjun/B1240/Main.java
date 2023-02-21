package algorithm.Baekjun.B1240;

import java.io.*;
import java.util.*;

public class Main {
    static int bfs(int from, int to, ArrayList<ArrayList<int[]>> tree) {
        Queue<int[]> q = new LinkedList<>();
        int distance = Integer.MAX_VALUE;
        ArrayList<int[]> adjacent = tree.get(from);
        boolean[] visited = new boolean[tree.size() + 1];
        for(int[] p : adjacent) {
            q.add(p);
            visited[p[0]] = true;
        }

        while(!q.isEmpty()) {
            int[] p = q.poll();
            if(p[0] == to) {
                distance = p[1];
                break;
            }

            ArrayList<int[]> list = tree.get(p[0]);
            for(int[] node : list) {
                if(visited[node[0]]) continue;
                visited[node[0]] = true;
                q.add(new int[] {node[0], node[1] + p[1]});
            }
        }
        
        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) { // 0 : dest, 1 : weight
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(from).add(new int[] {to, weight});
            tree.get(to).add(new int[] {from, weight});
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int distance = bfs(from, to, tree);
            bw.write(distance + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}

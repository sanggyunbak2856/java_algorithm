package algorithm.Baekjun.B5014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] dy;
    static boolean[] visited;
    static boolean canReach = false;
    static void bfs(int f, int s, int g, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int p = q.poll();
            visited[p] = true;
            if(p == g) {
                canReach = true;
                min = 0;
                break;
            }

            for(int i = 0; i < 2; i++) {
                int newPosition = p + dy[i];
                if(newPosition < 1 || newPosition > f) continue;
                if(visited[newPosition]) continue;
                arr[newPosition] = arr[p] + 1;
                if(newPosition == g) {
                    min = arr[newPosition] < min ? arr[newPosition] : min;
                    canReach = true;
                    continue;
                }
                q.add(newPosition);
                visited[newPosition] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        dy =  new int[] {u, (-1) * d};
        visited = new boolean[f + 1];
        int[] arr = new int[f + 1];
        bfs(f, s, g, arr);
        if(canReach) bw.write(min + "\n");
        else bw.write("use the stairs \n");
        bw.flush();

        br.close();
        bw.close();
    }
}

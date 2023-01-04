package algorithm.Greedy.G16953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static long a;
    static long b;
    static int count = 1;
    static void bfs() {
        Queue<Long> q = new LinkedList<>();
        q.add(a);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Long p = q.poll();
                if(p == b) return;
                if(p * 2 <= b) q.add(p * 2);
                if(p * 10 + 1 <= b) q.add(p * 10 + 1);
            }
            count += 1;
        }

        count = -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        bfs();

        bw.write(count + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

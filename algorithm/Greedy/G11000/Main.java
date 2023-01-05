package algorithm.Greedy.G11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        );

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            pq.add(new Integer[] {from, to});
        }

        PriorityQueue<Integer[]> pq2 = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        );

        int count = 1;
        Integer[] p = pq.poll();
        pq2.add(p);


        br.close();
        bw.close();
    }
}

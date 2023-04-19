package algorithm.swexpert.S12741;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 1; i <= test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Integer[] first = new Integer[] {a, b};
            Integer[] second = new Integer[] {c, d};

            PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1[0] - o2[0];
                }
            );
            pq.add(first); pq.add(second);

            Integer[] p = pq.poll();
            Integer[] p2 = pq.poll();

            int answer = 0;
            if(p2[0] >= p[1]) answer = 0;
            else {
                if(p2[1] >= p[1]) answer = p[1] - p2[0];
                else answer = p2[1] = p2[0];
            }
            bw.write("#" + i + " " + answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

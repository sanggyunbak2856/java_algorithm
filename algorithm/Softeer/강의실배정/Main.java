package algorithm.Softeer.강의실배정;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        );
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Integer[] {start, end});
        }

        int count = 1;
        Integer[] first = pq.poll();
        int start = first[0];
        int end = first[1];
        while(!pq.isEmpty()) {
            Integer[] p = pq.poll();
            if(p[0] >= end) {
                start = p[0];
                end = p[1];
                count+=1;
                continue;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

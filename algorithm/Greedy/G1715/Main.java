package algorithm.Greedy.G1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            pq.add(num);
        }

        long count = 0;
        while(pq.size() > 1) {
            long p1 = pq.poll();
            long p2 = pq.poll();
            count += (p1 + p2);
            pq.add(p1 + p2);
        }

        System.out.println(count);

        br.close();
    }
}

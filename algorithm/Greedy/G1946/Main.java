package algorithm.Greedy.G1946;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                pq.add(new Integer[] {paper, interview});
            }

            int count = 0;
            int max = Integer.MAX_VALUE;
            while(!pq.isEmpty()) {
                Integer[] p = pq.poll();
                if(p[1] < max) {
                    max = p[1];
                    count++;
                }
            }

            System.out.println(count);
        }

        br.close();
    }
}

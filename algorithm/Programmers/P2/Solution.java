package algorithm.Programmers.P2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        List<Integer> target = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(true) {
            if(pq.size() == 1) break;
            int x = pq.poll();
            int y = pq.poll();
            target.add(x + y);
            pq.add(x + y);
        }

        int sum = 0;
        for(int i : target) {
            sum += i;
        }
        

        if(n == 1) bw.write(pq.poll() + "\n");
        else bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

package algorithm.Softeer.금고털이;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int weight = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (o1, o2) -> o2[1] - o1[1]
        );
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.add(new Integer[] {w, p});
        }

        int sum = 0;
        int currentWeight = 0;
        while(true) {
            Integer[] p = pq.poll();
            int left = weight - currentWeight;
            if(p[0] < left) {
                currentWeight += p[0];
                sum += (p[0] * p[1]);
            }
            else {
                currentWeight += left;
                sum += (left * p[1]);
            }
            if(currentWeight >= weight) break;
        }
        bw.write(sum + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

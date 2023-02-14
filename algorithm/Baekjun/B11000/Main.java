package algorithm.Baekjun.B11000;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0]; 
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1]
        );

        pq.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(pq.peek()[1] <= arr[i][0]) pq.poll();
            pq.add(arr[i]);
        }
        bw.write(pq.size() + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

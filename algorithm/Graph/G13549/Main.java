package algorithm.Graph.G13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] time = new int[100001];
    static void dijkstra(int start) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        time[start] = 0;
        pq.add(new Integer[] {start, 0});

        while(!pq.isEmpty()) {
            Integer[] v = pq.poll();
            int current_location = v[0];
            int current_time = v[1];

            if(current_location - 1 >= 0) {
                if(time[current_location - 1] > current_time + 1) {
                    time[current_location - 1] = current_time + 1;
                    pq.add(new Integer[] {current_location - 1, current_time + 1});
                }
            }
            if(current_location + 1 < 100001) {
                if(time[current_location + 1] > current_time + 1) {
                    time[current_location + 1] = current_time + 1;
                    pq.add(new Integer[] {current_location + 1, current_time + 1});
                }
            }
            if(2 * current_location < 100001) {
                if(time[2 * current_location] > current_time) {
                    time[2 * current_location] = current_time;
                    pq.add(new Integer[] {2 * current_location, current_time});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(time, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dijkstra(n);
        System.out.println(time[k]);
        br.close();
    }
}

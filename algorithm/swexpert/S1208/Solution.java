package algorithm.swexpert.S1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.Collections; 
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) {
                int x = Integer.parseInt(st.nextToken());
                maxHeap.add(x);
                minHeap.add(x);
            }

            for(int i = 0; i < n; i++) {
                int max = maxHeap.poll();
                maxHeap.add(max - 1);
                int min = minHeap.poll();
                minHeap.add(min + 1);
            }

            int maxValue = maxHeap.poll();
            int minValue = minHeap.poll();

            System.out.printf("#%d %d\n", test_case, maxValue - minValue);
        }
        br.close();
    }
}

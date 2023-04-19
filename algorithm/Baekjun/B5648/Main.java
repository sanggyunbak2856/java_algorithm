package algorithm.Baekjun.B5648;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
            count++;
        }

        if(count < n) {
            while(true) {
                if(count >= n) break;
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                    count++;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : list) {
            int number = Integer.parseInt((new StringBuilder(String.valueOf(i))).reverse().toString());
            pq.add(number);
        }
 
        while(!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

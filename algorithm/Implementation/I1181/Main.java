package algorithm.Implementation.I1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<String> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        );

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        list.add(pq.poll());
        bw.write(list.get(0) + "\n");
        while(!pq.isEmpty()) {
            String s = pq.poll();
            if(list.get(list.size() - 1).equals(s)) continue;
            else {
                bw.write(s + "\n");
                list.add(s);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

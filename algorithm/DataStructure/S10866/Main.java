package week2.sangGyun.S10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static Deque<Integer> dq = new LinkedList<>();
    static void parse(String[] str, BufferedWriter bw) throws IOException {
        if(str[0].equals("push_front")) dq.addFirst(Integer.parseInt(str[1]));
        if(str[0].equals("push_back")) dq.addLast(Integer.parseInt(str[1]));
        if(str[0].equals("pop_front")) {
            if(dq.isEmpty()) bw.write(-1 + "\n");
            else bw.write(dq.pollFirst() + "\n");
        }
        if(str[0].equals("pop_back")) {
            if(dq.isEmpty()) bw.write(-1 + "\n");
            else bw.write(dq.pollLast() + "\n");
        }
        if(str[0].equals("size")) bw.write(dq.size() + "\n");
        if(str[0].equals("empty")) {
            if(dq.isEmpty()) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }
        if(str[0].equals("front")) {
            if(dq.isEmpty()) bw.write(-1 + "\n");
            else bw.write(dq.peekFirst() + "\n");
        }
        if(str[0].equals("back")) {
            if(dq.isEmpty()) bw.write(-1 + "\n");
            else bw.write(dq.peekLast() + "\n");
        }
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            parse(str, bw);
        }

        bw.close();
        br.close();
    }
}

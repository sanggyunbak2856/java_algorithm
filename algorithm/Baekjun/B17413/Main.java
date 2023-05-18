package algorithm.Baekjun.B17413;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static void reverseWord(Deque<Character> dq, StringBuilder sb) {
        while(!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new LinkedList<>();
        boolean tag = false;
        for(int i = 0; i < charArr.length; i++) {
            if(tag) {
                sb.append(charArr[i]);
                if(charArr[i] == '>') tag = false;
            }
            else {
                if(charArr[i] == '<') {
                    reverseWord(dq, sb);
                    tag = true;
                    sb.append(charArr[i]);
                }
                else {
                    if(charArr[i] == ' ') {
                        reverseWord(dq, sb);
                        sb.append(charArr[i]);
                    }
                    else {
                        dq.add(charArr[i]);
                    }
                }
            }
        }
        if(!dq.isEmpty()) reverseWord(dq, sb);

        bw.write(sb.toString() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

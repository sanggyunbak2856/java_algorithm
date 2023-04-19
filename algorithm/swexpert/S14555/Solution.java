package algorithm.swexpert.S14555;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t++) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();
            int count = 0;

            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == '.') continue;
                if(chars[i] == '(') st.push('(');
                if(chars[i] == '|') {
                    if(!st.isEmpty() && (st.peek() == '(')) {
                        st.pop();
                        count++;
                    }
                }
                if(chars[i] == ')') {
                    if(!st.isEmpty() && (st.peek() == '(')) {
                        st.pop();
                    }
                    count++;
                }
            }

            bw.write("#" + t + " " + count + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}

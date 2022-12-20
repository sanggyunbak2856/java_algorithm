package algorithm.swacademy.p2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    static boolean popStack(Stack<Character> st, char ch) {
        if(st.isEmpty()) return false;

        char p = st.pop();
        if(ch == ')' && p == '(') return true;
        else if(ch == ']' && p == '[') return true;
        else if(ch == '}' && p == '{') return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();
            boolean isPass = true;

            for(int j = 0; j < str.length; j++) {
                char ch = str[j];
                if(ch == '{' || ch == '[' || ch == '(') st.push(ch);
                else {
                    if(popStack(st, ch)) continue;
                    else {
                        isPass = false;
                        break;
                    }
                }
            }
            if(!st.isEmpty()) isPass = false;
            if(isPass) System.out.println("YES");
            else System.out.println("NO");
        }

        br.close();
    }
}

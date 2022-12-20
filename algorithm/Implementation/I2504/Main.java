package algorithm.Implementation.I2504;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> parenthesis = new Stack<>();
        Stack<Integer> values = new Stack<>();
        
        String str = br.readLine();
        String[] elements = str.split("");
        int answer = 0;
        for(String s : elements) {
            if(s.equals("(") || s.equals("[")) {
                parenthesis.push(s);
                continue;
            }
            if(parenthesis.isEmpty()) break;

            String p = parenthesis.pop();
            if((p.equals("(") && s.equals("]")) || (p.equals("[") && s.equals(")"))) break;

            int mult = s.equals(")") ? 2 : 3;
            if(parenthesis.isEmpty()) {
                if(values.isEmpty()) {
                    answer += mult;
                }
                else {
                    int sum = 0;
                    while(!values.isEmpty()) {
                        sum += values.pop() * mult;
                    }
                    answer += sum;
                }
            }
            else {
                if(values.isEmpty()) values.push(mult);
                else {
                    int sum = mult;
                    while(!values.isEmpty()) {
                        sum += values.pop();
                    }
                    values.push(sum);
                }
            }

        }
        System.out.println(answer);
        br.close();
    }
}

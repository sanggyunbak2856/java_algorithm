package algorithm.DataStructure.D4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static boolean isBalancedString(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[') stack.push(ch);
            else if(ch == ')') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
            else if(ch == ']') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
            else continue;
        }

        if(!stack.isEmpty()) return false;
        
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            if(isBalancedString(str)) System.out.println("Yes");
            else System.out.println("No");
        }
        br.close();
    }
}

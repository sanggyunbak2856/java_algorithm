package algorithm.Baekjun.B9019;

import java.util.*;
import java.io.*;

public class Main {
    static String[] operands = {"D", "S", "L", "R"};
    static boolean[] visited;
    static int operate(String command, int num) {
        if(command.equals("D")) {
            return (num * 2) % 10000;
        }
        else if(command.equals("S")) {
            if(num - 1 < 0) return 9999;
            else return num - 1;
        }
        else if(command.equals("L")) {
            int mostLeft = num / 1000;
            num = (num * 10) % 10000;
            num += mostLeft;
            return num;
        }
        else { // "R"
            int mostRight = num % 10;
            num /= 10;
            num += (mostRight * 1000);
            return num;
        }
    }
    static StringBuilder bfs(int from, int to) {
        Queue<Register> q = new LinkedList<>();
        q.add(new Register(from, new StringBuilder()));
        visited[from] = true;
        StringBuilder answer = new StringBuilder();

        while(!q.isEmpty()) {
            Register p = q.poll();
            if(p.number == to) {
                answer = p.commands;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int newNum = operate(operands[i], p.number);
                if(visited[newNum]) continue;
                q.add(new Register(newNum, (new StringBuilder(p.commands)).append(operands[i])));
                visited[newNum] = true;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        visited = new boolean[10001];
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            answer.append(bfs(from, to)).append("\n");
            visited = new boolean[10001];
        }

        bw.write(answer.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static class Register {
        public int number;
        public StringBuilder commands;
        public Register(int number, StringBuilder sb) {
            this.number = number;
            this.commands = sb;
        }
    }
}

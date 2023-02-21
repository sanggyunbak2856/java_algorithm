package algorithm.Baekjun.B17265;

import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int calc(char[] equation) {
        int answer = ((int) equation[0]) - 48;
        for(int i = 2; i < equation.length; i += 2) {
            char operand = equation[i - 1];
            int num = ((int) equation[i]) - 48;
            if(operand == '*') {
                answer *= num;
            }
            else if(operand == '+' ) {
                answer += num;
            }
            else if(operand == '-') {
                answer -= num;
            }
        }

        return answer;
    }
    static void dfs(char[][] map, int y, int x, int n, int depth, char[] equation) {
        if(depth == 2 * n - 1) {
            int answer = calc(equation);
            max = answer > max ? answer : max;
            min = answer < min ? answer : min;
            return;
        }

        for(int i = 0; i < 2; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
            equation[depth] = map[newY][newX];
            dfs(map, newY, newX, n, depth + 1, equation);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) { // 48
            map[i] = br.readLine().replace(" ", "").toCharArray();
        }

        char[] equation = new char[2 * n - 1];
        equation[0] = map[0][0];
        dfs(map, 0, 0, n, 1, equation);
        bw.write(max + " " + min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

package algorithm.Greedy.G1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static char[] alphabet;
    static char[] tmp;
    static String answer;
    static boolean[] visited;
    static boolean isPalindrome() {
        int mid = tmp.length / 2;
        for(int i = 0; i < mid; i++) {
            if(tmp[i] != tmp[tmp.length - 1 - i]) return false;
        }
        return true;
    }
    static void dfs(int depth) {
        if(depth == alphabet.length) {
            // 비교
            if(isPalindrome()) {
                String tmpString = new String(tmp);
                if(tmpString.compareTo(answer) <= 0) answer = tmpString;
            }
            return;
        }

        for(int i = 0; i < alphabet.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            tmp[depth] = alphabet[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = br.readLine();
        alphabet = answer.toCharArray();
        tmp = new char[alphabet.length];
        visited = new boolean[tmp.length];

        dfs(0);
        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

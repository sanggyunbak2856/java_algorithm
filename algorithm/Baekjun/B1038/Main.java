package algorithm.Baekjun.B1038;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static void dfs(int digits, int start, int depth, long currentNum, ArrayList<Long> arr) { // i : 자릿수, j : 시작 숫자
        if(depth == digits) {
            arr.add(currentNum);
            return;
        }

        for(int i = 0; i <= start - 1; i++) {
            dfs(digits, i, depth + 1, currentNum * 10 + i, arr);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 10; i++) { // 자리수
            for(int j = i - 1; j <= 9; j++) {
                dfs(i, j, 1, j, arr);
            }
        }

        if(n > 1022) bw.write("-1\n");
        else bw.write(arr.get(n) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

package algorithm.Baekjun.B1174;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> list = new ArrayList<>();
    static void dfs(int depth, int digits, int prev, StringBuilder sb) {
        if(depth == digits) {
            list.add(sb.toString());
            return;
        }

        for(int i = 0; i < prev; i++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(i);
            dfs(depth + 1, digits, i, newSb);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < 10; i++) {
            list.add(new String(i + ""));
        }

        for(int i = 2; i <= 10; i++) {
            for(int j = i - 1; j < 10; j++) {
                dfs(1, i, j, new StringBuilder(j + ""));
            }
        }

        if(n > list.size()) bw.write("-1\n");
        else bw.write(list.get(n - 1) + "\n");
        bw.flush();

        br.close();
        bw.close();

    }
}

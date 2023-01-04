package algorithm.Programmers.P63631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curStd = Integer.parseInt(st.nextToken());
            List<Integer> list = new LinkedList<>();
            list.add(curStd);
            for(int j = 1; j < n; j++) {
                int m = Integer.parseInt(st.nextToken());
                if(m >= curStd) {
                    curStd = m;
                    list.add(curStd);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++) {
                sb.append(list.get(j)).append(" ");
            }
            System.out.println(sb);
        }

        br.close();
    }
}

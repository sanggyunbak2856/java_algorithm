package algorithm.Baekjun.B19942;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int mp, mf, ms, mv;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    static List<Integer> answerList = new LinkedList<>();
    static int count = 0;
    static boolean isSatisfied(int smp, int smf, int sms, int smv) {
        return (smp >= mp) && (smf >= mf) && (sms >= ms) && (smv >= mv);
    }
    static void dfs(int depth, int smp, int smf, int sms, int smv, int price, List<Integer> list) {
        count++;
        if(price >= min) {
            return;
        }
        if(isSatisfied(smp, smf, sms, smv)) {
            answerList = new LinkedList<>();
            if(price < min) {
                min = price;
                for(Integer p : list) {
                    answerList.add(p);
                }
            }
            return;
        }

        for(int i = depth; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            list.add(Integer.valueOf(i));
            List<Integer> newList = new LinkedList<>();
            for(int j : list) {
                newList.add(j);
            }
            dfs(i + 1, smp + arr[i][0], smf + arr[i][1], sms + arr[i][2], smv + arr[i][3], price + arr[i][4], newList);
            list.remove(Integer.valueOf(i));
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        arr = new int[n][5];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
            arr[i][4] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0, 0, 0, new LinkedList<>());
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else {
            bw.write(min + "\n");
            for(Integer p : answerList) {
                bw.write((p + 1) + " ");
            }
        }
        bw.write("\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

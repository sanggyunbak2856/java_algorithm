package algorithm.Baekjun.B1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int dest;
    static int upDownOnly;
    static int min = Integer.MAX_VALUE;
    static List<Integer> brokenNums = new ArrayList<>();
    static void dfs(int destDepth, int currentDepth, int currentValue) {
        if(currentDepth == destDepth) {
            int diff = Math.abs(currentValue - dest) + currentDepth;
            min = diff < min ? diff : min;
            return;
        }


        for(int i = 0; i < 10; i++) {
            if(brokenNums.contains(i)) continue;
            int newValue = currentValue * 10 + i;
            dfs(destDepth, currentDepth + 1, newValue);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dest = Integer.parseInt(br.readLine());
        
        int brokenNum = Integer.parseInt(br.readLine());
        brokenNums = new ArrayList<>();
        if(brokenNum > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < brokenNum; i++) {
                brokenNums.add(Integer.parseInt(st.nextToken()));
            }
        }

        upDownOnly = Math.abs(dest - 100);
        if(upDownOnly == 0) {
            bw.write(0 + "\n");
        }
        else {
            for(int j = 1; j <= 6; j++) {
                dfs(j, 0, 0);
                int vmin = min;
            }
            min = upDownOnly < min ? upDownOnly : min;
            bw.write(min + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

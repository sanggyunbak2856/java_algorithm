package algorithm.Baekjun.B1072;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int)((long)y * 100 / x);

        int left = 0;
        int right = 1000000000;
        int answer = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int newPercent = (int)((long)(y + mid) * 100 / (x + mid));
            if(newPercent == z) {
                left = mid + 1;
            }
            else {
                answer = mid;
                right = mid - 1;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

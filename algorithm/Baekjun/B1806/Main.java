package algorithm.Baekjun.B1806;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] prefix = new long[n + 1];
        for(int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        int min = 10001;
        int left = 0; // index
        int right = 0; // index
        // prefix[right] - prefix[left] < s -> right++
        // prefix[right] - prefix[left] >= s -> min 갱신, left++
        // right == left -> right++
        while(true) {
            if(right >= prefix.length) break;

            long diff = prefix[right] - prefix[left];
            int length = right - left;

            if(right == left) {
                right++;
                continue;
            }
            if(diff >= s) {
                min = length < min ? length : min;
                left++;
                continue;
            }
            else {
                right++;
                continue;
            }
        }

        if(min == 10001) bw.write("0\n");
        else bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

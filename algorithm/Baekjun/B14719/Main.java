package algorithm.Baekjun.B14719;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] world = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 1; i < w - 1; i++) {
            int left = 0, right = 0; // 왼, 오른쪽 

            for(int j = 0; j < i; j++) {
                if(left < world[j]) left = world[j];
            }

            for(int j = i; j < w; j++) {
                if(right < world[j]) right = world[j];
            }

            if(left <= world[i] || right <= world[i]) continue;
            else {
                int smaller = left < right ? left : right;
                count += (smaller - world[i]);
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

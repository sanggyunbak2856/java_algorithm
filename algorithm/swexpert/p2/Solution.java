package algorithm.swexpert.p2;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean canEatAllApple(int[] arr, int p) {
        boolean possible = true;
        int idx = p;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 2) arr[i] = 1;
        }
        while(true) {
            int minDist = Integer.MAX_VALUE;
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] == 1) {
                    minDist = Math.abs(idx - i) < minDist ? Math.abs(idx - i) : minDist;
                }
            }

            if(minDist == Integer.MAX_VALUE) break;

            int left = idx - minDist;
            int right = idx + minDist;

            if(left > 0 && right < arr.length) {
                if(arr[left] == 1 && arr[right] == 1) return false;
            }

            if(left > 0 && arr[left] == 1) {
                idx = left;
                arr[left] = 2;
                continue;
            }

            if(right < arr.length && arr[right] == 1) {
                idx = right;
                arr[right] = 2;
                continue;
            }
        }

        return possible;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            if(x - i > 0 && canEatAllApple(arr, x - i)) {
                bw.write(x - i + "\n");
                bw.flush();
                break;
            }
            if(x + i <= n && canEatAllApple(arr, x + i)) {
                bw.write(x + i + "\n");
                bw.flush();
                break;
            }
        }

        br.close();
        bw.close();
    }
}

package algorithm.Baekjun.B2467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = Math.abs(arr[0] + arr[arr.length - 1]);
        int left = 0;
        int right = arr.length - 1;
        int answerLeft = left; int answerRight = right;
        while(left < right) {
            long newSum = arr[left] + arr[right];
            if(Math.abs(newSum) < sum) {
                sum = Math.abs(newSum);
                answerLeft = left;
                answerRight = right;
            }
            if(newSum >= 0) right--;
            else left++;
        }

        bw.write(arr[answerLeft] + " " + arr[answerRight] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

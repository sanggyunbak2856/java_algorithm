package algorithm.Programmers.P3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        int[] plus = new int[n];
        int[] minus = new int[n];

        for(int i = 0; i < n; i++) {
            if(i % 2 == 1) {
                plus[i] = arr1[i];
                minus[i] = arr1[i];
            }
            else {
                plus[i] = arr1[i] + arr2[i];
                minus[i] = arr1[i] - arr2[i];
            }
        }

        for(int i = 0; i < n - 1; i+=2) {
            if(plus[i] == 0) continue;
            bw.write(plus[i] + " " + plus[i + 1] + " ");
        }
        bw.write("\n");
        for(int i = 0; i < n - 1; i+=2) {
            if(minus[i] == 0) continue;
            bw.write(minus[i] + " " + minus[i + 1] + " ");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

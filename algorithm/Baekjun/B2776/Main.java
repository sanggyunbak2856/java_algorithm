package algorithm.Baekjun.B2776;

import java.util.*;
import java.io.*;

public class Main {
    static boolean isExist(int[] arr1, int k) {
        int start = 0;
        int end = arr1.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(k == arr1[mid]) return true;
            if(arr1[mid] < k) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr1 = new int[n];
            for(int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);

            int m = Integer.parseInt(br.readLine());
            sb = new StringBuffer();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                if(isExist(arr1, k)) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

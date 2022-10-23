package algorithm.Backtracking.B1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int count = 0;
    static void backtracking(int sum, int idx) {
        if(idx == n) {
            if (sum == m) count++;
            return;
        }
        backtracking(sum + arr[idx], idx + 1);
        backtracking(sum, idx + 1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        if (m == 0) System.out.println(count - 1);
        else System.out.println(count);

        br.close();
    }
}

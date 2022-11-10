package algorithm.Greedy.G9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean isPossible(int depth) {
        for(int i = 0; i < depth; i++) {
            if(arr[depth] == arr[i]) {
                return false;
            }

            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }

        return true;
    }
    static void dfs(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[depth] = i; // col

            if(isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        
        System.out.println(count);

        br.close();
    }
}

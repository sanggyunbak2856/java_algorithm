package algorithm.Backtracking.B15650;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static void backtracking(int depth) {
        if (depth == m) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            if(depth == 0) {
                arr[depth] = i + 1;
                backtracking(depth + 1);
            }
            else if((i + 1) > arr[depth - 1]) {
                arr[depth] = i + 1;
                backtracking(depth + 1);
            }
            visited[i] = false;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n =  Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];

        backtracking(0);
        
        br.close();
    }
}

package algorithm.Backtracking.B15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder("");
    static int n;
    static int m;
    static int[] arr;
    static void backtracking(int depth, int[] element) {
        if (depth == m) {
            for(int x : element) {
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if (depth == 0) {
                element[0] = i + 1;
            }
            else if (element[depth - 1]  > i + 1) continue;

            element[depth] = i + 1;
            int[] newElement = Arrays.copyOf(element, element.length);
            backtracking(depth + 1, newElement);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = IntStream.range(1, n + 1).toArray();
        int[] element = new int[m];

        backtracking(0, element);

        System.out.println(sb);

        br.close();
    }
}

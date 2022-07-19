package algorithm.Greedy.G1026;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        String[] str1 = br.readLine().split(" ");
        IntStream.range(0, n).forEach(idx -> a[idx] = Integer.parseInt(str1[idx]));
        String[] str2 = br.readLine().split(" ");
        IntStream.range(0, n).forEach(idx -> b[idx] = Integer.parseInt(str2[idx]));

        Arrays.sort(a);

        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(o1 -> -o1[1]));
        for(int i = 0; i < n; i++) {
            p.add(new int[] {i, b[i]});
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int[] q = p.poll();
            sum += b[q[0]] * a[i];
        }
        System.out.println(sum);
        br.close();
    }
}

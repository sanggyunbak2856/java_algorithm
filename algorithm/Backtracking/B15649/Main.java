package algorithm.Backtracking.B15649;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static List<int[]> list = new ArrayList<>();
    static void backtracking(int[] arr, int[] element, int count) {
        if(count == 0) {
            list.add(element);
            return;
        }

        for(int x : arr) {
            int[] newArr = Arrays.stream(arr).filter(i -> i != x).toArray();
            int[] newElement = Arrays.copyOf(element, element.length);
            newElement[element.length - count] = x;
            backtracking(newArr, newElement, count - 1);
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = IntStream.range(1, n + 1).toArray();
        int[] element = new int[m];

        backtracking(arr, element, m);

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}

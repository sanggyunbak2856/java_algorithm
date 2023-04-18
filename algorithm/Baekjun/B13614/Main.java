package algorithm.Baekjun.B13614;

import java.util.*;
import java.io.*;

public class Main {
    static int makeShirts(int[] arr, int k) {
        int answer = 0;
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++) {
            diff.add(arr[i + 1] - arr[i]);
        }
        Collections.sort(diff);
        for(int i = 0; i < arr.length - k; i++) {
            answer += diff.get(i);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = makeShirts(arr, k);
        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
    
}

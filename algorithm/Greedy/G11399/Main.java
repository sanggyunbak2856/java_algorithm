package algorithm.Greedy.G11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            count += arr[i];
        }
        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

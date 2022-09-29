package algorithm.Greedy.G25644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        int min_loc = 0;
        int curr_min = min_loc;
        int max_loc = n - 1;
        int curr_max = max_loc;
        for(int i = 0; i < n; i++) {
            if(min > arr[curr_min] && curr_min < max_loc) {
                min = arr[curr_min];
                min_loc = curr_min;
            }

            if(max < arr[curr_max] && curr_max > min_loc) {
                max = arr[curr_max];
                max_loc = curr_max;
            }

            curr_min++;
            curr_max--;
        }

        
        int answer = max - min;
        
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

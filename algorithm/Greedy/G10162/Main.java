package algorithm.Greedy.G10162;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        if(t == 0) t = 1;
        int[] times = new int[] {300, 60, 10};
        int[] counts = new int[] {0, 0, 0};
        for(int i = 0; i < 3; i++) {
            if(t >= times[i]) {
                counts[i] += (t / times[i]);
                t = t % times[i];
            }
        }
        
        if(t != 0) System.out.println(-1);
        else System.out.println(counts[0] + " " + counts[1] + " " + counts[2]);
        br.close();
    }
}

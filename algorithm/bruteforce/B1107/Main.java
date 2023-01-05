package algorithm.bruteforce.B1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static int dest;
    static int src;
    static int[] brokenNumbers;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static void backtracking(int curDepth, int curChannel) {
        if(curChannel == dest) {
            min = curDepth < min ? curDepth : min;
        }

        if(curDepth == 0) {

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dest = Integer.parseInt(br.readLine());
        src = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        brokenNumbers = new int[nums.length];
        visited = new boolean[5000001];
        for(int i = 0; i < nums.length; i++) {
            brokenNumbers[i] = Integer.parseInt(nums[i]);
        }
        
        br.close();
        bw.close();
    }
}

package algorithm.DataStructure.D1655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        ArrayList<Integer> arr_list = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        
        

        bw.close();
        br.close();
    }
}

package algorithm.DataStructure.D1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            if(hashSet.contains(str)) {
                answer.add(str);
            }
        }

        answer.sort((o1, o2) -> {return o1.compareTo(o2);});
        System.out.println(answer.size());
        for(String s : answer) {
            System.out.println(s);
        }

        br.close();
    }
}

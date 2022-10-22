package algorithm.Backtracking.B1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int L;
    static int C;
    static StringBuilder sb = new StringBuilder("");
    static String[] arr;
    static boolean isVowel(String s) {
        return "aeiou".contains(s);
    }
    static void backtracking (int curDepth, String[] element, int curVowel, int curConstant) {
        if (curDepth == L) {
            if(curVowel < 1 || curConstant <  2) {
                return;
            }
            for(String s : element) {
                sb.append(s);
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < C; i++) {
            if(curDepth == 0) {
                element[0] = arr[i];
            }
            else if(element[curDepth - 1].compareTo(arr[i]) >= 0) {
                continue;
            }

            
            element[curDepth] = arr[i];
            String[] newElement = new String[element.length];
            System.arraycopy(element, 0, newElement, 0, element.length);
            if(isVowel(element[curDepth])) 
                backtracking(curDepth + 1, newElement, curVowel + 1, curConstant);
            else 
                backtracking(curDepth + 1, newElement, curVowel, curConstant + 1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");

        String[] element = new String[L];
        Arrays.sort(arr);

        backtracking(0, element, 0, 0);

        System.out.println(sb);

        br.close();
    }   
}

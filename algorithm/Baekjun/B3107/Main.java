package algorithm.Baekjun.B3107;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(":");
        
        if(strs.length == 0) {
            strs = new String[1];
            strs[0] = "";
        }
        else if(strs.length == 1){
            String temp = strs[0];
            strs = new String[2];
            strs[0] = temp;
            strs[1] = "";
        }
        else {
            String[] temp = new String[9];
            for(int i = 0; i < temp.length; i++) {
                if(i < strs.length) temp[i] = strs[i];
                else temp[i] = "";
            }
            if(strs.length < 9) temp[8] = "";
            strs = temp;
        }
        StringBuilder answer = new StringBuilder();
        int notBlankString = 0;
        for(int i = 0; i < strs.length; i++) {
            if(!strs[i].equals("")) notBlankString++;
        }

        boolean colonChanged = false;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < 4 && strs[i].length() > 0) {
                int zeros = 4 - strs[i].length();
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < zeros; j++) {
                    sb.append("0");
                }
                sb.append(strs[i]);
                answer.append(sb).append(":");
            }
            else if(strs[i].length() == 4) {
                answer.append(strs[i]).append(":");
            }
            else { // 0 -> ::
                if(colonChanged) continue;
                int blankString = 8 - notBlankString;
                for(int j = 0; j < blankString; j++) {
                    answer.append("0000").append(":");
                }
                colonChanged = true;
            }
        }

        answer.delete(answer.length() - 1, answer.length());
        answer.append("\n");
        bw.write(answer.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

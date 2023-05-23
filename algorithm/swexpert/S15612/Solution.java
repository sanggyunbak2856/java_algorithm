package algorithm.swexpert.S15612;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] strs) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            char[][] map = new char[8][8];
            List<Integer[]> rooks = new LinkedList<>();
            for(int j = 0; j < 8; j++) {
                char[] chars = br.readLine().toCharArray();
                for(int k = 0; k < 8; k++) {
                    map[j][k] = chars[k];
                    if(chars[k] == 'O') rooks.add(new Integer[] {j, k});
                }
            }

            if(rooks.size() != 8) {
                bw.write("#" + (i + 1) + " no\n");
                bw.flush();
                continue;
            }

            boolean possible = true;
            for(Integer[] rook : rooks) {
                for(int j = 0; j < 8; j++) {
                    if(map[rook[0]][j] == 'O' && j != rook[1]) {
                        possible = false;
                        break;
                    }
                    if(map[j][rook[1]] == 'O' && j != rook[0]) {
                        possible = false;
                        break;
                    }
                }
                if(!possible) break;
            }
            if(possible) bw.write("#" + (i + 1) + " yes\n");
            else bw.write("#" + (i + 1) + " no\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}

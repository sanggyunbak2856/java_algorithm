package algorithm.Programmers.P64522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static boolean isJunsikWin(int atk_j, int hp_j, int atk_m, int hp_m) {
        while(true) {
            hp_m -= atk_j;
            if(hp_m < 0) return true;
            hp_j -= atk_m;
            if(hp_j < 0) return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String world = br.readLine();
            int position = world.indexOf("@");
            st = new StringTokenizer(br.readLine());
            int atk_j = Integer.parseInt(st.nextToken());
            int hp_j = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int atk_m = Integer.parseInt(st.nextToken());
            int hp_m = Integer.parseInt(st.nextToken());
            // 입력 끝

            boolean canEscape = false;
            int count = 0;
            for(int j = position; j >= 0; j--) {
                char s = world.charAt(j);
                if(s == '#') count+=1;
                if(s == 'O') {
                    canEscape = true;
                    break;
                }
                if(s == '&') {
                    if(isJunsikWin(atk_j, hp_j, atk_m, hp_m)) {
                        canEscape = true;
                    }
                    else break;
                }
            }

            if(canEscape && count <= m) {
                bw.write("HAHA!\n");
                bw.flush();
                continue;
            }
            
            canEscape = false;
            count = 0;
            for(int j = position; j < n; j++) {
                char s = world.charAt(j);
                if(s == '#') count+=1;
                if(s == 'O') {
                    canEscape = true;
                    break;
                }
                if(s == '&') {
                    if(isJunsikWin(atk_j, hp_j, atk_m, hp_m)) {
                        canEscape = true;
                    }
                    else break;
                }
            }

            if(canEscape && count <= m) {
                bw.write("HAHA!\n");
                bw.flush();
                continue;
            }
            else {
                bw.write("HELP!\n");
                bw.flush();
                continue;
            }

        }

        br.close();
        bw.close();
    }
}

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
            if(hp_m <= 0) return true;
            hp_j -= atk_m;
            if(hp_j <= 0) return false;
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
            int idx_j = world.indexOf("@");
            char[] chars = world.toCharArray();
            st = new StringTokenizer(br.readLine());
            int atk_j = Integer.parseInt(st.nextToken());
            int hp_j = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int atk_m = Integer.parseInt(st.nextToken());
            int hp_m = Integer.parseInt(st.nextToken());
            // 입력 끝

            boolean start = false;
            boolean canEscape = false;
            int cnt = 0;
            for(int j = 0; j <= idx_j; j++) {
                if(!start && (chars[j] == 'O' || chars[j] == '@')) {
                    start = true;
                    continue;
                }
                if(start && chars[j] == '#') cnt += 1;
                if(start && chars[j] == '&') {
                    if(isJunsikWin(atk_j, hp_j, atk_m, hp_m)) continue;
                    else break;
                }
                if(start && (chars[j] == 'O' || chars[j] == '@')) {
                    canEscape = true;
                    break;
                }
            }

            if(canEscape && cnt <= m) {
                bw.write("HAHA!\n");
                bw.flush();
                continue;
            }

            canEscape = false;
            start = false;
            cnt = 0;

            for(int j = idx_j; j < n; j++) {
                if(!start && (chars[j] == 'O' || chars[j] == '@')) {
                    start = true;
                    continue;
                }
                if(start && chars[j] == '#') cnt += 1;
                if(start && chars[j] == '&') {
                    if(isJunsikWin(atk_j, hp_j, atk_m, hp_m)) continue;
                    else break;
                }
                if(start && (chars[j] == 'O' || chars[j] == '@')) {
                    canEscape = true;
                    break;
                }
            }

            if(canEscape && cnt <= m) {
                bw.write("HAHA!\n");
                bw.flush();
                continue;
            }
            else {
                bw.write("HELP!\n");
                bw.flush();
            }

        }

        br.close();
        bw.close();
    }
}

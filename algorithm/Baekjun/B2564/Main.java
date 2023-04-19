package algorithm.Baekjun.B2564;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][] shops = new int[Integer.parseInt(br.readLine()) + 1][3]; // (y, x, d)

        for(int i = 0; i < shops.length; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            if(direction == 1 || direction == 2) {
                int posX = Integer.parseInt(st.nextToken());
                if(direction == 1) {
                    shops[i][0] = 0; shops[i][1] = posX; shops[i][2] = 1;
                }
                else { // 2
                    shops[i][0] = height; shops[i][1] = posX; shops[i][2] = 2;
                }
            }
            else { // 3, 4
                int posY = Integer.parseInt(st.nextToken());
                if(direction == 3) {
                    shops[i][0] = posY; shops[i][1] = 0; shops[i][2] = 3;
                }
                else { // 4
                    shops[i][0] = posY; shops[i][1] = width; shops[i][2] = 4;
                }
            }
        }

        int totalLength = 2 * width + 2 * height;
        int sum = 0;
        int dgY = shops[shops.length - 1][0];
        int dgX = shops[shops.length - 1][1];
        int dgd = shops[shops.length - 1][2];
        for(int i = 0; i < shops.length - 1; i++) {
            if((dgd == 1 && shops[i][2] == 2) || (dgd == 2 && shops[i][2] == 1)) {
                int left = 0;
                if(dgX <= shops[i][1]) {
                    left += 2 * dgX;
                    left += Math.abs(dgY - shops[i][0]) + Math.abs(dgX - shops[i][1]);
                }
                else {
                    left += dgX;
                    left += Math.abs(dgY - shops[i][0]) + shops[i][1];
                }
                int right = totalLength - left;
                int smaller = left < right ? left : right;
                sum += smaller;
                bw.write(i + " : " + smaller + "\n");
            }
            else if((dgd == 3 && shops[i][2] == 4) || (dgd == 4 && shops[i][2] == 3)) {
                int left = 0;
                if(dgY <= shops[i][0]) {
                    left += 2 * dgY;
                    left += Math.abs(dgY - shops[i][0]) + Math.abs(dgX - shops[i][1]);
                }
                else {
                    left += dgY;
                    left += shops[i][0] + Math.abs(dgX - shops[i][1]);
                }
                int right = totalLength - left;
                int smaller = left < right ? left : right;
                sum += smaller;
                // bw.write(i + " : " + smaller + "\n");
            }
            else {
                int left = Math.abs(dgY - shops[i][0]) + Math.abs(dgX - shops[i][1]);
                int right = totalLength - left;
                int smaller = left < right ? left : right;
                sum += smaller;
                // bw.write(i + " : " + smaller + "\n");
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

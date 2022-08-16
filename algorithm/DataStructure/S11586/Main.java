package week2.sangGyun.S11586;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;



public class Main {
    static char[][] map;
    static void print_1(BufferedWriter bw) throws IOException{ // 그대로 출력
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void print_2(BufferedWriter bw) throws IOException{ // 좌우 반전
        for(int i = 0; i < map.length; i++) {
            for(int j = map.length - 1; j >= 0; j--) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void print_3(BufferedWriter bw) throws IOException{ // 상하 반전
        for(int i = map.length - 1; i>= 0; i--) {
            for(int j = 0; j < map.length; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int m = Integer.parseInt(br.readLine());
        switch(m) {
            case 1:
                print_1(bw);
                break;
            case 2:
                print_2(bw);
                break;
            case 3:
                print_3(bw);
                break;
        }


        bw.close();
        br.close();
    }
}

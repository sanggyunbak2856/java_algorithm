package algorithm.swexpert.S14413;

import java.util.Scanner;

public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean checkNum(int y, int x, int num, int[][] map) { // # -> 1, . -> 2, ? -> 0
        if(num == 0) return true;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length) continue;
            if(map[newY][newX] == 0) continue;
            if(map[newY][newX] == num) return false;
        }
        return true;
    }
    static int checkAround(int y, int x, int[][] map) { // 주변의 값이 다 같은지 확인
        int[] arr = new int[4];
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length) continue;
            else {
                arr[i] = map[newY][newX];
            }
        }

        int answer = 1;
        int zeros = 0; int ones = 0; int twos = 0;
        for(int i = 0; i < 4; i++) {
            if(arr[i] == 0) zeros += 1;
            else if(arr[i] == 1) ones += 1;
            else if(arr[i] == 2) twos += 1;
        }

        if(zeros == 4) answer = 1;
        else if(ones == 0 && twos > 0) answer = 1;
        else if(twos == 0 && ones > 0) answer = 2;
        else if(ones != 0 && twos != 0) answer = -1;
        
        
        return answer;
    }
    static void draw(int[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][m];
            String[][] strings = new String[n][m];

            for(int i = 0; i < n; i++) {
                strings[i] = sc.next().split("");
            }

            boolean isMapInputPossible = true;
            for(int i = 0; i < n; i++) {
                String[] chars = strings[i];
                for(int j = 0; j < m; j++) {
                    int num;
                    if(chars[j].equals("#")) num = 1;
                    else if(chars[j].equals(".")) num = 2;
                    else num = 0;

                    if(!checkNum(i, j, num, map)) {
                        isMapInputPossible = false;
                        break;
                    }
                    else { // 입력 가능
                        map[i][j] = num;
                        if(num == 0) {
                            int newNum = checkAround(i, j, map);
                            if(newNum == -1) {
                                isMapInputPossible = false;
                                break;
                            }
                            map[i][j] = newNum;
                        }
                    }
                }
                if(isMapInputPossible == false) break;
            }
            
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ");
            if(isMapInputPossible) sb.append("possible");
            else sb.append("impossible");
            System.out.println(sb);
        }
    }
}

package algorithm.dp.I2775;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int l = 0; l < x; l++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호수

            int[][] apartment = new int[k+1][n+1];

            for(int i = 0; i < k + 1; i++) { // 층
                for(int j = 1; j < n + 1; j++) { // 호수
                    if(i == 0) apartment[0][j] = j;
                    else {
                        apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];
                    }
                }
            }
            System.out.println(apartment[k][n]);
        }
    }
}

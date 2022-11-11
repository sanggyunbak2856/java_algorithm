package algorithm.swexpert.S15612;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int countAll = 0;
            boolean isPossible = true;
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < 8; i++) {
                String[] chars = sc.next().split("");
                int countRow = 0;
                for(int j = 0; j < 8; j++) {
                    if(chars[j].equals("O")) {
                        countAll+=1;
                        countRow+=1;
                        if(set.contains(i)) {
                            isPossible = false;
                            break;
                        }
                        else {
                            set.add(i);
                        }
                    }
                    if(countRow > 1) {
                        isPossible = false;
                        break;
                    }
                }
                if(countAll > 8) isPossible = false;
                if(!isPossible) break;
            }
            if(countAll != 8) isPossible = false;
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ");
            if(isPossible) sb.append("yes");
            else sb.append("no");
            
            System.out.println(sb);
        }
    }
}

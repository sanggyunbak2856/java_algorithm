package algorithm.swexpert.S15612;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    static Set<Integer> rows;
    static Set<Integer> columns;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            rows = new HashSet<>();
            columns = new HashSet<>();
            int count = 0;
            boolean isPossible = true;
            for(int i = 0; i < 8; i++) {
                String[] lines = sc.next().split("");
                for(int j = 0; j < 8; j++) {
                    if(lines[j].equals("O")) {
                        if(rows.contains(i) || columns.contains(j)) {
                            isPossible = false;
                            break;
                        }
                        count+=1;
                        rows.add(i);
                        columns.add(j);
                    }
                }
                if(count > 8) break;
                if(!isPossible) break;
            }
            StringBuilder sb = new StringBuilder("#");
            if(count != 8 || !isPossible) {
                sb.append(test_case).append(" ").append("no");
                System.out.println(sb);
                continue;
            }
            else {
                sb.append(test_case).append(" ").append("yes");
                System.out.println(sb);
            }
        }
    }
}

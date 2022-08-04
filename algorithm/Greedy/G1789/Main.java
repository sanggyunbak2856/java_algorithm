package algorithm.Greedy.G1789;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = (long) sc.nextInt();
        long count = 1;
        long remainder = n;
        while (remainder > count) {
            remainder -= count;
            count++;
        }
        System.out.println(count - 1);
    }
}

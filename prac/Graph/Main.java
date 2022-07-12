package prac.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrGraph = new ArrayList<ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertex 개수를 입력하세요.");
        int vertex = sc.nextInt();
        Graph graph = new Graph(arrGraph, vertex);

        while(true) {
            System.out.println("[1] edge 입력");
            System.out.println("[2] 출력");
            int n = sc.nextInt();
            if(n == 2) {
                graph.draw();
                break;
            }
            else if(n == 1) {
                int from, to;
                System.out.println("from, to");
                from = sc.nextInt();
                to = sc.nextInt();
                graph.add(from, to);
            }
            else {
                System.out.println("잘못 입력함");
            }
        }


    }
}

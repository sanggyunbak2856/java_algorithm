package algorithm.Baekjun.B3584;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int nodeNum = Integer.parseInt(br.readLine());
            ArrayList<Node> tree = new ArrayList<>(); // 0번 노드는 안씀
            boolean[] visited = new boolean[nodeNum + 1];
            for(int j = 0; j < nodeNum + 1; j++) {
                tree.add(new Node(j, null));
            }

            for(int j = 0; j < nodeNum - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                tree.get(parent).children.add(tree.get(child)); // 부모 -> 자식 연결
                tree.get(child).parent = tree.get(parent); // 자식 -> 부모 연결
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int commonAncestor = 0;

            Node nodeA = tree.get(a);
            while(nodeA != null) {
                visited[nodeA.value] = true;
                nodeA = nodeA.parent;
            }

            Node nodeB = tree.get(b);
            while(nodeB != null) {
                if(visited[nodeB.value] == true) {
                    commonAncestor = nodeB.value;
                    break;
                }
                else {
                    visited[nodeB.value] = true;
                    nodeB = nodeB.parent;
                }
            }

            bw.write(commonAncestor + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
    static class Node {
        public int value;
        public Node parent;
        public ArrayList<Node> children = new ArrayList<>();
        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}

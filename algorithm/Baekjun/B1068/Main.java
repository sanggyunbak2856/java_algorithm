package algorithm.Baekjun.B1068;

import java.io.*;
import java.util.*;

public class Main {
    static class Node{ // parent 가 Null이면 루트
        int value;
        List<Node> children;
        Node parent;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
            this.parent = null;
        }
    }
    static int count = 0;
    static void dfs(Node node, int deletedNode) {
        List<Node> children = node.children;
        if(node.value == deletedNode) return;
        if(children.size() == 0) {
            count++;
            return;
        }

        for(Node child : children) {
            if(child.value == deletedNode) continue;
            dfs(child, deletedNode);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node root = new Node(0);
        for(int i = 0; i < n; i++) {
            tree[i] = new Node(i);
        }

        for(int i = 0; i < n; i++) {
            int parentIdx = Integer.parseInt(st.nextToken());
            Node node = tree[i];
            if(parentIdx == -1) {
                root = tree[i];
                continue;
            }
            node.parent = tree[parentIdx];
            node.parent.children.add(node);
        }
        int m = Integer.parseInt(br.readLine());
        Node deleteNode = tree[m];
        if(deleteNode.parent != null) deleteNode.parent.children.remove(deleteNode);

        dfs(root, m);
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

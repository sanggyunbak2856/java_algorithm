package algorithm.Baekjun.B1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Node left;
        Node right;
        char value;
        Node() {}
        Node(char value) {
            this.value = value;
        }
    }
    static StringBuilder pre = new StringBuilder();
    static StringBuilder mid = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    static void preOrder(Node root) {
        pre.append(root.value);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }
    static void midOrder(Node root) {
        if(root.left != null) midOrder(root.left);
        mid.append(root.value);
        if(root.right != null) midOrder(root.right);
    }
    static void postOrder(Node root) {
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        post.append(root.value);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] nodeArr = new Node[n];

        for(int i = 0; i < n; i++) {
            Node node = new Node((char)(i + 65));
            nodeArr[i] = node;
        }
        Node root = nodeArr[0];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().toCharArray()[0];
            char left = st.nextToken().toCharArray()[0];
            char right = st.nextToken().toCharArray()[0];

            Node pNode = nodeArr[parent - 65];
            if(left != '.') {
                pNode.left = nodeArr[left - 65];
            }
            if(right != '.') {
                pNode.right = nodeArr[right - 65];
            }            
        }

        preOrder(root);
        midOrder(root);
        postOrder(root);

        bw.write(pre.append("\n").toString());
        bw.write(mid.append("\n").toString());
        bw.write(post.append("\n").toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

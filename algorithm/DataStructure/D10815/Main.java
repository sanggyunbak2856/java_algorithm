package algorithm.DataStructure.D10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.stream.IntStream;
import java.util.Arrays;

public class Main {
    public static boolean binarySearch(int[] arr, int start, int end, int find) {
        if(end - start < 0) return false;
        if(end - start == 1 && arr[0] == find) return true;
        if(end - start == 1 && arr[0] != find) return false;

        int mid = (start + end) / 2;

        if(arr[mid] == find) return true;
        else if(arr[mid] > find) return binarySearch(arr, start, mid, find);
        else return binarySearch(arr, mid, end, find);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        String[] str = br.readLine().split(" ");
        IntStream.range(0, n)
                .forEach(i -> cards[i] = Integer.parseInt(str[i]));
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        int[] check = new int[m];
        String[] str2 = br.readLine().split(" ");
        IntStream.range(0, m)
                .forEach(i -> check[i] = Integer.parseInt(str2[i]));
        
        StringBuilder sb = new StringBuilder();

        for(int i : check) {
            if(binarySearch(cards, 0, cards.length, i)) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}

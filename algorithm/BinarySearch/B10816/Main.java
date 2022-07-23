package algorithm.BinarySearch.B10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {
    public static int binarySearch(int find, int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1 && arr[0] == find) return 1;
        else if (arr.length == 1 && arr[0] != find) return 0;
        
        int mid = arr.length / 2;
        if(find > arr[mid]) {
            int[] newArr = Arrays.copyOfRange(arr, mid+1, arr.length);
            return binarySearch(find, newArr);
        } else if (find == arr[mid]) {
            int left = mid - 1;
            int right = mid + 1;
            int[] leftArr = Arrays.copyOfRange(arr, 0, left);
            int[] rightArr = Arrays.copyOfRange(arr, right, arr.length);
            return binarySearch(find, leftArr) + 2 + binarySearch(find, rightArr);
        } else {
            int[] newArr = Arrays.copyOfRange(arr, 0, mid-1);
            return binarySearch(find, newArr);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] element = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(element[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        int[] arr_num = new int[m];
        int[] answer = new int[m];
        String[] element2 = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            arr_num[i] = Integer.parseInt(element2[i]);
        }

        for(int i = 0; i < m; i++) {
            answer[i] = binarySearch(arr_num[i], arr);
            bw.write(answer[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
}

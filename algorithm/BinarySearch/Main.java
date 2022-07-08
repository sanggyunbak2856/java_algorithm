package algorithm.BinarySearch;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

public class Main {
    public static boolean binarySearch(List<Integer> list, int findNumber) {
        if(list.size() < 1) return false;
        else if(list.size() == 1 && list.get(0) == findNumber) return true;

        int mid = list.size() / 2;
        int listMid = list.get(mid);
        if(findNumber == listMid) return true;
        else if(findNumber > listMid) {
            List<Integer> newList = new ArrayList<Integer>();
            list.stream().filter(i -> i > listMid).forEach(j -> newList.add(j));
            return binarySearch(newList, findNumber);
        }
        else {
            List<Integer> newList = new ArrayList<Integer>();
            list.stream().filter(i -> i < listMid).forEach(j -> newList.add(j));
            return binarySearch(newList, findNumber);
        }
    }
    public static void main(String[] args) {
        // ArrayList 사용
        // 분할 정복
        List<Integer> list = new ArrayList<Integer>();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(i -> list.add(i));
        System.out.println(binarySearch(list, 20));
    }
}

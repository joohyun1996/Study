package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// boj 24060
// JAVA에서 List는 참조타입이라 굳이 반환하지 않아도, 수정의 결과가 반영된다.
// mergesort 개념은 알고있지만, 구현법은 다시한번보기
public class Recursion04 {
    static List<Integer> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        mergeSort(list, 0, list.size()-1);

        System.out.println((ansList.size() > m) ? ansList.get(m-1) : -1);
    }
    public static void mergeSort(List<Integer> list, int start, int end){
        if(start < end){
            int q = (start + end) / 2;
            mergeSort(list, start, q);
            mergeSort(list,q+1, end);
            merge(list, start, q, end);
        }
    }
    public static void merge(List<Integer> list, int start, int q, int end){
        int i = start;
        int j = q+1;
        int t = 0;
        List<Integer> tmp = new ArrayList<>();
        while( i <= q && j <= end){
            if(list.get(i) <= list.get(j)){
                tmp.add(list.get(i));
                i++;
            }else{
                tmp.add(list.get(j));
                j++;
            }
        }
        while( i <= q){
            tmp.add(list.get(i));
            ++i;
        }
        while (j <= end){
            tmp.add(list.get(j));
            ++j;
        }

        for (int k = 0; k < tmp.size(); k++) {
            list.set(start+k, tmp.get(k));
            ansList.add(tmp.get(k));
        }
    }
}

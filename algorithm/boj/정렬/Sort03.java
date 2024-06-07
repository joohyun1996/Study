package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// boj 25305
// Java.util.stream.sorted()를 사용해 해결.
// 역정렬은 sorted(Comparator.reverseOrder()) 사용
public class Sort03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        List<Integer> list = new ArrayList<>();

        int total = Integer.parseInt(str[0]);
        int threshold = Integer.parseInt(str[1]);
        str = br.readLine().trim().split(" ");
        for (int i = 0; i < total; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(list.get(threshold-1));
    }
}

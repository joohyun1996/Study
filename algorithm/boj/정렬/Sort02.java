package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// boj 2587
// 단순한 정렬문제. Stream()을 사용해 쉽게 해결함
public class Sort02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(br.readLine().trim()));
        }
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list.stream().reduce((a,b) -> a+b).get()/5);
        System.out.println(list.get(2));
    }
}

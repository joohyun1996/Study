package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// boj 2750
// 간단한 정렬문제로 stream().sorted()를 사용해서 해결했다.
public class Sort01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < repeat; i++) {
            list.add(Integer.parseInt(br.readLine().trim()));
        }

        List<Integer> ansList = list.stream().sorted().collect(Collectors.toList());

        for (Integer i : ansList) {
            System.out.println(i);
        }
    }
}

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//boj 2798

/**
 * dfs를 사용해서 if 문으로 최종 조건 검사시
 * return의 위치를 반드시 반드시 확인하자!
 * return 위치를 잘못잡으면 백트래킹이 아니라 전체 탐색을 하게되서 시간초과가 발생함!
 */
public class Bruteforce01 {
    static int ans = -1;
    static List<Integer> ansList = new ArrayList<>();
    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int num = Integer.parseInt(str[0]);
        int maximum = Integer.parseInt(str[1]);

        integerList = Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        dfs(0, num, maximum);
        System.out.println(ans);
    }

    public static void dfs(int index, int number, int maximum) {
        if (ansList.size() == 3) {
            int sum = ansList.stream().reduce(Integer::sum).get();
            if (sum <= maximum && sum > ans) {
                ans = sum;
            }
            return;
        }
        for (int i = index; i < number; i++) {
            ansList.add(integerList.get(i));
            dfs(i + 1, number, maximum);
            ansList.remove(Integer.valueOf(integerList.get(i)));
        }
    }
}

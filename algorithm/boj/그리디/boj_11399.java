package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// boj 11399

/**
 * int[] arr = Arrays.stream(br.readline().split(" ")).sorted().maptoint(Integer::parseInt).toArray;
 * 를 해버리면 문자열로 정렬이 되기 때문에 오답이 난다. 따라서 그냥 리스트로 입력을 받고 리스트를 collections를 사용해서 정렬함
 */
public class gd3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int ans = 0;
        List<Integer> integerList = new ArrayList<>();
        String[] strs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            integerList.add(Integer.parseInt(strs[i]));
        }

        Collections.sort(integerList);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                ans += integerList.get(j);
            }
        }

        System.out.println(ans);
    }
}

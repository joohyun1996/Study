package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// boj_11047

/**
 * 가장 기본적인 그리디 문제.
 * 이중 포문을 사용해서 해결했는데, 더 최적화 해서 풀 수 있어야 한다
 */
public class gd1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int cnt = 0;

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            integerList.add(Integer.parseInt(br.readLine().trim()));
        }

        Collections.sort(integerList, Collections.reverseOrder());


        // 최적화
        // 리스트의 역순으로 I 를 받아서, I가 최대 몇번 반복되는지 계산한 후, 나머지를 반복문을 돌린다
        for (Integer coin : integerList) {
            if (coin <= m) {
                cnt += m / coin;
                m %= coin;
            }
        }

        System.out.println(cnt);
    }
}
 /* 이전코드
        while (m != 0){
            for (Integer i : integerList) {
                if(i <= m) {
                    m -= i;
                    cnt += 1;
                    break;
                }
            }
        }
         */

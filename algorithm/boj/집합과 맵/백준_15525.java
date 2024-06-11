package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// boj 14425

/**
 * HashSet 혹은 HashMap을 사용해서 특정 문자열을 저장한 후,
 * 비교대상 문자열이 들어왔을 때, 비교하는 문제
 */
public class SetMap02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int answer = 0;

        Set<String> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            ansSet.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if(ansSet.contains(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}

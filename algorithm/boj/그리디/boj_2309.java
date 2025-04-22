package bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// boj 2309

/**
 * 브루트 포스로 푸는문제라고 작성되어 있긴한데, dfs로 풀었음
 * 요소를 더하면서 100을 넘거나, 전체 갯수를 넘는경우 return
 * 그렇지 않고 이번 dfs를 넘기고 싶은 경우는 dfs(start+1, cnt, sum)을 해줘서 다음 인덱스로 넘겨준다
 */
public class Bruteforce07 {
    static int[] arr;
    static ArrayList<Integer> list;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(arr);
        dfs(0, 0, 0);
    }
    public static void dfs(int start, int cnt, int sum){
        if(flag) {
            return;
        }
        if(cnt == 7 && sum == 100){
            for (Integer i : list) {
                System.out.println(i);
            }
            flag = true;
            return;
        }
        if(start > 8 || cnt > 8 || sum > 100){
            return;
        }

        list.add(arr[start]);
        dfs(start + 1, cnt + 1, sum + arr[start]);
        list.remove(list.size()-1);

        dfs(start+1, cnt, sum);
    }
}

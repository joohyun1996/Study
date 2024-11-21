package graphAndTraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// boj 24479

/**
 * 그래프를 dfs로 순회하는 문제. 근데 기존 dfs와는 다르게 시작 노드를 구하고, 해당 노드부터 가장 숫자가 낮은 노드들만 탐색하는 문제
 * 이를 풀기 위해서 정답 배열을 미리 전역으로 선언 후, 재귀 과정마다 특정 인덱스의 재귀가 있으면 해당 깊이를 넣어주었다.
 * 그렇지 않으면 return (혹은 시작 지점만 있을 경우, 해당 지점만 넣어준다)
 */
public class gt01 {
    static boolean[] chk;
    static int[] ansArr;
    static int depth = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int r = Integer.parseInt(strs[2]);

        chk = new boolean[n+1];
        ansArr = new int[n+1];

        Arrays.fill(ansArr, 0);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            lists.get(input[0]).add(input[1]);
            lists.get(input[1]).add(input[0]);
        }

        for (ArrayList<Integer> list : lists) {
            Collections.sort(list);
        }

        dfs(lists, r);

        for (int i = 1; i <= n; i++) {
            bw.write(ansArr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(ArrayList<ArrayList<Integer>> lists, int start){
        if(lists.get(start).isEmpty()){
            ansArr[start] = depth;
            return;
        }

        chk[start] = true;
        ansArr[start] = depth;

        for (Integer i : lists.get(start)) {
            if(!chk[i]){
                depth++;
                dfs(lists, i);
            }
        }
    }
}

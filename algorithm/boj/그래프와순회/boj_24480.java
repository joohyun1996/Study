package graphAndTraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// boj 24480

public class gt02 {
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
            Collections.sort(list, Collections.reverseOrder());
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

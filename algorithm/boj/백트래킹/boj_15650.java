package backtracking;

import java.io.*;
import java.util.ArrayList;

// boj 15650
// 백트래킹. 하지만 이전과 다르게 입력되는 숫자가 기존의 숫자보다 커야한다.
// 따라서 해당 조건을 if~continue를 사용하여 제거한다

public class Backtracking2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] chk = new boolean[9];
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        dfs(n, m);
        bw.flush();
        bw.close();
    }

    public static void dfs(int n, int m) throws IOException {
        if (m == list.size()) {
            for (Integer i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (chk[i] == false && !list.contains(i)) {
                if (list.size() > 0 && list.get(list.size() - 1) >= i) {
                    continue;
                }
                chk[i] = true;
                list.add(i);
                dfs(n, m);
                list.remove(list.size() - 1);
                chk[i] = false;
            }
        }
    }
}

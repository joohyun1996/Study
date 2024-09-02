package backtracking;

import java.io.*;
import java.util.ArrayList;

// boj 15651
// 백트래킹이 아닌 재귀문제. 왜냐하면 어떤 조건도 없이 출력하면 되기 때문
public class Backtracking3 {
    static ArrayList<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        dfs(n,m);
        bw.flush();
        bw.close();
    }
    public static void dfs(int n, int m) throws IOException {
        if (m == list.size()){
            for (Integer i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n ; i++) {
            list.add(i);
            dfs(n,m);
            list.remove(list.size()-1);
        }
    }
}

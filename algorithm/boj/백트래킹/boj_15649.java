package backtracking;

import java.io.*;
import java.util.ArrayList;

// boj 15649
// 백트래킹의 가장 기본
// 유망한 것으로 판단되는 숫자(인덱스)만 방문하도록 재귀함수를 사용하기전 미리 조사한다.
// static 을 어떻게 사용해야 할지는 미리 생각


public class Backtracking1 {
    static boolean[] chk = new boolean[9];
    static ArrayList<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);


        dfs(n, m);
        bw.flush();
        bw.close();
    }
    public static void dfs(int n, int m) throws IOException {
        if(m==list.size()){
            for (Integer i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(chk[i] == false && !list.contains(i)){
                list.add(i);
                chk[i] = true;
                dfs(n,m);
                chk[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

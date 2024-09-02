package backtracking;

import java.io.*;
import java.util.ArrayList;

// boj 15632
// 이전에 나온 수보다 다음에 나온 수가 작으면 안되는 수를 찾는 백트래킹
// 같아도는 되는데 작으면 안된다. if문을 사용해서 이전에 사용된 list의 마지막 값을 찾아서 continue
public class Backtracking4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> list = new ArrayList<>();

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
        if(m == list.size()){
            for (Integer i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n ; i++) {
            if(list.size() > 0 && list.get(list.size()-1) > i) continue;
            list.add(i);
            dfs(n,m);
            list.remove(list.size()-1);
        }
    }
}

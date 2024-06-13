package set_map;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

// boj 1269
// 대칭 차집합을 구하는 문제이므로, Aset.Size() + Bset.Size() - duplicate * 2
public class SetMap07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int duplicate = 0;

        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            leftSet.add(Integer.parseInt(str[i]));
        }

        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            rightSet.add(Integer.parseInt(str[i]));
        }

        for (Integer i : rightSet) {
            if(leftSet.contains(i)) ++duplicate;
        }

        System.out.println(leftSet.size() + rightSet.size() - duplicate*2);
    }
}

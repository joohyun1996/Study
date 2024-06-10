package set_map;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// boj 10815
public class SetMap01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> integerSet = new HashSet<>();
        List<Integer> integerList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());
        String[] strs = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            integerSet.add(Integer.parseInt(strs[i]));
        }

        int m = Integer.parseInt(br.readLine().trim());
        strs = br.readLine().trim().split(" ");
        for (int i = 0; i < m; i++) {
            integerList.add(Integer.parseInt(strs[i]));
        }

        for (Integer i : integerList) {
            if (integerSet.contains(i)) bw.write("1" + " ");
            else bw.write("0" + " ");
        }
        bw.flush();
        bw.close();
    }
}

package set_map;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// boj 1764
// HashSet.contains()를 사용하여 특정 input이 set 내부에 있는지,없는지 확인
public class SetMap06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        Set<String> listenSet = new HashSet<>();
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listenSet.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(listenSet.contains(str)) answerList.add(str);
        }

        System.out.println(answerList.size());
        for (String s : answerList.stream().sorted().collect(Collectors.toList())) {
            System.out.println(s);
        }
    }
}

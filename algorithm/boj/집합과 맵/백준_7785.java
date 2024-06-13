package set_map;

import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// boj 7785
// 조건이 enter, leave만 존재하므로 HashSet을 만들어서 이름이 들어오면 add, 중복시 remove 진행
// 모든 경우가 끝나면 HashSet을 List로 정렬해 바꿔준다.
public class SetMap03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine().trim());
        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            String name = br.readLine().trim().split(" ")[0];
            if(nameSet.contains(name)) nameSet.remove(name);
            else nameSet.add(name);
        }

        List<String> answerList = nameSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (String s : answerList) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}

package set_map;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

// boj 11748
// string 입력받고 string을 순회하면서 해당 부분 string이 set내부에 contains 되어있지 않다면 add
public class SetMap08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        Set<String> answerSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            String tmp = "";
            for (int j = i; j < str.length(); j++) {
                tmp += str.charAt(j);
                if(!answerSet.contains(tmp)) answerSet.add(tmp);
            }
        }

        System.out.println(answerSet.size());
    }
}

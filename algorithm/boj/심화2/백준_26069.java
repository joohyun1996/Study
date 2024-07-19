package complex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// boj 26069
// set을 사용해서 string간의 연결관계 찾아보는 문제
public class CP03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            list.add(strs[0]);
            list.add(strs[1]);
        }

        for (int i = 0; i < 2*n; i += 2) {
            if("ChongChong".equals(list.get(i)) || "ChongChong".equals(list.get(i+1))){
                set.add(list.get(i));
                set.add(list.get(i+1));
            }else if(set.contains(list.get(i)) || set.contains(list.get(i+1))){
                set.add(list.get(i));
                set.add(list.get(i+1));
            }
        }
        System.out.println(set.size());
    }
}

package complex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// boj 25192
// list와 set 그리고 string을 잘 쓸 수 있는지 물어보는 문제
public class CP02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        Set<String> map = new HashSet<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if("ENTER".equals(list.get(i))){
                map.clear();
            }else{
                if(!map.contains(list.get(i))){
                    ++cnt;
                    map.add(list.get(i));
                }
            }
        }
        System.out.println(cnt);
    }
}

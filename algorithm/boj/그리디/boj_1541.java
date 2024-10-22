package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//boj 1541

/**
 * 최솟값만을 원하므로 - 뒤에 오는 +만 확인해서 + 연산만 괄호로 묶어준다.(그 부분만 더해준다)
 * 그 뒤에 모든 값을 -만 남겨서 리스트로 빼주면 된다.
 */
public class gd4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().trim().split("-");
        ArrayList<Integer> list = new ArrayList<>();

        for (String s : strs) {
            int tmp = 0;
            if(s.contains("+")){
               String[] sArr = s.split("\\+");
                for (String string : sArr) {
                    tmp += Integer.parseInt(string);
                }
                list.add(tmp);
            }else{
                list.add(Integer.parseInt(s));
            }
        }

        int ans = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            ans -= list.get(i);
        }

        System.out.println(ans);
    }
}

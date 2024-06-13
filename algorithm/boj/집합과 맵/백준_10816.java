package set_map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//boj 10816

/**
 * HashMap을 사용해서 input값이 몇번 들어오는지 세어준다.
 * if-else로 input이 있는지 없는지 확인후 
 * 있으면 put(input(), 1)
 * 없으면 put(input(), Map.get(input())+1)
 * 이렇게 했는데 더 좋은 경우가 있는지 확인해 봐야할듯
 */

public class SetMap05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> cardMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            if(!cardMap.containsKey(str[i])){
                cardMap.put(str[i],1);
            }else{
                cardMap.put(str[i], cardMap.get(str[i])+1);
            }
        }
        
        int m = Integer.parseInt(br.readLine().trim());
        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if(cardMap.containsKey(str[i])) bw.write(cardMap.get(str[i]) + " ");
            else bw.write("0" + " ");
        }
        bw.flush();
        bw.close();
    }
}

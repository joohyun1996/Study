package complex2;

import java.io.*;
import java.util.*;


// boj 20920
// 풀다가 인터넷으로 힌트를 얻은 문제

/**
 * HashMap을 Key,Value로 정렬하고 싶을 때, new ArrayList<>(map.KeySet());을 사용해서 정렬할 수 있다.
 * 또 해당 list를 sort할때 comparator 를 custom 하여 사용 가능하다
 * 그런데 파이썬처럼 여러개로 가능 순차적으로 조건별로 구분하여 return 해주면 된다.
 */
public class CP05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        String tmp = null;
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tmp = br.readLine().trim();
            if (tmp.length() >= k){
                if (map.containsKey(tmp)){
                    int cnt = map.get(tmp);
                    map.put(tmp,++cnt);
                }else{
                    map.put(tmp, 1);
                }
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());


        keySet.sort((o1, o2) -> {
            int freqCompare = map.get(o2).compareTo(map.get(o1));
            if (freqCompare != 0) {
                return freqCompare;
            }
            int lengthCompare = Integer.compare(o2.length(), o1.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return o1.compareTo(o2);
        });


        /*KeySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) != map.get(o2)){
                    return map.get(o2).compareTo(map.get(o1));
                }else{
                    if(o1.length() != o2.length()){
                        return (o1.length() > o2.length()) ? o1.length() : o2.length();
                    }else{
                        return (o1.compareTo(o2));
                    }
                }
            }
        });*/

        for (String s : keySet) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}

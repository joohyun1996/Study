package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// boj 1181

/**
 * 결국 Collections.sort() 에서 compareTo()를 적용하는게 중요한 문제
 * 길이 -> 알파벳 순 정렬을 해야하므로 첫번째 if 문에서는 길이가 같을경우
 * 두번째는 길이가 다를경우를 확인해야 한다.
 */
public class Sort09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String tmp = br.readLine().trim();
            if(!stringList.contains(tmp)){
                stringList.add(tmp);
            }
        }

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String s : stringList) {
            System.out.println(s);
        }
    }
}

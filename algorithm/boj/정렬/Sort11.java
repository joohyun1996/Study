package sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// boj 18870

/**
 * BFS등 여러가지 푸는 방법이 있지만, 간단하게 정렬을 사용해서 풀음
 * 기본 개념은 원래 입력받은 순서와, HashSetdmf 사용해서 중복을 제거한 순서를 동시에 가지고 있는다는 것
 * 그리고 중복을 제거한 리스트를 HashMap으로 바꿔서 Map에서 get(index)을 해 시간 복잡도를 줄여야 한다.
 * 또한 출력을 sout이 아니라 bw.write() 를 해야 시간 복잡도 오류가 발생하지 않는다.
 */
public class Sort11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine().trim());
        String[] strs = br.readLine().split(" ");

        List<Integer> list = Arrays.stream(strs).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> tmpList = new ArrayList<>(new HashSet<>(list));
        Collections.sort(tmpList);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < tmpList.size(); i++) {
            indexMap.put(tmpList.get(i), i);
        }

        for (Integer i : list) {
           bw.write(indexMap.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}

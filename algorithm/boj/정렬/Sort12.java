package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 2910

/**
 * 정렬을 하는 문제로, HashSet으로 입력된 배열의 원소의 갯수를 센 다음 해당 셋을 기준으로 정렬을 해준다.
 * 또한 값이 같은 경우 먼저 들어온 순서로 정렬되도록 if 문을 통해 구성하고
 * 마지막으로 정렬된 list를 입력된 갯수 만큼 반복해서 출력 해준다.
 */
public class Sort12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int c = inputs[1];

        // LinkedHashMap은 삽입 순서를 보장하여, 먼저 나온 숫자가 키 순서 앞에 위치함
        Map<Integer, Integer> numberCount = new LinkedHashMap<>();
        ArrayList<Integer> orderList = new ArrayList<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : arr) {
            numberCount.put(i, numberCount.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> numbers = new ArrayList<>(numberCount.keySet());

        numbers.sort((o1, o2) -> numberCount.get(o2) - numberCount.get(o1));
        // o1 - o2 로 설정시 내림차순
        // o2 - o1으로 설정시 오름차순 정렬이 된다.

        for (Integer number : numbers) {
            int count = numberCount.get(number);
            for (int z = 0; z < count; z++) {
                System.out.printf(number + " ");
            }
        }

        /*for (int i : arr) {
            if(!numberCount.containsKey(i)){
                numberCount.put(i, 1);
            }else{
                numberCount.put(i, numberCount.get(i)+1);
            }

            if(!orderList.contains(i)){
                orderList.add(i);
            }
        }

        ArrayList<Integer> tmpList = new ArrayList<>(numberCount.keySet());

        tmpList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(numberCount.get(o1) == numberCount.get(o2)){
                    return orderList.indexOf(o1) - orderList.indexOf(o2);
                }
                return numberCount.get(o2) - numberCount.get(o1);
            }
        });

        for (Integer i : tmpList) {
            int iter = numberCount.get(i);
            for (int j = 0; j < iter; j++) {
                System.out.printf(i + " ");
            }
        }*/
    }
}

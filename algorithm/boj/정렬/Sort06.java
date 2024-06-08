package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.Collectors;

// boj 1427

/**
 * 문제 자체가 그렇게 어려운건 아님
 * 그런데 string -> stream 으로 바꾸는게 어색함.
 * 해당 사용법 명확히 인지할 것
 */
public class Sort06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        /*List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (Integer i : list) {
            System.out.printf("%d" + "", i);
        }*/
        
        // map to obj 는 원시타입의 스트림을 객체타입의 스트림으로 변환시 사용
        // IntStream, LongStream, DoubleStream -> Stream<Integer, Long, ...>
        String answer = str.chars()
                .mapToObj(c -> Character.toString((char) c))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        System.out.println(answer);

    }
}

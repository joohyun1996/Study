package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj 11720
public class String04 {

    /**
     * String.chars()를 하면 IntStream 으로 변환된다.
     * 그리고 .map()을 사용해 Character의 값을 int로 변경한다
     *
     * Stream 에서 사용가능한 메소드
     * filter(조건에 맞는 요소 찾기), map(스트림 내부 요소를 다른 값(타입)으로 변환)
     * distinct(중복제거), sorted(정렬), limit(지정된 n개만 찾기), skip(n개 넘기고 찾기), reduce(스트림의 요소를 하나로 줄이기)
     * 그 외에도 다양한 함수가 존재한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        String str = br.readLine().trim();

        /*int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            answer += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println(answer);*/

        int answer = str.chars().map(Character::getNumericValue).sum();
        // int answer2 = str.chars().map(Character::getNumericValue).reduce(0, (a,b) -> a+b);
        // reduce를 써도 계산 가능하다

        System.out.println(answer);
    }
}

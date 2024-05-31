package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2675
public class String06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testCase; i++) {
            String[] strs = br.readLine().trim().split(" ");
            int size = Integer.parseInt(strs[0]);
            String str = strs[1];

            //굳이 출력만 하면 되는데 list를 사용할 이유가 없음
            // str.toCharArray() 는 string을 char[] 로 바꿔준다.

            /*List<Character> answerList = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < size; k++) {
                    answerList.add(str.charAt(j));
                }
            }

            for (Character c : answerList) {
                System.out.printf("%c", c);
            }*/

            for (char c : str.toCharArray()) {
                for (int j = 0; j < size; j++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        
    }
}

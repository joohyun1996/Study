package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// boj 2839

/**
 * DFS 인척 해서 백트래킹으로 풀어보려 했는데 시간초과 발생
 * 그래서 그냥 반복문으로 풀었다. 중요한점은 그리디 알고리즘을 사용하므로 가장 큰 값부터 계산해 주면 좋다는것
 * 그래서 5로 나눌 수 있으면 한번에 나누는것이 좋다.
 */
public class Bruteforce06 {
    static int answer = 987654321;
    static List<Integer> integerList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        int count = 0;

        while(number > 0){
            if(number % 5 == 0) {
                count += number / 5;
                break;
            }else{
                number -= 3;
                ++count;
            }
            if(number < 0){
                count = -1;
            }
        }
        System.out.println(count);
    }
}

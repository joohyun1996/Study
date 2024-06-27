package number2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// boj 2485
// 최대 공약수를 BigInteger를 사용해서 구한 후 (N 이 다수 존재)
// 최대 공약수로 두 지점간의 거리를 나눈 후 -1을 해준다 (왜냐하면 이미 양쪽에 점이 있으니)
public class Number04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        int ans = 0;
        List<Integer> inputList = new ArrayList<>();
        List<Integer> sparseList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            inputList.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i < inputList.size(); i++) {
            sparseList.add(inputList.get(i) - inputList.get(i-1));
        }

        Collections.sort(sparseList);

        int min = Collections.min(sparseList);

        BigInteger gcd = BigInteger.valueOf(0);

        for (int i = 0; i < sparseList.size(); i++) {
            gcd = gcd.gcd(BigInteger.valueOf(sparseList.get(i)));
        }

        for (Integer i : sparseList) {
            if(i == gcd.intValue()) continue;
            ans += i / gcd.intValue() - 1;
        }

        System.out.println(ans);
    }
}

package complex2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// boj 1037
// N의 약수들 가운데 N을 찾는 문제
// list로 정렬 후 맨 처음과 끝값을 곱해서 계산했다.
public class CP01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());

        double ans = list.get(0) * list.get(list.size()-1);
        bw.write((long) ans + "");
        bw.flush();
    }
}

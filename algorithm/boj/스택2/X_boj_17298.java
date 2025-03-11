package stack2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 17298

/**
 * Monotonic Stack (단조스택)
 * 단조 증가나 단조 감소를 이용하는 알고리즘 기법으로 특정 조건을 o(n)시간 복잡도로 찾을 수 있다
 * 스택 내부 원소들은 단조 증가나 단조 감소를 유지한다. 따라서 각 원소는 스택에 한법 push, pop을 가지기 때문에 최악의 경우에도 O(n)이 보장된다
 * (이 문제 에서는 스택의 가장 큰 값이 유지된다)
 * 오큰수, 오등큰수, 주식가격, 히스토그램에서 가장 큰 직사각형 등의 문제에 사용된다
 */
public class st2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];

        Deque<Integer> queue = new ArrayDeque<>();

        // 배열의 뒤부터 스택에 넣음
        for (int i = n - 1; i >= 0; i--) {
            // 큐에 값이 들어가 있을 때, 검사중인 인덱스의 값보다 큐의 맨 앞값이 작으면 반복해서 해당 값을 큐에서 pop 해준다
            while (!queue.isEmpty() && queue.peek() <= arr[i]) {
                queue.pop();
            }
            // 현재 수 보다 큰 값이 없으면 -1 아니면 큐에 있는 가장 큰 값 (맨 앞 값)을 넣어준다.
            if (queue.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = queue.peek();
            }
            // 현재 숫자를 스택에 넣고 다음 숫자 검색
            queue.push(arr[i]);
        }

        for (int i : answer) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}

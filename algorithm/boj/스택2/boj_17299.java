package stack2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 17299

/**
 * 이전 오큰수? 의 변형인 오등큰수
 * 결과적으로 큰 차이는 없고 오등수에서 사용한 단조 증가를 다시 사용하면 되는 문제이다
 * o(n^2)를 o(n)으로 줄일 수 있으니 반드시 기억하자
 */
public class st3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] countArr = new int[1000001];
        for (int i : arr) {
            countArr[i] += 1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] answer = new int[n];

        for (int i = n-1 ; i >= 0; i--) {
            while(!queue.isEmpty() && countArr[arr[i]] >= countArr[queue.peek()]){
                queue.pop();
            }

            if(queue.isEmpty()){
                answer[i] = -1;
            }else{
                answer[i] = queue.peek();
            }

            queue.addFirst(arr[i]);
        }

        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}

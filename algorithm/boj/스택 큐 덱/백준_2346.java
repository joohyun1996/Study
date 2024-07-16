package StackDeque;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// boj 2346
// deque를 잘 쓰세요? 하고 물어보는 문제
public class SDQ10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int tmp = deque.pollFirst();
        bw.write(tmp + " ");

        while(deque.size() != 0) {
            if(list.get(tmp-1) > 0){
                for (int i = 1; i < list.get(tmp-1); i++) {
                    deque.addLast(deque.pollFirst());
                }
            }else{
                for (int i = list.get(tmp-1); i < 0; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
            tmp = deque.pollFirst();
            bw.write(tmp + " ");
        }
        bw.flush();
        bw.close();
    }
}

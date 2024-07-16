package StackDeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// boj 11866
// 요세푸스 문제인데, 반복문 돌면서 특정 숫자마다 큐에서 숫자 빼주면 된다
public class SDQ08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().trim().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        int tmp = 1;
        bw.write("<");
        while(deque.size() != 0){
            if(tmp % m == 0){
                if(deque.size() != 1) bw.write(deque.pollFirst() + ", ");
                else bw.write(deque.pollFirst() + ">");
            }else{
                deque.addLast(deque.pollFirst());
            }
            tmp++;
        }
        bw.flush();
        bw.close();
    }
}

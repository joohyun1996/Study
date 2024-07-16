package StackDeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// boj 28279
// deque의 함수들을 잘 쓸 줄 아나요?
// pollfirst/last, peekfirst/last를 쓸 줄 아나요?
public class SDQ09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine().trim());
        Integer tmp = -1;

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().trim().split(" ");
            if(strs.length == 1){
                if(Integer.parseInt(strs[0]) == 3){
                    tmp = deque.pollFirst();
                } else if (Integer.parseInt(strs[0]) == 4) {
                    tmp = deque.pollLast();
                } else if (Integer.parseInt(strs[0]) == 5) {
                    tmp = deque.size();
                } else if (Integer.parseInt(strs[0]) == 6) {
                    if(deque.size() == 0) tmp = 1;
                    else tmp = 0;
                } else if (Integer.parseInt(strs[0]) == 7){
                    tmp = deque.peekFirst();
                } else {
                    tmp = deque.peekLast();
                }
                if(null == tmp) tmp = -1;
                bw.write(tmp + "\n");
            }else{
                if(Integer.parseInt(strs[0]) == 1) deque.addFirst(Integer.parseInt(strs[1]));
                else deque.addLast(Integer.parseInt(strs[1]));
            }
        }
        bw.flush();
        bw.close();
    }
}

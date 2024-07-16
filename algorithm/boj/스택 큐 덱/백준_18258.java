package StackDeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// boj 18258
// 특별한 알고리즘을 사용하는게 아니라 deque 자료구조 연습
public class SDQ06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine().trim());
        String[] strs = null;

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            Integer tmp = -1;

            if(strs.length == 1){
                if("pop".equals(strs[0])){
                    tmp = deque.pollFirst();
                } else if ("size".equals(strs[0])) {
                    tmp = deque.size();
                } else if ("empty".equals(strs[0])) {
                    if(0 == deque.size()) tmp = 1;
                    else tmp = 0;
                } else if ("front".equals(strs[0])) {
                    tmp = deque.peekFirst();
                } else if ("back".equals(strs[0])){
                    tmp = deque.peekLast();
                }
                if(tmp==null) tmp = -1;
                bw.write(tmp + "\n");
            }else{
                deque.addLast(Integer.parseInt(strs[1]));
            }
        }
        bw.flush();
        bw.close();
    }
}

package StackDeque;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// boj 24511
// queue 와 stack 이 무작위로 주어질 때, 원소 하나씩 넣고 빼보는 문제
// 하지만 스택은 넣고 빼면 의미가 없으므로 패스하면 된다.
public class SDQ11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        List<Integer> sqList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> intList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (sqList.get(i) == 0) {
                deque.addLast(intList.get(i));
            }
        }

        int m = Integer.parseInt(br.readLine().trim());

        List<Integer> inputlist = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer i : inputlist) {
            deque.addFirst(i);
            bw.write(deque.pollLast() + " ");
        }

        bw.flush();
        bw.close();
    }
}

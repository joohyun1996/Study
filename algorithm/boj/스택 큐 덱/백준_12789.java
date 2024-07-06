package StackDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// boj 12789

/**
 * 뭐랄까 스택을 사용하는 문제이지만, 문제 설명이 깔끔하지 않아서 오래 걸린문제
 * i++인 상황에서 리스트(0)에 담긴 숫자가 i 와 일치하면 popleft, 아니면 스택에 저장
 * i는 스택의 마지막 원소와 리스트(0) 사이에서 일치하면 뽑아 쓰는 문제
 * if-else를 주로 이용했는데, 너무 더럽게 푼거같다
 */
public class SDQ05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        int prev = -1;
        List<Integer> tmpStack = new ArrayList<>();
        List<Integer> inputList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 1; i <= size*2 ; ) {
            if(!inputList.isEmpty() && i == inputList.get(0)){
                ++i;
                inputList.remove(0);
            }else{
                if(!tmpStack.isEmpty() && (i == tmpStack.get(tmpStack.size()-1))){
                    ++i;
                    tmpStack.remove(tmpStack.size()-1);
                }else{
                    if(!inputList.isEmpty()) tmpStack.add(inputList.get(0));
                    else if(inputList.isEmpty() && prev == tmpStack.size()) break;
                    inputList.remove(0);
                }
            }
            prev = tmpStack.size();
            if(i > size) break;
        }

        if(!tmpStack.isEmpty()) System.out.println("Sad");
        else System.out.println("Nice");
    }
}

/* 코드 간소화
package StackDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SDQ05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Integer> inputList = Arrays.stream(br.readLine().split(" "))
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
        List<Integer> tmpStack = new ArrayList<>();
        int i = 1;

        while (i <= size) {
            if (!inputList.isEmpty() && inputList.get(0) == i) {
                inputList.remove(0);
                i++;
            } else if (!tmpStack.isEmpty() && tmpStack.get(tmpStack.size() - 1) == i) {
                tmpStack.remove(tmpStack.size() - 1);
                i++;
            } else if (!inputList.isEmpty()) {
                tmpStack.add(inputList.remove(0));
            } else {
                break;
            }
        }

        System.out.println(tmpStack.isEmpty() ? "Nice" : "Sad");
    }
}
 */

package StackDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// boj 9012
// 괄호를 스택에 담아보는 문제, 결국 입력된 문자열을 뒤부터 제거하면서 스택에 넣어서 스택에 남는것이 있는가? 를 살펴보는 문제다
public class SDQ03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            List<Character> inputChar = br.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            List<Character> tmpChar = new ArrayList<>();

            for (int j = inputChar.size()-1; j >= 0; j--) {
                if(inputChar.get(j) == ')'){
                    tmpChar.add(inputChar.get(j));
                }else{
                    if(tmpChar.size() > 0 && tmpChar.get(tmpChar.size()-1) == ')'){
                        tmpChar.remove(tmpChar.size()-1);
                    }else{
                        tmpChar.add(inputChar.get(j));
                    }
                }
                inputChar.remove(j);
            }
            if(tmpChar.size() == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

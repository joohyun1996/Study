package StackDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// boj 4949

/**
 * 저번 문제처럼 () [] 만 골라서 list에 담고, 하나씩 뽑아서 확인하는 문제.
 * 매우 쉬웠는데, 여러번 틀렸다. 그 이유는 input할때 br.readline().trim()을 습관적으로 사용하는데, 이때 " ."이 trim 처리되면서 "."으로 바뀌어 종료선언을 해버린것
 * 이러면 안된다...
 */
public class SDQ04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            List<Character> inputList = new ArrayList<>();
            List<Character> ansList = new ArrayList<>();
            String inputStr = br.readLine();

            if(1 == inputStr.length() && ".".equals(inputStr)) break;
            String[] strs = inputStr.split(" ");

            for (String str : strs) {
                char[] tmpArr = str.toCharArray();
                for (char c : tmpArr) {
                    if('(' == c || ')' == c || '[' == c || ']' == c || '.' == c) {
                        inputList.add(c);
                    }
                }
            }

            for (int i = inputList.size()-1; i >= 0 ; i--) {
                if(inputList.get(i) == '(' && ansList.size() > 0 && ansList.get(ansList.size()-1) == ')'){
                    ansList.remove(ansList.size()-1);
                } else if (inputList.get(i) == '[' && ansList.size() > 0 && ansList.get(ansList.size()-1) == ']') {
                    ansList.remove(ansList.size()-1);
                } else{
                    ansList.add(inputList.get(i));
                }
            }

            if(ansList.size() == 1 && '.'==ansList.get(0)) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }
        bw.flush();
        bw.close();
    }
}

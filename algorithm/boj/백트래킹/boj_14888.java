package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// boj 14888
// 연산자와 정수가 주어지면 이를 이용해서 백트래킹으로 풀어보는 문제
// 생각보다 쉽지 않았고, 이전 정답을 참고했음
// 일단 머리속에 완벽히 알고리즘을 구상하고 풀어야함
public class Backtracking7 {
    static ArrayList<Integer> numericList = new ArrayList<>();
    static int[] operatorArr = new int[4];
    static ArrayList<Integer> resultList = new ArrayList<>();
    static ArrayList<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numericList.add(Integer.parseInt(strs[i]));
        }
        strs = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operatorArr[i] = Integer.parseInt(strs[i]);
        }
        dfs();

        Collections.sort(ansList);
        System.out.println(ansList.get(ansList.size()-1));
        System.out.println(ansList.get(0));
    }

    public static void dfs(){
        if (resultList.size() == numericList.size() -1){
            ansList.add(isPromising());
            return;
        }

        for (int i = 0; i < operatorArr.length; i++) {
            if(operatorArr[i] != 0){
                resultList.add(i);
                operatorArr[i]--;
                dfs();
                operatorArr[i]++;
                resultList.remove(resultList.size()-1);
            }
        }
    }

    public static int isPromising(){
        int tmp = numericList.get(0);
        for (int i = 0; i < resultList.size(); i++) {
            switch (resultList.get(i)){
                case 0:
                    tmp += numericList.get(i + 1);
                    break;
                case 1:
                    tmp -= numericList.get(i + 1);
                    break;
                case 2:
                    tmp *= numericList.get(i + 1);
                    break;
                case 3:
                    if(tmp < 0){
                        tmp = -(Math.abs(tmp) / numericList.get(i+1));
                    }else{
                        tmp /= numericList.get(i+1);
                    }
                    break;
            }
        }
        return tmp;
    }
}

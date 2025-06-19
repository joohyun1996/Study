package string;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

// boj 2870

/**
 * 문제를 똑바로 읽어야함. 한 줄에 최대 100개의 입력이 가능하므로 BigInteger를 사용해야 한다.
 */
public class String17 {
    static ArrayList<BigInteger> numberList;
    static HashSet<Character> numberSet = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        numberList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine().trim();
            findNumberInString(str);
        }

        Collections.sort(numberList);

        for (BigInteger i : numberList) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
    public static void findNumberInString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(numberSet.contains(c)){
                sb.append(c);
            }else{
                if(sb.length() > 0){
                    numberList.add(new BigInteger(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        if(sb.length() > 0){
            numberList.add(new BigInteger(sb.toString()));
        }
    }
}

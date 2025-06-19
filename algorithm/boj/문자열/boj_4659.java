package string;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

// boj 4659

/**
 * 쉬운문제. Set을 써서 얼마나 쉽게 모음처리를 하는지 테스트.
 * 좀 노가다성이 진한 문제
 */
public class String16 {
    static HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str;
        while(!(str = br.readLine()).equals("end")){
            if(checkVowel(str)){
                if(checkCount(str)){
                    if(checkDoubleChar(str)){
                        bw.write("<" + str + ">" + " is acceptable.\n");
                        continue;
                    }
                }
            }
            bw.write("<" + str + ">" + " is not acceptable.\n");
        }
        bw.flush();
        bw.close();
    }
    public static boolean checkDoubleChar(String str){
        for (int i = 1; i < str.length(); i++) {
            char first = str.charAt(i-1);
            char second = str.charAt(i);

            if(first == second){
                if(first == 'o' || first =='e'){
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean checkCount(String str){
        for (int i = 2; i < str.length(); i++) {
            char first = str.charAt(i-2);
            char second = str.charAt(i-1);
            char third = str.charAt(i);

            if(vowelSet.contains(first) && vowelSet.contains(second) && vowelSet.contains(third)){
                return false;
            }
            if(!vowelSet.contains(first) && !vowelSet.contains(second) && !vowelSet.contains(third)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkVowel(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(vowelSet.contains(c)){
                return true;
            }
        }
        return false;
    }
}

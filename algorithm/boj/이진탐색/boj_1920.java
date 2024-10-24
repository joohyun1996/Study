package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

// boj 1920

/**
 * 이진탐색으로 N배열에 M배열을 검사할 경우, 존재 하는지, 아닌지를 검사하는 문제.
 * List 사용 -> 시간초과. Hashset -> 통과
 */
public class bs1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        HashSet<Integer> nSet = new HashSet<>(n);
        String[] strs = br.readLine().split(" ");

        for (String str : strs) {
            nSet.add(Integer.parseInt(str));
        }

        int m = Integer.parseInt(br.readLine().trim());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : mArr) {
            if(nSet.contains(i)){
                bw.write(1 + "\n");
            }else{
                bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

// boj 10816

/**
 * 이진탐색에서 꼭 버퍼 라이터를 써 줘야 한다는것을 기억하기
 * 또한 HashMap과 HashTable의 차이도 알자
 * hashMap : 싱글쓰레드에서 우월, HashTable : 동기화 되어있음, LegacyCode에서 자주 사용
 */
public class bs2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        HashMap<Integer, Integer> hashtable = new HashMap<>(n);

        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : nArr) {
            if(!hashtable.containsKey(i)){
                hashtable.put(i,1);
            }else{
                hashtable.replace(i, hashtable.get(i) +1);
            }
        }

        int m = Integer.parseInt(br.readLine().trim());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : mArr) {
            if(hashtable.containsKey(i)){
                bw.write(hashtable.get(i)+ " ");
            }else{
                bw.write(0 + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}

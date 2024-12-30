package twoPointer;

import java.io.*;
import java.util.ArrayList;

// boj 1644

/**
 * 투포인터와 누적합을 이용해서 해결.
 * 이번 문제도 저번 문제의 연장선인데 아리스토텔레스의 체를 같이 사용해야 했다.
 * 풀면서 시간복잡도 괜찮나? 생각했지만 시간제한 2초인것으로 보아서 이렇게 풀으라고 낸듯
 */
public class tp4 {
    public static int SIZE = 4000000;
    public static boolean[] chk = new boolean[SIZE];
    public static ArrayList<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        aratos();

        int ans = findCumulativePrimeNumber(n);

        System.out.println(ans);
    }
    public static int findCumulativePrimeNumber(int n){
        int start = 0;
        int end = 1;
        int ans = 0;

        long[] cumuArr = new long[primeList.size()+1];
        for (int i = 1; i < cumuArr.length; i++) {
            cumuArr[i] = cumuArr[i-1] + primeList.get(i-1);
        }

        while(start <= end && end <= primeList.size()){
            long tmp = cumuArr[end] - cumuArr[start];
            if(tmp == n){
                ans++;
                end++;
            }else if(tmp < n){
                end++;
            }else{
                start++;
            }
        }

        return ans;
    }

    public static void aratos(){
        chk[0] = chk[1] = true;
        for (int i = 2; i*i <= SIZE ; i++) {
            if(!chk[i]){
                for (int j = i*i; j < SIZE; j += i) {
                    chk[j] = true;
                }
            }
        }

        for (int i = 2; i < SIZE; i++) {
            if(!chk[i]){
                primeList.add(i);
            }
        }
    }
}

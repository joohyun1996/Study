package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 12015

/**
 * 가장 긴 증가하는 순열(LIS) 문제를 n*n 의 경우 시간복잡도가 너무 증가해 못풀게 되었을 때 어떻게 풀것이냐? 하고 물어보는 문제
 * 이진탐색을 통해 풀어야 하는데, 어디에 이진탐색을 적용할 것이냐? 가 관전포인트
 * 새로운 개념이 필요했다. 바로 이중 포문을 사용하는 것이 아니라 반복을 한번만 써서 이전 숫자보다 이후 숫자가 더 작으면 이전 숫자를 대치하는 방법으로
 * 그때 이진탐색이 필요하다. arr[0]과 arr[n] 사이의 숫자 중 대치할 숫자를 찾기 위해서
 * 따라서 이후 숫자가 큰 경우 그냥 chk를 증가시키고 배열에 추가해준다(증가하는 순열이 맞음)
 * 아니면 이차원 탐색을 통해 교체해야할 자리를 찾고 해당 숫자를 넣어준다
 * 그러면 완성!
 */
public class bs7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arr = new int[n];
        arr[0] = input[0];

        int chk = 1;

        for (int i = 1; i < n; i++) {
            if(arr[chk-1] < input[i]){
                chk += 1;
                arr[chk-1] = input[i];
            }else{
                int start = 0;
                int end = chk;
                int middle = 0;
                while(start < end){
                    middle = (start + end) / 2;
                    if(arr[middle] < input[i]){
                        start = middle + 1;
                    }else{
                        end = middle;
                    }
                }
                arr[start] = input[i];
            }
        }

        System.out.println(chk);
    }
}

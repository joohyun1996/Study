package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// boj 1450

/**
 * meet in the middle 알고리즘 사용 후 투포인터를 사용해 총합이 넘지 않는 경우만 합치기
 * 솔직히 투 포인터만 가지고 풀려 하니 너무 어려워서 못 풀었다.
 * meet in the middle 알고리즘은 mergesort와 상당히 유사한 분할정복 알고리즘이니 알아두자.
 * 부분집합의 합을 구하는 과정을 나는 이중반복문으로 해결하려 했는데, 그게 아니라 DFS를 써서 index번째 요소가 첨가될때/아닐때를 나누어서 생각해야 한다.
 */
public class tp5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int things = inputs[0];
        long bagSize = inputs[1];
        int[] thingsWeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(thingsWeight);

        System.out.println(meetInTheMiddle(bagSize, thingsWeight));
    }

    public static long meetInTheMiddle(long bagSize, int[] thingsWeight){
        int middle = thingsWeight.length / 2;
        int ans = 0;

        int[] left = Arrays.copyOfRange(thingsWeight, 0, middle);
        int[] right = Arrays.copyOfRange(thingsWeight, middle, thingsWeight.length);

        ArrayList<Long> leftSubsetSum = new ArrayList<>();
        ArrayList<Long> rightSubsetSum = new ArrayList<>();

        calcSubsetSum(left, 0, 0, leftSubsetSum);
        calcSubsetSum(right, 0, 0, rightSubsetSum);

        Collections.sort(leftSubsetSum);
        Collections.sort(rightSubsetSum);

        return twoPointer(leftSubsetSum, rightSubsetSum, bagSize);
    }

    public static void calcSubsetSum(int[] arr, int index, long currSum, ArrayList<Long> list){
        if(index == arr.length){
            list.add(currSum);
            return;
        }
        calcSubsetSum(arr, index+1, currSum, list);
        calcSubsetSum(arr, index+1, currSum + arr[index], list);
    }

    public static long twoPointer(ArrayList<Long> left, ArrayList<Long> right, long weight){
        int start = 0;
        int end = right.size()-1;
        long ans = 0;

        while(start < left.size() && end >= 0){
            if(left.get(start) + right.get(end) <= weight){
                ans += end + 1;
                start++;
            }else{
                end--;
            }
        }

        return ans;
    }
}

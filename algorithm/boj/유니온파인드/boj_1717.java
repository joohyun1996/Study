package unionFind;

import java.io.*;
import java.util.Arrays;

// boj_1717

/**
 * 유니온 파인드를 어떻게 푸는가에 대한 가장 기초적인 문제
 * 일단 배열을 하나 만들어서 각 배열의 인덱스는 부모의 인덱스를 담게 한다(초기값은 자기 자신)
 * 그리고 입력을 받으면 부모의 인덱스를 찾는다
 * 그리고 부모의 rank를 담는 배열을 하나 더 만들어서 부모의 rank가 같으면 두 집합을 하나로 합쳐주고 한쪽의 랭크를 올린후, 부모로 만든다.
 * 해당 과정을 반복해주면 어떤것들이 집합화 되있고 어떤것이 아닌지 배열의 인덱스를 통해 알 수 있다.
 */
public class uf1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];

        int[] arr = new int[n+1];
        int[] rank = new int[n+1];
        Arrays.fill(rank, 1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int first = findParent(tmp[1], arr);
            int second = findParent(tmp[2], arr);

            if(tmp[0] == 0){
                if(rank[first] > rank[second]){
                    arr[second] = first;
                }else if(rank[first] < rank[second]){
                    arr[first] = second;
                }else{
                    arr[second] = first;
                    rank[first] += 1;
                }
            }else{
                if(first == second){
                    bw.write("YES" + "\n");
                }else{
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }


    public static int findParent(int x, int[] arr){
        if(arr[x] != x){
            arr[x] = findParent(arr[x], arr);
        }
        return arr[x];


        /* 시간복잡도 증가시키는 쓰레기코드
        int tmp = arr[x];
        if(tmp == x){
            return x;
        }else{
            return findParent(findParent(tmp, arr), arr);
        }*/
    }
}

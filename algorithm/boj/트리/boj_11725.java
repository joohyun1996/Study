package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// boj 11725

/**
 * dfs로 부모와 자식관계를 정립하는 문제
 * 그런데 나는 그냥 dfs로 풀었지, 트리의 개념을 딱히 적용하진 않았다. 배열로 부모의 노드를 적은게 전부
 * 사실 1부터 시작하는거니 1로 시작을 잡으면 1부터 시작하는 부모를 찾을수 있는건 맞다.
 */
public class tree01 {
    static boolean[] chk;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        chk = new boolean[n + 1];
        arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            list.get(tmp[0]).add(tmp[1]);
            list.get(tmp[1]).add(tmp[0]);
        }

        dfs(list, 1);
        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> list, int start){
        if(start == list.size()){
            return;
        }

        ArrayList<Integer> tmpList = list.get(start);
        for (Integer i : tmpList) {
            if(!chk[i]){
                chk[i] = true;
                arr[i] = start;
                dfs(list, i);
            }
        }
    }
}

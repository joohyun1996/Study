package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// boj 14889
// 백트래킹. 그런데, 개념 자체를 잡는게 중요했다. 결국 1이 항상 포함되야 한다는것, 그리고 n/2가 되면 멈춰서 계산해야 한다는것
// 그게 핵심이다.
public class Backtracking8 {
    static ArrayList<Integer> positiveList = new ArrayList<>();
    static ArrayList<Integer> negativeList = new ArrayList<>();
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] map = new int [n][n];
        boolean[] chk = new boolean[n];
        chk[0] = true;

        String[] strs;

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        dfs(map, chk, 1, 1, n); // 1만 조사하면 되므로, 1을 시작 깊이로 넣어준다.

        System.out.println(minDifference);
    }
    public static void dfs(int[][] map, boolean[] chk, int depth, int start, int n){ // depth = 깊이, start = 시작지점 (1,3) (1,4)
        if(depth == n/2){
            for (int i = 0; i < n; i++) {
                if(chk[i]) positiveList.add(i+1); // 양팀의 리스트 구하기
                else negativeList.add(i+1);
            }
            calc(map);
            positiveList.clear();
            negativeList.clear();
            return;
        }

        for (int i = start; i < n; i++) { // 백트래킹
            if(chk[i] == false){
                chk[i] = true;
                dfs(map, chk, depth+1, i+1,  n);
                chk[i] = false;
            }
        }
    }

    public static void calc(int[][] map){
        int posSum = 0;
        int negSum = 0;

        for (int i = 0; i < positiveList.size(); i++) {
            for (int j = 0; j < positiveList.size(); j++) {
                if(i!=j){
                    posSum += map[positiveList.get(i)-1][positiveList.get(j)-1]; // 리스트의 값을 더한다. [1,2] [2,1]
                }
            }
        }
        for (int i = 0; i < negativeList.size(); i++) {
            for (int j = 0; j < negativeList.size(); j++) {
                if(i!=j){
                    negSum += map[negativeList.get(i)-1][negativeList.get(j)-1]; // 마찬가지로 [3,4] , [4,3] 의 값을 더한다
                }
            }
        }

        if(Math.abs(posSum-negSum) < minDifference) minDifference = Math.abs(posSum-negSum); // 최솟값 계산
    }
}

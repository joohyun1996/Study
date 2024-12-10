package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 16928

/**
 * bfs를 사용해서 푸는 문제.
 * 사실 문제 자체가 엄청 어려운건 아닌데, 설명이 부족해서 오래걸렸다. 나는 뱀처럼 맵을 만들고 계산해야 하는 줄 알고 엄청 오래 생각했는데 알고보니 1...10 11...20 이런식이엇다.
 * 따라서 그냥 모든 경우의 수 bfs 로 반복돌리면 됨. 끝!
 */
public class gt12 {
    static int[][] graph = new int[10][10];
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], 0);
            for (int j = 0; j < 10; j++) {
                graph[i][j] = i * 10 + j + 1;
            }
        }


        for (int i = 0; i < n+m; i++) {
            int[] tmps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = (tmps[0] -1)/ 10;
            int y = (tmps[0] -1) % 10;

            graph[x][y] = tmps[1];
        }

        bfs();
        System.out.println(map[9][9]);
    }
    public static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);
        while(!queue.isEmpty()){
            int n = queue.poll();

            int x = n / 10;
            int y = n % 10;

            for (int i = 1; i <= 6; i++) {
                int tmp = n + i;
                if(tmp >= 100) return;

                int tmpX = (graph[tmp / 10][tmp % 10] - 1) / 10;
                int tmpY = (graph[tmp / 10][tmp % 10] - 1) % 10;

                if(tmpX >= 0 && tmpX < 10 && tmpY >= 0 && tmpY < 10 && map[tmpX][tmpY] == 0){
                   map[tmpX][tmpY] = map[x][y] + 1;
                   queue.add(graph[tmpX][tmpY] - 1);
                }
            }
        }
    }
}

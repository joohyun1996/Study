package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 1260

/**
 * dfs, bfs를 쓸 줄 아시나요? 하고 물어보는 기초 문제
 */
public class gt06 {
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];
        int v = inputs[2];

        chk = new boolean[n+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(list[0]).add(list[1]);
            graph.get(list[1]).add(list[0]);
        }

        for (ArrayList<Integer> integerArrayList : graph) {
            Collections.sort(integerArrayList);
        }
        dfs(graph, v);
        Arrays.fill(chk, false);
        System.out.println();
        bfs(graph, v);

    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int start){
        ArrayList<Integer> depthList = graph.get(start);
        chk[start] = true;
        System.out.printf(start + " ");

        for (Integer i : depthList) {
            if(!chk[i]){
                dfs(graph, i);
            }
        }
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int start){
        Deque<Integer> queue = new ArrayDeque<>();
        chk[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int tmp = queue.pollFirst();
            ArrayList<Integer> list = graph.get(tmp);
            System.out.printf(tmp + " ");
            for (Integer i : list) {
                if(!chk[i]){
                    chk[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

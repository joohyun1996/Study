package graphAndTraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// boj 2606

/**
 * dfs를 사용하는 기초적인 문제. BFS로도 충분히 풀 수 있다. 하지만 dfs를 사용해서 풀었음.
 */
public class gt05 {
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vortex = Integer.parseInt(br.readLine().trim());
        int edge = Integer.parseInt(br.readLine().trim());
        int ans = -1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        chk = new boolean[vortex+1];

        for (int i = 0; i <= vortex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        dfs(graph, 1);

        for (boolean b : chk) {
            if(b) ans++;
        }

        System.out.println(ans);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int start){
        chk[start] = true;

        ArrayList<Integer> currGraph = graph.get(start);

        for (Integer i : currGraph) {
            if(!chk[i]){
                dfs(graph, i);
            }
        }
    }
}

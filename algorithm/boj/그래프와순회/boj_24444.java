package graphAndTraversal;

import java.io.*;
import java.util.*;

// boj 24444

/**
 * 이전 문제에서 재귀(dfs)로 풀었던 문제를 반복(queue or deque)로 풀어보는 문제.
 * 덱을 사용한다는것을 기억해서 풀면 크게 어렵지 않다.
 */
public class gt03 {
    static int depth = 1;
    static int[] ansArr;
    static boolean[] chkArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int r = Integer.parseInt(strs[2]);

        ansArr = new int[n+1];
        chkArr = new boolean[n+1];
        Arrays.fill(ansArr, 0);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        bfs(graph, r);

        for (int i = 1; i <= n; i++) {
            bw.write(ansArr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int start){
        if(graph.get(start).isEmpty()){
            ansArr[start] = depth;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        chkArr[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int tmp = queue.pollFirst();
            ansArr[tmp] = depth;
            for (Integer i : graph.get(tmp)) {
                if(!chkArr[i]){
                    chkArr[i] = true;
                    queue.add(i);
                }
            }
            depth++;
        }
    }
}

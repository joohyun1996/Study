package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

// boj 1707

/**
 * dfs로 푸는줄 알았는데 bfs로 풀어야 하는 문제
 * 그래프가 끊어지는 경우를 생각해야 하는데, 그러지 못해서 오래걸렸다.
 * 또한 끊어지는 경우를 생각하기위해 중간에서 그 끊어진 부분을 담당하는 함수를 만들어 주어야 했다.
 */
public class gt14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < num; i++) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int vortex = inputs[0];
            int edge = inputs[1];

            for (int j = 0; j <= vortex; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < edge; j++) {
                int[] connection = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.get(connection[0]).add(connection[1]);
                list.get(connection[1]).add(connection[0]);
            }

            if(isBipharate(vortex, list)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean isBipharate(int v, ArrayList<ArrayList<Integer>> list){
        int[] color = new int[v+1];
        Arrays.fill(color,-1);

        for (int i = 1; i <= v; i++) {
            if(color[i] == -1){
                if(!bfs(i, color, list)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfs(int v, int[] color, ArrayList<ArrayList<Integer>> list){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);
        color[v] = 1;

        while(!deque.isEmpty()){
            int tmp = deque.pollFirst();
            ArrayList<Integer> tmpList = list.get(tmp);

            for (Integer i : tmpList) {
                if(-1==color[i]){
                    deque.add(i);
                    color[i] = 1 - color[tmp];
                }else if(color[tmp] == color[i]){
                    return false;
                }
            }
        }
        return true;
    }

}

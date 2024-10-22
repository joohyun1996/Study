package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 13305

/**
 * 내가 방문한 노드 (0번은 무조건 방문하니까) 중 가장 작은 노드를 기억하고, 해당 노드보다 다음에 방문할 노드가 더 크면 이전 최솟값 노드에 엣지의 길이를 곱한다
 * 그렇지 않고 다음에 방문할 노드가 더 작다면, 해당 노드값을 최솟값으로 잡고, 엣지의 길이를 곱한다.
 * 다만 곱한값이 오버플로우가 발생할 수 있으므로, long을 사용하도록 하자
 */
public class gd5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] vortex = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long ans = (long)vortex[0] * edge[0];
        long low = vortex[0];

        for (int i = 1; i < vortex.length-1; i++) {
            if(vortex[i] > low){
                ans += low * edge[i];
            }else{
                ans += (long)vortex[i] * edge[i];
                low = vortex[i];
            }
        }

        System.out.println(ans);
    }
}

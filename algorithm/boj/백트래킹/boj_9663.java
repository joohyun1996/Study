package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 9663
// N-Queens
// 가장 중요한것은 백트래킹 과정에서 사용되는 isPromising() 함수를 구현할 때, 가로 || 대각선 중 겹치는 게 있으면 false를 반환해야 한다는 것
// 다만 대각선은 Math.abs(row[n] - row[i]) == n - i 로 확인할 수 있다.(가로 == 세로 면 대각선임)
public class Backtracking5 {
    static boolean[] chk = new boolean[16];
    static int[] row = new int[16];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        Arrays.fill(row,0);

        queen(0, n);
        System.out.println(ans);
    }
    public static void queen(int depth, int n){
        if (depth == n){
            ++ans;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!chk[i]){
                row[depth] = i;
                if(isPromising(depth)){
                    chk[i] = true;
                    queen(depth+1, n);
                    chk[i] = false;
                }
            }
        }
    }

    public static boolean isPromising(int depth){
        for (int i = 0; i < depth; i++) {
            if(row[depth] == row[i] || Math.abs(row[depth] - row[i]) == depth - i){
                return false;
            }
        }
        return true;
    }
}

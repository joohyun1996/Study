package divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2630

/**
 * 분할정복 기초문제
 * 1) 맵 전체 체크
 * 2) 아니면 부분별 체크
 * 2-1) 부분은 각 4사분면마다 체크
 * 3-1) 만약 한개 사분면이 모두 같은 숫자면 +1
 * 3-2) 아니면 4사분면으로 또 나누어서 재귀
 * 4) 반복
 */
public class dc1 {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divideAndConquer(0,0,n);
        System.out.printf(blue + "\n" + white + "\n");
    }

    public static void divideAndConquer(int row, int col, int n){
        if(chk(row, col, n)) {
            if(arr[row][col] == 0){
                blue += 1;
            }else{
                white += 1;
            }
            return;
        }

        int k = n/2;
        divideAndConquer(row, col, k);
        divideAndConquer(row, col + k, k);
        divideAndConquer(row + k, col, k);
        divideAndConquer(row+k, col+k, k);
    }

    public static boolean chk(int row, int col, int n){
        int color = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}

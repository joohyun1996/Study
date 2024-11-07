package divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1992

/**
 * 이분탐색으로 배열에서 전체 배열이 전부 같은 값으로 이루어져 있으면 출력, 아니면 재귀
 * 그런데 같은 순서는 한번에 출력되어야 하므로 return에 한번에 (1,2,3,4) 번을 출력해줘야 한다.
 * 그거 제외하고는 크게 어렵지 않았음
 */
public class dc2 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        arr = new int [n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(divide(0,0, n));
    }


    public static String divide(int row, int col, int n){
        if(chk(row,col,n)){
            return String.valueOf(arr[row][col]);
        }

        int k = n/2;
        String first = divide(row, col, k);
        String second = divide(row, col + k, k);
        String third = divide(row + k, col, k);
        String fourth = divide(row + k, col + k, k);

        return "(" + first + second + third + fourth + ")";
    }
    public static boolean chk(int row, int col, int n){
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if(arr[i][j] != arr[row][col]){
                    return false;
                }
            }
        }
        
        return true;
    }
}

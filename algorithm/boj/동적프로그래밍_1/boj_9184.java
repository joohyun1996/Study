package dp_first;

import java.io.*;

// boj 9184

/**
 *  기본적인 점화식을 이용한 dp 문제. 배열을 이용하여 메모리를 아끼고, 재귀를 사용하지 않아서 속도를 더 빠르게 한다.
 *  다만 배열 선언을 동적으로 해서, 메모리 크기를 잡아놓고 계산하면 메모리 초과 문제도 해결할 수 있다.
 */
public class dp02 {
    static int[][][] map = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if(i == 0 || j == 0 || k == 0){
                        map[i][j][k] = 1;
                    }else if(i < j && j < k){
                        map[i][j][k] = map[i][j][k-1] + map[i][j-1][k-1] - map[i][j-1][k];
                    }else{
                        map[i][j][k] = map[i-1][j][k] + map[i-1][j-1][k] + map[i-1][j][k-1] - map[i-1][j-1][k-1];
                    }
                }
            }
        }

        while(true){
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ")" + " = " + dp(a,b,c) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int dp(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }else if(a > 20 || b > 20 || c > 20) {
            return map[20][20][20];
        }else{
            return map[a][b][c];
        }
    }
}

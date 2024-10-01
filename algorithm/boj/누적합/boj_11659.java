package cumulativeSum;

// 시간초과 33퍼
// 2차원 맵으로 하면 메모리 초과
// boj 11659

/**
 * 누적합을 구하는 문제
 * 당연히 2차원 배열을 쓰면 안된다. 또한 2차원 맵으로 풀어보려 했는데, 그러면 100000 * 100000 사이즈의 배열이 되서 메모리가넘친다
 * 그래서 1차원 배열에 매번 arr[i] 값을 증가 시킨 값을 더한다. 그리고 f(end)-f(start-1)을 해준다
 * 그러면 start, start+1, ..., end 의 합을 구할 수 있게 된다.
 */
import java.io.*;
import java.util.Arrays;
public class cs1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int start;
        int end;

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cs = new int[arr.length+1];

        for (int i = 1; i <= arr.length; i++) {
            cs[i] = cs[i-1] + arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");

            start = Integer.parseInt(strs[0]);
            end = Integer.parseInt(strs[1]);

            bw.write((cs[end] - cs[start-1]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

/*  2차원 배열로 풀었는데, 틀림

        strs = br.readLine().split(" ");
        int[] arr = new int[strs.length+1];
        arr[0] = 0;
        for (int i = 1; i <= strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i-1]);
        }
        int[][] map = new int[arr.length+1][arr.length+1];

        for (int i = 1; i < arr.length; i++) {
            map[i][i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(j > i){
                    map[i][j] = map[i][j-1] + arr[j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            start = Integer.parseInt(strs[0]);
            end = Integer.parseInt(strs[1]);

            bw.write(map[start][end] + "\n");
        }*/

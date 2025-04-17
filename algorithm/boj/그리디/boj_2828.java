package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj_2828

/**
 * 바구니는 하나만 움직이는게 아니라 통채로 움직여야 한다
 */
public class gd6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim()) - 1;
        }

        int start = 0;
        int end = m-1;

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if(!(arr[i] <= end && arr[i] >= start)){
                int left = Math.abs(arr[i] - start);
                int right = Math.abs(arr[i] - end);

                if(left > right){
                    cnt += arr[i] - end;
                    start = arr[i] - (m-1);
                    end = arr[i];
                }else{
                    cnt += Math.abs(arr[i] - start);
                    end = arr[i] + (m-1);
                    start = arr[i];
                }
            }
        }
        System.out.println(cnt);
    }
}

package sort;

import java.io.*;
import java.util.Arrays;

// boj 10989

/**
 * list.sort() 와 arrays.sort() 의 차이를 기억해야함
 * list.sort()는 timesort를 사용해서 추가 메모리를 사용하지만
 * arrays.sort() 는 double pivot quicksort 를 사용해서 직접 메모리를 수정하기 때문에 메모리를 더 적게쓴다.
 * 따라서 메모리가 터질것 같으면 list 말고 arrays.sort() 사용하기!
 */
public class Sort05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(arr).sorted().forEach(i -> {
            try{
                bw.write(i + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        bw.flush();
        bw.close();
    }
}

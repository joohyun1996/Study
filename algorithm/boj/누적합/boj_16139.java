package cumulativeSum;

import java.io.*;

// boj 16139

/**
 * 문장의 누적된 알파벳을 구하는 문제
 * 나는 맨 처음에 특정 하나의 문자만 누적합을 구해 정답을 출력하는것을 N 번 반복하려 했으나, 해당 식은 오답임
 * 따라서 모든 알파벳의 누적합을 계산한 후, 출력만 반복적으로 하면 된다.
 * 누적합 계산시 x축은 알파벳의 순서, y축은 주어진 문자열을 의미한다.
 * 따라서 누적합 계산을 좌->우 로 하는것이 아니라 상->하로 누적합 계산을 해야한다
 * 마찬가지로 정답 출력시에도 하-상 의 값을 출력해 줘야 한다
 */
public class cs3 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = " " + br.readLine().trim();
        String[] strs;

        arr = new int[26][str.length()+1];

        int n = Integer.parseInt(br.readLine().trim());
        int start, end;

        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                arr[j][i] = arr[j][i-1];
            }
            arr[str.charAt(i)- 'a'][i] += 1;
        }

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            char c = strs[0].charAt(0);
            start = Integer.parseInt(strs[1])+1;
            end = Integer.parseInt(strs[2])+1;

            bw.write(arr[c-'a'][end] - arr[c-'a'][start-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

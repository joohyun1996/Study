package complex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// boj 2108
// 산술평균 구할 때 type check 잘하기
// 최빈값 구할때 여러번 나누어서 풀기
public class CP04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[8001];
        Arrays.fill(arr, 0);

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            list.add(tmp);
            ++arr[tmp+4000];
        }



        int medium = (int) Math.round((double) list.stream().reduce((a,b) -> a+b).get() / list.size());
        int middle = list.stream().sorted().collect(Collectors.toList()).get(list.size()/2);

        int freq = Arrays.stream(arr).max().getAsInt();
        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == freq) freqList.add(i - 4000);
        }

        int secondFreq = 0;
        if(freqList.size() == 1) secondFreq = freqList.get(0);
        else secondFreq = freqList.get(1);

        int start = list.stream().sorted().collect(Collectors.toList()).get(0);
        int end = list.stream().sorted().collect(Collectors.toList()).get(list.size()-1);

        int size = end - start;

        bw.write(medium + "\n");
        bw.write(middle + "\n");
        bw.write(secondFreq + "\n");
        bw.write(size + "\n");

        bw.flush();
        bw.close();
    }
}

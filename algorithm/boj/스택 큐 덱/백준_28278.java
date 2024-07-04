package StackDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// boj 28278
// ArrayList로 스택 구현
// BufferedWriter를 써야 시간초과가 안나는 문제
public class SDQ01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            if(1 == Integer.parseInt(strs[0])){
                ansList.add(Integer.parseInt(strs[1]));
            } else if (2 == Integer.parseInt(strs[0])) {
                if(ansList.size() == 0){
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(ansList.get(ansList.size()-1) + "\n");
                ansList.remove(ansList.size()-1);
            } else if (3 == Integer.parseInt(strs[0])) {
                bw.write(ansList.size()+"\n");
            } else if (4 == Integer.parseInt(strs[0])) {
                if(ansList.size() == 0){
                    bw.write(1 + "\n");
                }else{
                    bw.write(0 + "\n");
                }
            }else{
                if(ansList.size() == 0){
                    bw.write(-1 + "\n");
                }else{
                    bw.write(ansList.get(ansList.size()-1) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}

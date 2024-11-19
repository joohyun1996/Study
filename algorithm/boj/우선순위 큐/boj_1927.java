package priorityQueue;

import java.io.*;
import java.util.PriorityQueue;

// boj 1927

/**
 * 이전 문제와 같지만 오름차순이냐 내림차순이냐의 차이만 있는 문제
 */
public class pq2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            if(tmp == 0){
                if (priorityQueue.size() == 0){
                    bw.write(0 + "\n");
                }else{
                    bw.write(priorityQueue.poll() + "\n");
                }
            }else{
                priorityQueue.add(tmp);
            }
        }

        bw.flush();
        bw.close();
    }
}

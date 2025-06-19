package bruteforce;

import java.io.*;
import java.util.Arrays;

// boj 10709

/**
 * 그냥 무난히 쉬운 구현문제
 */
public class Bruteforce09 {
    static char[][] map;
    static int[][] ansMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = inputs[0];
        int w = inputs[1];

         map = new char[h][w];
         ansMap = new int[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(ansMap[i], -1);
        }

        findCloudMovement(h,w);
        printCloudMovement(h,w);
    }
    public static void printCloudMovement(int h, int w) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(ansMap[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void findCloudMovement(int h, int w){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(map[i][j] == 'c'){
                    ansMap[i][j] = 0;
                }else{
                    if(j > 0 && ansMap[i][j-1] != -1){
                        ansMap[i][j] = ansMap[i][j-1] + 1;
                    }
                }
            }
        }
    }
}

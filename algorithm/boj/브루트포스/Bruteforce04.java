package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1018

/**
 * bfs인줄 알았는데 사실 그냥 무작정 풀어야 했던 문제.
 * if-else if-else로 풀었지만 그냥 8*8 보드를 그려서 푸는게 더 좋아보인다
 */
public class Bruteforce04 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int answer = 987654321;

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().trim().toCharArray();
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                answer = Math.min(answer, Math.min(white(i,j), black(i,j)));
            }
        }
        System.out.println(answer);
    }
    public static int white(int x,int y){
        int tmp = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if(i % 2 == 0 && j % 2 == 0){
                    if(board[i][j] != 'W') tmp++;
                }else if(i % 2 != 0 && j % 2 == 0){
                    if(board[i][j] != 'B') tmp++;
                }else if(i % 2 == 0 && j % 2 != 0){
                    if(board[i][j] != 'B') tmp++;
                }else{
                    if(board[i][j] != 'W') tmp++;
                }
            }
        }
        return tmp;
    }
    public static int black(int x,int y){
        int tmp = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if(i % 2 == 0 && j % 2 == 0){
                    if(board[i][j] != 'B') tmp++;
                }else if(i % 2 != 0 && j % 2 == 0){
                    if(board[i][j] != 'W') tmp++;
                }else if(i % 2 == 0 && j % 2 != 0){
                    if(board[i][j] != 'W') tmp++;
                }else{
                    if(board[i][j] != 'B') tmp++;
                }
            }
        }
        return tmp;
    }
}

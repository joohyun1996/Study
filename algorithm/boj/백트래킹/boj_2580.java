package backtracking;

import java.io.*;
import java.util.ArrayList;

// boj 2580
public class Backtracking6 {
    static int[][] map = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(br.readLine().split(" "));
        }

        for (int i = 0; i < 9; i++) {
            String[] strs = list.get(i);
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }
        sudoku(0,0);
    }

    public static void sudoku(int row, int col) throws IOException {
        if (col == 9){ // 한 행의 모든열 검사한 경우 다음열로
            sudoku(row+1, 0);
            return;
        }

        if (row == 9){ // 모든 행렬을 다 본 경우 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }

        // 만약 0이 있는 경우, 해당 자리에 1~9까지 넣어보고, 맞으면 진행 틀리면 돌아옴
        if (map[row][col] == 0){
            for (int i = 1; i <= 9; i++) {
                if(isPromising(row,col,i)){ // 백트래킹 수행 지점 (맞는지 아닌지 검사)
                    map[row][col] = i;
                    sudoku(row,col+1);
                    map[row][col] = 0;
                }
            }
            return;
        }
        sudoku(row, col+1);
    }

    public static boolean isPromising(int row, int col, int curr){
        for (int i = 0; i < 9; i++) {
            if(map[row][i] == curr){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(map[i][col] == curr){
                return false;
            }
        }

        int set_X = (row / 3) * 3;
        int set_Y = (col / 3) * 3;

        for (int i = set_X; i < set_X+3; i++) {
            for (int j = set_Y; j < set_Y+3; j++) {
                if(map[i][j] == curr){
                    return false;
                }
            }
        }
        return true;
    }
}

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex02 {
    static List<Integer> dfsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int number = Integer.valueOf(str.split(" ")[0]);
        int limit = Integer.valueOf(str.split(" ")[1]);

        dfs(number, limit);
    }

    public static void dfs(int number, int limit){
        if(dfsList.size() == limit){
            for (Integer i : dfsList) {
                System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < number; i++) {
            if(!dfsList.contains(i)){
                dfsList.add(i);
                dfs(number, limit);
                dfsList.remove(Integer.valueOf(i));
            }
        }
    }
}

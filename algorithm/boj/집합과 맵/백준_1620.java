package set_map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// boj 1626

/**
 * List를 사용하거나 Map에 입력을 한번만 받고 해당 Map의 EntrySet을 구해 풀려하면 시간복잡도가 나는 문제
 * 어차피 Map의 Key를 통해 Value를 구하거나 Value를 통해 Key를 구할 것 같으면
 * 둘다 입력시키고 한번에 찾는게 더 빠르다
 */
public class SetMap04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int size = Integer.parseInt(strs[0]);
        int exam = Integer.parseInt(strs[1]);

        Map<String, String> pokeMap = new HashMap<>();

        for (int i = 1; i <= size; i++) {
            String str = br.readLine();
            pokeMap.put(str, Integer.toString(i));
            pokeMap.put(Integer.toString(i), str);
        }

        for (int i = 0; i < exam; i++) {
            bw.write(pokeMap.get(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}

package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// boj 2751
// Stream.sorted() 를 사용해야하는건 동일하다
// 하지만 System.out.println() 을 쓰면 시간초과가 발생하고 BufferedWriter를 써줘야 발생하지 않는다.
// Buffer에 저장했다가 한번에 출력해주기 때문에 훨씬 빠르다
public class Sort04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        /*for (Integer i : list.stream().sorted().collect(Collectors.toList())) {
            System.out.println(i);
        }*/
        list.stream().sorted().forEach(i->{
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

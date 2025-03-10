package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


// boj 9935

/**
 * 이 문제는 스택을 쓰는데 문자열로 풀면 시간초과가 발생하니 Deque을 써서 시간복잡도를 줄였어야 하는 문제
 * 그런데 Deque을 쓰면 정확한 순서를 비교하기 힘드므로 해당 과정을 캐릭터를 잘 뺐다 넣었다 해주어야 한다
 */
public class st1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().trim();
        String bomb = br.readLine().trim();
        int bombLen = bomb.length();

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : str.toCharArray()){
            deque.addLast(c);

            if(deque.size() >= bomb.length()){
                boolean chk = true;
                char[] tmp = new char[bombLen];
                int count = 0;

                for (int i = 0; i < bombLen; i++){
                    tmp[i] = deque.removeLast();
                    count++;
                    if(tmp[i] != bomb.charAt(bombLen -1 -i)){
                        chk = false;
                        break;
                    }
                }

                if(!chk) {
                    for (int i = count - 1; i >= 0; i--){
                        deque.addLast(tmp[i]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}

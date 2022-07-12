//Wouldn't it make more sense to leave the queue after buying the last ticket rather than rejoining and realizing that you don't have to buy another ticket 

import java.util.*;
import java.io.*;

public class cowcert {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cows = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < cows; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long time = 0;
        while (queue.peek() != 0) {
            for (int i = 0, originalSize = queue.size(); i < originalSize; i++) {
                if (queue.peek() == 0) {
                    queue.poll();
                }
                else {
                    queue.add(queue.poll() - 1);
                }
                time++;
            }
        }
        System.out.println(time);
    }
}

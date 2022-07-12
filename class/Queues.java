import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public String construct(String input) {
        Queue<Character> queue = new LinkedList<Character>();
        String ret = "";
        char curr;
        for (int i = 0; i < input.length(); i++) {
            curr = input.charAt(i);
            if (queue.size() == 0 || queue.peek() != curr) {
                queue.add(curr);
            }
            else {
                queue.poll();
            }

            ret += queue.size() == 0 ? "#" : queue.peek();
        }
        return ret;
    }
}

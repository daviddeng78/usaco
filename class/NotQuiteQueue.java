import java.util.Stack;

public class NotQuiteQueue {
    Stack<String> s1, s2;

    public NotQuiteQueue() {
        s1 = new Stack<String>();
        s2 = new Stack<String>();
    }

    public void push(String x) {
        s1.push(x);
    }

    public String pop() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        if (s1.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public String peek() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        if (s1.isEmpty()) {
            return s2.peek();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

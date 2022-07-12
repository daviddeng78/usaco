import java.util.Stack;

class Node {
    String val;
    Node next;

    public Node(String val) {
        this.val = val;
        next = null;
    }

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedList {
    Node head;

    public void delete(Node input) {
        input.val = input.next.val;
        input.next = input.next.next;
    }

    //for testing purposes
    public String toString() {
        String ret = "";
        Node temp = head;
        while (temp != null) {
            ret += temp.val + " -> ";
            temp = temp.next;
        }
        ret += "null";
        return ret;
    }

    public boolean isPalindrome() {
        Stack<String> s = new Stack<String>();
        Node temp = head;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < s.size(); i++) {
            if (!s.pop().equals(temp.val)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
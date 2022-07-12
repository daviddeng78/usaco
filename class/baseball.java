import java.io.*;
import java.util.*;

public class baseball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operations = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        String operators = "+DC";
        String symbol;
        for (int i = 0; i < operations; i++) {
            symbol = tokenizer.nextToken();
            if (operators.contains(symbol)) {
                switch (symbol) {
                    case "+": 
                        int temp = stack.pop();
                        int sum = stack.peek() + temp;
                        stack.push(temp);
                        stack.push(sum);
                        break;
                    case "D":
                        stack.push(2 * stack.peek());
                        break;
                    case "C":
                        stack.pop();
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(symbol));
            }
        }

        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
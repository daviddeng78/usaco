import java.util.Stack;

public class Stacks {
    public boolean isMatched(String input) {
        String open = "([{";
        String matched = "()[]{}";
        Stack<String> stack = new Stack<String>();

        String symbol;
        for (int i = 0; i < input.length(); i++) {
            symbol = input.substring(i, i + 1);
            if (open.contains(symbol)) {
                stack.push(symbol);
            }
            else {
                symbol = stack.pop() + symbol;
                if (!matched.contains(symbol)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public double evaluatePostfix(String equation) {
        Stack<Double> stack = new Stack<Double>();
        String[] components = equation.split("\\s");
        
        String operations = "+-*/";
        double a;
        double b;
        for (String component : components) {
            if (operations.contains(component)) {
                b = stack.pop();
                a = stack.pop();
                switch (component) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push((double) a / b); break;
                }
            }
            else {
                stack.push(Double.parseDouble(component));
            }
        }
        return stack.pop();
    }
}

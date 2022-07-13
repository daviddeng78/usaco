import java.io.*;
import java.util.*;

public class abcs {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        ArrayList<Integer> values = new ArrayList<Integer>();
        Integer a = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int next = Integer.parseInt(st.nextToken());
            values.add(next);
            if (next < a) {
                a = next;
            }
        }
        values.remove(a);

        Integer b = values.stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);
        values.remove(b);

        int total = values.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        int c = total - a - b;
        System.out.println(a + " " + b + " " + c);
    }
}

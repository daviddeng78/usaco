import java.io.*;
import java.util.*;

public class feeding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int intervals = Integer.parseInt(br.readLine());

        String interval;
        StringTokenizer tokenizer;
        int start;
        int end;

        int[] currentInterval;
        int[][] intervalList = new int[intervals][2];

        for (int i = 0; i < intervals; i++) {
            interval = br.readLine();
            tokenizer = new StringTokenizer(interval);

            start = Integer.parseInt(tokenizer.nextToken());
            end = Integer.parseInt(tokenizer.nextToken());

            currentInterval = new int[2];
            currentInterval[0] = start;
            currentInterval[1] = end;

            intervalList[i] = currentInterval;
        }

        Arrays.sort(intervalList, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Stack<int[]> stack = new Stack<int[]>();

        stack.push(intervalList[0]);
        
        int[] previous;
        for (int i = 1; i < intervals; i++) {
            previous = stack.peek();

            if (previous[1] < intervalList[i][0]) {
                stack.push(intervalList[i]);
            }
            else if (previous[1] < intervalList[i][1]) {
                previous[1] = intervalList[i][1];
                stack.pop();
                stack.push(previous);
            }
        }

        int[] merged;
        while (!stack.isEmpty()) {
            merged = stack.pop();
            System.out.println(merged[0] + " " + merged[1]);
        }
    }
}

import java.io.*;
import java.util.*;

public class team {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int problems = Integer.parseInt(in.readLine());

        int implementations = 0;
        for (int i = 0; i < problems; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int answer = 0;
            while (st.hasMoreTokens()) {
                answer += Integer.parseInt(st.nextToken());
                if (answer >= 2) {
                    implementations++;
                    break;
                }
            }
        }
        System.out.println(implementations);
    }
}
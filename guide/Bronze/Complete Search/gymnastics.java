import java.io.*;
import java.util.*;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int sessions = Integer.parseInt(st.nextToken());
        int cows = Integer.parseInt(st.nextToken());

        HashSet<Better> masterList = new HashSet<Better>();

        for (int i = 0; i < sessions; i++) {
            HashSet<Better> sessionList = new HashSet<Better>();
            StringTokenizer sessionInfo = new StringTokenizer(in.readLine());
            int[] a = new int[cows];
            for (int j = 0; j < cows; j++) {
                a[j] = Integer.parseInt(sessionInfo.nextToken());
            }

            for (int j = 0; j < cows - 1; j++) {
                for (int k = j + 1; k < cows; k++) {
                    Better performance = new Better();
                    performance.a = a[j];
                    performance.b = a[k];
                    if (i == 0) {
                        masterList.add(performance);
                    }
                    sessionList.add(performance);
                }
            }
            for (Iterator<Better> it = masterList.iterator(); it.hasNext();) {
                boolean found = false;
                Better performance = it.next();
                for (Better sessionPerformance : sessionList) {
                    if (sessionPerformance.equals(performance)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    it.remove();
                }
            }
        }
        out.println(masterList.size());
        out.close();
    }

    static class Better { //int a better than b
        int a, b;

        @Override
        public boolean equals(Object o) {
            Better performance = (Better) o;
            return a == performance.a && b == performance.b;
        }
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

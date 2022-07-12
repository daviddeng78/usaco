import java.io.*;
import java.util.*;

public class shuffle {
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
    
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
    
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
    
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) throws IOException {
        Kattio in = new Kattio("shuffle");
        int cows = in.nextInt();

        int[] shuffleOrder = new int[cows];
        for (int i = 0; i < cows; i++) {
            shuffleOrder[i] = in.nextInt();
        }

        int[] order = new int[cows];
        for (int i = 0; i < cows; i++) {
            order[i] = in.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            int[] temp = new int[order.length];
            for (int j = 0; j < order.length; j++) {
                temp[j] = order[shuffleOrder[j] - 1];
            }
            order = temp;
        }

        for (int x : order) {
            in.println(x);
        }
        in.close();
    }
}
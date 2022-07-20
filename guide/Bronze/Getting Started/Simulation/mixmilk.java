import java.util.*;
import java.io.*;

public class mixmilk {
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
        int[] capacity = new int[3];
        int[] milk = new int[3];

        Kattio in = new Kattio("mixmilk");

        for (int i = 0; i < 3; i++) {
            capacity[i] = in.nextInt();
            milk[i] = in.nextInt();
        }

        for (int pours = 0; pours < 100; pours++) {
            int pitcher_in = pours % 3;
            int pitcher_out = (pours + 1) % 3;

            int amount = Math.min(capacity[pitcher_out] - milk[pitcher_out], milk[pitcher_in]);
            milk[pitcher_in] -= amount;
            milk[pitcher_out] += amount;
        }

        for (int i : milk) {
            in.println(i);
        }
        in.close();
    }
}
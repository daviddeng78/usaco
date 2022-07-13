import java.io.*;
import java.util.*;

public class promote {
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
        Kattio in = new Kattio("promote");

        int bronzeB = in.nextInt();
        int bronzeE = in.nextInt();

        int silverB = in.nextInt();
        int silverE = in.nextInt();

        int goldB = in.nextInt();
        int goldE = in.nextInt();

        int platB = in.nextInt();
        int platE = in.nextInt();

        in.println(platE + goldE + silverE - (platB + goldB + silverB));
        in.println(platE + goldE - (platB + goldB));
        in.println(platE - platB);
        in.close();
    }
}

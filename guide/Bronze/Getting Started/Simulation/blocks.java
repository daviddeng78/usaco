import java.io.*;
import java.util.*;

public class blocks {
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
        Kattio io = new Kattio("blocks");

        int boards = io.nextInt();

        String[] side1 = new String[boards];
        String[] side2 = new String[boards];

        for (int i = 0; i < boards; i++) {
            side1[i] = io.next();
            side2[i] = io.next();
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < boards; i++) {
                count += Math.max(side1[i].length() - side1[i].replaceAll(String.valueOf(c), "").length(), side2[i].length() - side2[i].replaceAll(String.valueOf(c), "").length());
            }
            io.println(count);
        }
        io.close();
    }
}

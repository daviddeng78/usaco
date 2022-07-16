// Java y-axis is inverted
// Empty rectangles do not return an area of 0

import java.awt.*;
import java.io.*;
import java.util.*;

public class billboard {
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
        Kattio io = new Kattio("billboard");
        int b1blx = io.nextInt(); int b1bly = io.nextInt();
        int b1trx = io.nextInt(); int b1try = io.nextInt();

        Rectangle b1 = new Rectangle(b1blx, -b1try, b1trx - b1blx, b1try - b1bly);

        int b2blx = io.nextInt(); int b2bly = io.nextInt();
        int b2trx = io.nextInt(); int b2try = io.nextInt();

        Rectangle b2 = new Rectangle(b2blx, -b2try, b2trx - b2blx, b2try - b2bly);

        int tblx = io.nextInt(); int tbly = io.nextInt();
        int ttrx = io.nextInt(); int ttry = io.nextInt();

        Rectangle t = new Rectangle(tblx, -ttry, ttrx - tblx, ttry - tbly);

        io.println(area(b1) + area(b2) - area(b1.intersection(t)) - area(b2.intersection(t)));
        io.close();
    }

    public static int area(Rectangle r) {
        return r.isEmpty() ? 0 : r.width * r.height;
    }
}
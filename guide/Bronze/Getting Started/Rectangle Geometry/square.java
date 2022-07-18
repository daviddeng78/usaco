import java.awt.*;
import java.io.*;
import java.util.*;

public class square {
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
        Kattio io = new Kattio("square");

        int lowerLeftX1 = io.nextInt(); int lowerLeftY1 = io.nextInt();
        int upperRightX1 = io.nextInt(); int upperRightY1 = io.nextInt();

        Rectangle r1 = new Rectangle(lowerLeftX1, -upperRightY1, upperRightX1 - lowerLeftX1, upperRightY1 - lowerLeftY1);

        int lowerLeftX2 = io.nextInt(); int lowerLeftY2 = io.nextInt();
        int upperRightX2 = io.nextInt(); int upperRightY2 = io.nextInt();

        Rectangle r2 = new Rectangle(lowerLeftX2, -upperRightY2, upperRightX2 - lowerLeftX2, upperRightY2 - lowerLeftY2);

        Rectangle union = r1.union(r2);
        io.println(union.width > union.height ? union.width * union.width : union.height * union.height);
        io.close();
    }
}

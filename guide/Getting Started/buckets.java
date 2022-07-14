import java.io.*;
import java.util.*;

public class buckets {
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
        Kattio in = new Kattio("buckets");

        int barnr, barnc, laker, lakec, rockr, rockc;
        barnr = barnc = laker = lakec = rockr = rockc = 0;
        for (int i = 0; i < 10; i++) {
            String line = in.next();
            if (line.contains("B") || line.contains("L") || line.contains("R")) {
                for (int j = 0; j < 10; j++) {
                    if (line.charAt(j) == 'B') {barnr = i; barnc = j;}
                    if (line.charAt(j) == 'L') {laker = i; lakec = j;}
                    if (line.charAt(j) == 'R') {rockr = i; rockc = j;}
                }
            }
        }

        int barnToLake = Math.abs(barnr - laker) + Math.abs(barnc - lakec);
        int barnToRock = Math.abs(barnr - rockr) + Math.abs(barnc - rockc);
        int rockToLake = Math.abs(rockr - laker) + Math.abs(rockc - lakec);

        in.println((barnr == laker || barnc == lakec) && barnToLake == barnToRock + rockToLake ? barnToLake + 1 : barnToLake - 1);
        in.close();

    }
}
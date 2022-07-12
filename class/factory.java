import java.io.*;
import java.util.*;

public class factory {
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
        Kattio in = new Kattio("factory");
        int connections = in.nextInt();

        int[] start = new int[101];
        for (int i = 0; i < connections - 1; i++) {
            start[in.nextInt()]++;
            in.nextInt();
        }

        int answer = -1;
        for (int i = 1; i <= connections; i++) {
            if (start[i] == 0) {
                if (answer > 1) {answer = -1; break;}
                if (answer == -1) {answer = i;}
            }
        }
        in.println(answer);
        in.close();
    }
}

import java.io.*;
import java.util.*;

public class shell {
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
        Kattio io = new Kattio("shell");

        int swaps = io.nextInt();
        
        int[] swap1Col = new int[swaps];
        int[] swap2Col = new int[swaps];
        int[] guessCol = new int[swaps];

        for (int i = 0; i < swaps; i++) {
            swap1Col[i] = io.nextInt();
            swap2Col[i] = io.nextInt();
            guessCol[i] = io.nextInt();
        }

        int answer = 0;
        for (int i = 1; i <= 3; i++) {
            int score = 0;
            int shell = i;
            for (int j = 0; j < swaps; j++) {
                if (shell == swap1Col[j]) {
                    shell = swap2Col[j];
                }
                else if (shell == swap2Col[j]) {
                    shell = swap1Col[j];
                }
                score += shell == guessCol[j] ? 1 : 0;
            }
            answer = Math.max(score, answer);
        }
        io.println(answer);
        io.close();
    }
}

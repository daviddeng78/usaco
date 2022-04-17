/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: ddeng071
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
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
        Kattio in = new Kattio("ride");

        String comet = in.next();
        String group = in.next();

        int cometProd = 1;
        for (int i = 0; i < comet.length(); i++) {
            cometProd *= comet.charAt(i) - 64;
        }

        int groupProd = 1;
        for (int i = 0; i < group.length(); i++) {
            groupProd *= group.charAt(i) - 64;
        }

        in.println(groupProd % 47 == cometProd % 47 ? "GO" : "STAY");
        in.close();
    }
}

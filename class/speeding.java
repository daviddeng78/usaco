import java.io.*;
import java.util.*;

public class speeding {
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
        Kattio in = new Kattio("speeding");
        int roadSections = in.nextInt();
        int bessieSections = in.nextInt();
        
        int[] road = new int[100];
        int[] bessie = new int[100];
        int miles;
        int speed;

        int roadTotalMiles = 0;
        for (int i = 0; i < roadSections; i++) {
            miles = in.nextInt();
            speed = in.nextInt();
            for (int j = 0; j < miles; j++, roadTotalMiles++) {
                road[roadTotalMiles] = speed;
            }
        }

        int bessieTotalMiles = 0;
        for (int i = 0; i < bessieSections; i++) {
            miles = in.nextInt();
            speed = in.nextInt();
            for (int j = 0; j < miles; j++, bessieTotalMiles++) {
                bessie[bessieTotalMiles] = speed;
            }
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (bessie[i] - road[i] > max) {
                max = bessie[i] - road[i];
            }
        }

        in.println(max);
        in.close();
    }
}
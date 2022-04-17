/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: ddeng071
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class friday {
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
        Kattio in = new Kattio("friday");
        int years = in.nextInt();

        int[] occurences = new int[7];

        int startDay = 1;
        for (int i = 1900; i < 1900 + years; i++) {
            for (int j = 1; j <= 12; j++) {
                occurences[(startDay + 12) % 7]++;
                if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12) {
                    startDay += 31;
                }
                else if (j == 4 || j == 6 || j == 9 || j == 11) {
                    startDay += 30;
                }
                else if (j == 2 && isLeapYear(i)) {
                    startDay += 29;
                }
                else {
                    startDay += 28;
                }
            }
            startDay %= 7;
        }
        
        int[] shifted = new int[occurences.length];
        shifted[0] = occurences[occurences.length - 1];
        for (int i = 0; i < occurences.length - 1; i++) {
            shifted[i + 1] = occurences[i];
        }

        for (int i = 0; i < shifted.length - 1; i++) {
            in.print(shifted[i] + " ");
        }
        in.print(shifted[shifted.length - 1] + "\n");
        in.close();
    }

    static boolean isLeapYear(int years) {
        return years % 4 == 0 && years % 100 == 0 && years % 400 == 0 || years % 4 == 0 && !(years % 100 == 0);
    }
}
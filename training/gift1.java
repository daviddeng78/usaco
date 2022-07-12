/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: ddeng071
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class gift1 {
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
        Kattio in = new Kattio("gift1");
        HashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        int members = in.nextInt();

        for (int i = 0; i < members; i++) {
            hm.put(in.next(), 0);
        }

        String giver;
        int amt;
        int receivers;
        String receiver;
        for (int i = 0; i < members; i++) {
            giver = in.next();
            amt = in.nextInt();
            receivers = in.nextInt();

            if (receivers != 0) {
                hm.replace(giver, hm.get(giver) - amt + amt % receivers);

                for (int j = 0; j < receivers; j++) {
                    receiver = in.next();
                    hm.replace(receiver, hm.get(receiver) + amt / receivers);
                }
            }
        }

        hm.entrySet().forEach(entry -> {
            in.println(entry.getKey() + " " + entry.getValue());
        });
        in.close();
    }
}

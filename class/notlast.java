import java.io.*;
import java.util.*;

public class notlast {
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
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Bessie", 0);
        hm.put("Elsie", 0);
        hm.put("Daisy", 0);
        hm.put("Gertie", 0);
        hm.put("Annabelle", 0);
        hm.put("Maggie", 0);
        hm.put("Henrietta", 0);
        
        Kattio in = new Kattio("notlast");
        int entries = in.nextInt();
        String cow;
        for (int i = 0; i < entries; i++) {
            cow = in.next();
            hm.replace(cow, hm.get(cow) + in.nextInt());
        }

        int min = Integer.MAX_VALUE;
        for (int value : hm.values()) {
            if (value < min) {
                min = value;
            }
        }

        int secondMin = Integer.MAX_VALUE;
        for (int value : hm.values()) {
            if (value < secondMin && value > min) {
                secondMin = value;
            }
        }

        boolean alreadySecondMinimum = false;
        String returnCow = "Tie";
        for (String key : hm.keySet()) {
            if (hm.get(key) == secondMin) {
                if (alreadySecondMinimum) {
                    returnCow = "Tie";
                    break;
                }
                else {
                    returnCow = key;
                    alreadySecondMinimum = true;
                }
            }
        }
        in.println(returnCow);
        in.close();
    }
}
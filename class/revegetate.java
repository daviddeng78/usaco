import java.io.*;
import java.util.*;

public class revegetate {
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
        Kattio in = new Kattio("revegetate");
        int pastures = in.nextInt();
        int cows = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < cows; i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<Integer>(Arrays.asList(second)));
            }
            else {
                graph.get(first).add(second);
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<Integer>(Arrays.asList(first)));
            }
            else {
                graph.get(second).add(first);
            }
        }
        
        HashMap<Integer, Integer> grassTypes = new HashMap<Integer, Integer>();
        for (int i = 1; i <= pastures; i++) {
            if (graph.get(i) == null) {in.print(1); continue;}
            int j;
            for (j = 1; j <= 4; j++) {
                boolean allowed = true;
                for (Integer pasture : graph.get(i)) {
                    if (grassTypes.get(pasture) != null && grassTypes.get(pasture) == j) {
                        allowed = false;
                    }
                }
                if (allowed) {break;}
            }
            grassTypes.put(i, j);
            in.print(j);
        }
        in.println();
        in.close();
    }
}

import java.awt.Rectangle;
import java.util.*;
import java.io.*;

public class billboardBlocked {
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
        Kattio io = new Kattio("billboard");

        int lawnmowerLLX = io.nextInt(); int lawnmowerLLY = io.nextInt();
        int lawnmowerTRX = io.nextInt(); int lawnmowerTRY = io.nextInt();

        Rectangle lawnmower = new Rectangle(lawnmowerLLX, -lawnmowerTRY, lawnmowerTRX - lawnmowerLLX, lawnmowerTRY - lawnmowerLLY);

        int cowLLX = io.nextInt(); int cowLLY = io.nextInt();
        int cowTRX = io.nextInt(); int cowTRY = io.nextInt();

        Rectangle cow = new Rectangle(cowLLX, -cowTRY, cowTRX - cowLLX, cowTRY - cowLLY);

        int pointsContained = 0;
        if (cow.contains(lawnmower.x, lawnmower.y)) {pointsContained++;}
        if (cow.contains(lawnmower.x + lawnmower.width, lawnmower.y)) {pointsContained++;}
        if (cow.contains(lawnmower.x, lawnmower.y + lawnmower.height)) {pointsContained++;}
        if (cow.contains(lawnmower.x + lawnmower.width, lawnmower.y + lawnmower.height)) {pointsContained++;}

        if (pointsContained == 4) {
            io.println(0);
        }
        else if (pointsContained >= 2) {
            io.println(area(lawnmower) - area(lawnmower.intersection(cow)));
        }
        else {
            io.println(area(lawnmower));
        }
        io.close();
    }

    public static int area(Rectangle r) {
        return r.width * r.height;
    }
}

import java.io.*;
import java.util.*;

public class tttt {
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
        Kattio in = new Kattio("tttt");
        char[][] board = new char[3][3];

        String line;
        for (int i = 0; i < 3; i++) {
            line = in.next();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int first = 0;
        for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            if (board[0][0] == c1 && board[0][0] == board[1][1] && board[0][0] ==  board[2][2]) {
                first += 1;
            }

            else if (board[0][2] == c1 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                first += 1;
            }
            else {
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == c1 && board[i][0] == board[i][1] && board[i][0] == board[i][2] ) {
                        first += 1;
                        break;
                    }
                    else if (board[0][i] == c1 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                        first += 1;
                        break;
                    }
                }
            }
        }

        int second = 0;
        for (char c1 = 'A'; c1 < 'Z'; c1++) {
            for (char c2 = (char) (c1 + 1); c2 <= 'Z'; c2++) {
                if (checkTwo(board[0][0], board[1][1], board[2][2], c1, c2)) {
                    second += 1;
                }
                else if (checkTwo(board[0][2], board[1][1], board[2][0], c1, c2)) {
                    second += 1;
                }
                else {
                    for (int i = 0; i < 3; i++) {
                        if (checkTwo(board[i][0], board[i][1], board[i][2], c1, c2)) {
                            second += 1;
                            break;
                        }
                        else if (checkTwo(board[0][i], board[1][i], board[2][i], c1, c2)) {
                            second += 1;
                            break;
                        }
                    }
                }
            }
        }

        in.println(first);
        in.println(second);
        in.close();
    }

    static boolean checkTwo(char c1, char c2, char c3, char a, char b) {
        return !((c1 != a && c1 != b) ||
                (c2 != a && c2 != b) ||
                (c3 != a && c3 != b) ||
                (a != c1 && a != c2 && a != c3) ||
                (b != c1 && b != c2 && b != c3)
                );
    }
}

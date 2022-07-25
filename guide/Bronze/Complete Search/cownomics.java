import java.io.*;
import java.util.*;

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new FileWriter("cownomics.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> spotty = new ArrayList<String>();
        ArrayList<String> plain = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            spotty.add(in.readLine());
        }
        for (int i = 0; i < n; i++) {
            plain.add(in.readLine());
        }

        int locations = 0;
        for (int i = 0; i < m; i++) {
            HashSet<Character> spottyGenes = new HashSet<Character>();
            HashSet<Character> plainGenes = new HashSet<Character>();

            for (String sequence : spotty) {
                spottyGenes.add(sequence.charAt(i));
            }
            for (String sequence : plain) {
                plainGenes.add(sequence.charAt(i));
            }

            if (Collections.disjoint(spottyGenes, plainGenes)) {
                locations++;
            }
        }
        out.println(locations);
        out.close();
    }
}

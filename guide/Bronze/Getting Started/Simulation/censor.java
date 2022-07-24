import java.io.*;
import java.util.*;

public class censor { 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new FileWriter("censor.out"));
        String s = in.readLine();
        String censored = in.readLine();

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i);
            if (result.length() >= censored.length() && result.substring(result.length() - censored.length()).equals(censored)) {
                result = result.substring(0, result.length() - censored.length());
            }
        }
        out.println(result);
        out.close();
    }
}

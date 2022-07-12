import java.io.*;
import java.util.*;

public class year {
    static String[] yearKey = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    static HashMap<String, Integer> hm;

    public static void main(String[] args) throws IOException {
        hm = new HashMap<String, Integer>();
        hm.put("Bessie", 0);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sentences = Integer.parseInt(in.readLine());

        String[] sentence;
        for (int i = 0; i < sentences; i++) {
            sentence = in.readLine().split("\\s");
            hm.put(sentence[0], move(sentence[3].equals("next"), sentence[4], sentence[7]) + hm.get(sentence[7]));
        }
        System.out.println(((int) Math.abs(hm.get("Elsie"))));
    }

    static int move(boolean forward, String targetYear, String oldCow) {
        int change = forward ? 1 : -1;
        int years = 0;
        int index = Math.floorMod(hm.get(oldCow), 12);
        do {
            index += change;
            if (index == 12) {index = 0;}
            if (index == -1) {index = 11;}
            years++;
        } while (!yearKey[index].equals(targetYear));
        return forward ? years : -years;
    }
}

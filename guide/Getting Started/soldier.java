import java.io.*;
import java.util.*;

public class soldier {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int origPrice = Integer.parseInt(st.nextToken());
        int balance = Integer.parseInt(st.nextToken());
        int bananas = Integer.parseInt(st.nextToken());

        int totalCost = (int) (bananas/2.0 * (bananas + 1) * origPrice);
        System.out.println(totalCost > balance ? totalCost - balance : 0);
    }
}

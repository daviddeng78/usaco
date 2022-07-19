import java.io.*;
import java.util.*;

public class twoTables {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(in.readLine());

        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long width = Long.valueOf(st.nextToken());
            long height = Long.valueOf(st.nextToken());

            st = new StringTokenizer(in.readLine());
            long firstBLX = Long.valueOf(st.nextToken()); long firstBLY = Long.valueOf(st.nextToken());
            long firstTRX = Long.valueOf(st.nextToken()); long firstTRY = Long.valueOf(st.nextToken());

            long firstWidth = firstTRX - firstBLX; long firstHeight = firstTRY - firstBLY;

            st = new StringTokenizer(in.readLine());
            long secondWidth = Long.valueOf(st.nextToken());
            long secondHeight = Long.valueOf(st.nextToken());


            long answer = Long.MAX_VALUE;
            //find minimum vertical and horizontal distance
            if (firstWidth + secondWidth <= width) {
                answer = Math.min(Math.max(0, secondWidth - firstBLX), Math.max(0, firstTRX - (width - secondWidth)));
            }
            if (firstHeight + secondHeight <= height) {
                answer = Math.min(answer, Math.min(Math.max(0, secondHeight - firstBLY), Math.max(0, firstTRY - (height - secondHeight))));
            }
            
            System.out.println(answer == Long.MAX_VALUE ? -1 : Double.valueOf(answer));

        }
    }
}
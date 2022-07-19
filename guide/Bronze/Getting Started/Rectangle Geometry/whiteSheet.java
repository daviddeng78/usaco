import java.io.*;
import java.util.*;
import java.awt.Rectangle;
 
public class whiteSheet {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(in.readLine());
        int whiteBLX = Integer.parseInt(st.nextToken()); int whiteBLY = Integer.parseInt(st.nextToken());
        int whiteTRX = Integer.parseInt(st.nextToken()); int whiteTRY = Integer.parseInt(st.nextToken());
        Rectangle white = new Rectangle(whiteBLX, -whiteTRY, whiteTRX - whiteBLX, whiteTRY - whiteBLY);
 
        st = new StringTokenizer(in.readLine());
        int black1BLX = Integer.parseInt(st.nextToken()); int black1BLY = Integer.parseInt(st.nextToken());
        int black1TRX = Integer.parseInt(st.nextToken()); int black1TRY = Integer.parseInt(st.nextToken());
        Rectangle black1 = new Rectangle(black1BLX, -black1TRY, black1TRX - black1BLX, black1TRY - black1BLY);
 
        st = new StringTokenizer(in.readLine());
        int black2BLX = Integer.parseInt(st.nextToken()); int black2BLY = Integer.parseInt(st.nextToken());
        int black2TRX = Integer.parseInt(st.nextToken()); int black2TRY = Integer.parseInt(st.nextToken());
        Rectangle black2 = new Rectangle(black2BLX, -black2TRY, black2TRX - black2BLX, black2TRY - black2BLY);
 
        long totalArea = 0;
        if (white.intersects(black1)) {
            totalArea += area(white.intersection(black1));
        }
        if (white.intersects(black2)) {
            totalArea += area(white.intersection(black2));
        }
        if (white.intersects(black1) && white.intersects(black2) && black1.intersects(black2)) {
            totalArea -= area(white.intersection(black1).intersection(white.intersection(black2)));
        }
        System.out.println(area(white) > totalArea ? "YES" : "NO");
    }
 
    public static long area(Rectangle r) {
        return Long.valueOf(Math.abs(r.width)) * Math.abs(r.height);
    }
}
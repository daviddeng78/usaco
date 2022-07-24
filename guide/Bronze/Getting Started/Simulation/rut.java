//more of an analysis as getting more than partials is really difficult
//implementation practice as solution is given in c++

import java.io.*;
import java.util.*;

public class rut {
    static int cows;
    static Cow[] cowInfo;
    static int INFINITY = 1000000001; //maximum coordinate as specified by problem

    public static int nextTime(int one, int two, int currentTime) {
        Cow northCow = cowInfo[one], eastCow = cowInfo[two];
        if (northCow.direction == eastCow.direction) {return INFINITY;}

        int northCowXCopy = northCow.x;
        int northCowYCopy = northCow.y; 
        int eastCowXCopy = eastCow.x;
        int eastCowYCopy = eastCow.y;
        if (northCow.direction == 'E') { //took a while to understand but this means that assuming the firstCow to always be moving north requires less following test cases
            //distance is preserved so no loss of generality. took a while to understand but visually shown here: https://www.desmos.com/calculator/xpeotswirz
            northCowXCopy = northCow.y;
            northCowYCopy = northCow.x;
            eastCowXCopy = eastCow.y;
            eastCowYCopy = eastCow.x;
        }

        if (eastCowYCopy <= northCowYCopy) {return INFINITY;}
        if (eastCow.timeStopped == INFINITY) {
            if (northCowXCopy < eastCowXCopy - currentTime || northCowXCopy >= eastCowXCopy + eastCowYCopy - northCowYCopy) {return INFINITY;} //assumes that the northbound cow is the only cow that can stop
        }
        else {
            if (northCowXCopy > eastCowXCopy || northCowXCopy < eastCowXCopy - eastCow.timeStopped) {return INFINITY;} //eastern cow intersected with some other cow
        }
        return currentTime + eastCowYCopy - northCowYCopy;
    }

    public static int skipToNextEvent(int currentTime) {
        int[] times = new int[cows];
        int minTime = INFINITY;

        for (int i = 0; i < cows; i++) {
            times[i] = INFINITY;
            if (cowInfo[i].timeStopped == INFINITY) {
                for (int j = 0; j < cows; j++) {
                    int timeOfCollision = nextTime(i, j, currentTime);
                    if (timeOfCollision < times[i]) {times[i] = timeOfCollision;}
                }
                if (times[i] < minTime) {minTime = times[i];}
            }
        }

        if (minTime == INFINITY) {return INFINITY;}

        for (int i = 0; i < cows; i++) {
            if (cowInfo[i].timeStopped == INFINITY) {
                if (cowInfo[i].direction == 'N') {cowInfo[i].y += (minTime - currentTime);}
                else {cowInfo[i].x += (minTime - currentTime);}
            }
            if (times[i] == minTime) {cowInfo[i].timeStopped = minTime;}
        }

        return minTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cows = Integer.parseInt(in.readLine());
        cowInfo = new Cow[cows];

        for (int i = 0; i < cows; i++) {
            st = new StringTokenizer(in.readLine());
            cowInfo[i] = new Cow();
            cowInfo[i].direction = st.nextToken().charAt(0);
            cowInfo[i].x = Integer.parseInt(st.nextToken()); cowInfo[i].y = Integer.parseInt(st.nextToken());
            cowInfo[i].timeStopped = INFINITY;
        }

        int currentTime = 0;

        do {currentTime = skipToNextEvent(currentTime);} while (currentTime != INFINITY);

        for (int i = 0; i < cows; i++) {
            if (cowInfo[i].timeStopped == INFINITY) {System.out.println("Infinity");}
            else {System.out.println(cowInfo[i].timeStopped);}
        }
    }

    static class Cow {
        char direction;
        int x, y;
        int timeStopped;
    }

    static int swap(int... args) { //really nice way of swapping two values
        return args[0];
    }
}
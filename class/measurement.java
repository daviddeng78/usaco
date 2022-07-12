import java.io.*;

public class measurement {
    public static void main(String[] args) throws IOException {
        int bessie = 7;
        int mildred = 7;
        int elsie = 7;

        BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new FileWriter("measurement.out"));

        int measurements = Integer.parseInt(in.readLine());
        String[] measurementDetails = new String[measurements];

        for (int i = 0; i < measurements; i++) {
            measurementDetails[i] = in.readLine();
        }

        int days = 0;
        boolean previousBessie = true;
        boolean previousElsie = true;
        boolean previousMildred = true;

        boolean currentBessie, currentElsie, currentMildred;

        String[] details;
        for (int day = 1; day <= 100; day++) {
            for (int i = 0; i < measurements; i++) {
                details = measurementDetails[i].split("\\s+");
                if (Integer.parseInt(details[0]) == day) {
                    if (details[1].equals("Mildred")) {
                        if (details[2].contains("+")) {
                            mildred += Integer.parseInt(details[2].substring(1));
                        }
                        else {
                            mildred -= Integer.parseInt(details[2].substring(1));
                        }
                    }
                    else if (details[1].equals("Bessie")) {
                        if (details[2].contains("+")) {
                            bessie += Integer.parseInt(details[2].substring(1));
                        }
                        else {
                            bessie -= Integer.parseInt(details[2].substring(1));
                        }
                    }
                    else {
                        if (details[2].contains("+")) {
                            elsie += Integer.parseInt(details[2].substring(1));
                        }
                        else {
                            elsie -= Integer.parseInt(details[2].substring(1));
                        }
                    }

                    int max = Math.max(mildred, Math.max(bessie, elsie));

                    currentBessie = bessie == max;
                    currentElsie = elsie == max;
                    currentMildred = mildred == max;

                    if (previousBessie != currentBessie || previousElsie != currentElsie || previousMildred != currentMildred) {
                        days++;
                    }
                    previousBessie = currentBessie;
                    previousElsie = currentElsie;
                    previousMildred = currentMildred;
                }
            }
        }
        out.println(days);
        out.close();
    }
}

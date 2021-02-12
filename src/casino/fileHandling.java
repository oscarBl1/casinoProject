package casino;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.PrintWriter;

public class fileHandling {

    static File file = new File("userData.txt");
    static String firstName;
    static String lastName;
    static int balance;

    public static void writeFile(String data) {
        try {

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

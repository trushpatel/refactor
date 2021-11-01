import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Runtime;

public class test {
private static void printStream(InputStream in) throws IOException {
    BufferedReader is = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = is.readLine()) != null) {
            System.out.println(line);
        }
}
public static void main(String args[]) {
    try {
        Runtime rt = Runtime.getRuntime();
        String[] cmd = {"sed -i \'\' \'s/\\bx\\b/y/g\' A.java"};
        Process proc = rt.exec(cmd);
        printStream(proc.getInputStream());
        System.out.println("Error : ");
        printStream(proc.getErrorStream());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}

import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Runtime;
import java.util.regex.*;

public class RiMrDriver {
    private static String name;
    private static String newName;

    public static void main(String[] args) {
        try {
            Scanner kb = new Scanner(System.in);

            System.out.println("Enter the original method name: ");
            name = kb.nextLine();

            System.out.println("Enter the new method name: ");
            newName = kb.nextLine();

            Runtime rt = Runtime.getRuntime();
            String [] cmd = {"/Users/trushpatel/refactor/methodSignature.sh"};
            Process p = rt.exec(cmd);
            printStream(p.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printStream(InputStream in) throws IOException {
        HashSet<String> hs = new HashSet<>();
        Pattern p = Pattern.compile("\\s*[()]\\s*");
        Matcher m;
        BufferedReader is = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = is.readLine()) != null) {
           // String [] elements = line.split(" ");
            String [] methodSig = line.split("\s*[_$A-Za-z][_$a-zA-Z0-9]*[(][a-zA-Z]*[)]");
            /*m = p.matcher();
            System.out.println(m.matches());
            for (int i = 0; i < elements.length; i++) {
                hs.add(elements[i]);
                System.out.println(elements[i]);
            }
            Pattern pa = Pattern.compile("\s*[_$A-Za-z][_$a-zA-Z0-9]*[(][a-zA-Z]*[)]+");
            for (int i = 0; i < methodSig.length; i++) {
               // System.out.println(pa.matcher(methodSig[i]).matches());
                  System.out.println(methodSig[i]);
            }*/
            System.out.println(Arrays.toString(methodSig));
        }
       // if (hs.contains(newName + "()")) System.out.println("Duplicate method");
       // System.out.println(hs.toString());
    }

    private static boolean validSig (String s) {
        Pattern p = Pattern.compile("\s*[_$A-Za-z][_$a-zA-Z0-9]*[(][a-zA-Z]*[)]+");
        return p.matcher(s).matches();
    }
}

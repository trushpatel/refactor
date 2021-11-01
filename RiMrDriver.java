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

            ArrayList<String> a1 = printStream(p.getInputStream());

            ArrayList<String> pTypes = new ArrayList<>();
            for (int i = 0; i < a1.size(); i++) {
                pTypes.add(parameterTypes(a1.get(i)));
            }
            System.out.println(pTypes);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList printStream(InputStream in) throws IOException {
        HashSet<String> hs = new HashSet<>();
        Pattern p = Pattern.compile("\\s*[()]\\s*");
        Matcher m;
        BufferedReader is = new BufferedReader(new InputStreamReader(in));
        String line;
        ArrayList<String> a = new ArrayList<>();
        while ((line = is.readLine()) != null) {
            a.add(line);
        }
        return a;
    }

    private static boolean validSig (String s) {
        Pattern p = Pattern.compile("\s*[_$A-Za-z][_$a-zA-Z0-9]*[(][a-zA-Z]*[)]+");
        return p.matcher(s).matches();
    }

    public static String parameterTypes(String input) {
         StringBuilder in = new StringBuilder();
         in.append(input);
         Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(in);
         StringBuilder s = new StringBuilder();
         while(m.find()) {
             s.append(m.group(1));
         }
         String [] a = s.toString().replaceAll(",", "").split(" ");
         StringBuilder paramTypes = new StringBuilder();
         for (int i = 0; i < a.length; i++) {
             if (i % 2 == 0) {
                 paramTypes.append(a[i]);
                 if (i < a.length - 2) {
                     paramTypes.append(", ");
                 }
              }
          }
          return paramTypes.toString();
          /*
          // Name
          Matcher m1 = Pattern.compile("([^\\(\\]*)[\\(\\)].*$").matcher(example);
          StringBuilder n = new StringBuilder();
          while(m1.find()) {
              n.append(m1.group(1));
          }
          System.out.println(n);
          */
     }
}

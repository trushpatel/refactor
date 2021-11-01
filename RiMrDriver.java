/* Account for RTP, CTP, Visibility */
/* Use tree for inheritance */
/* How to pass java class vars into a bash script (/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Runtime;
import java.util.regex.*;

public class RiMrDriver {
    private static String name;
    private static String newName;
    private static final char L_PAREN = '(';
    
    public static void main(String[] args) {
        try {
            Scanner kb = new Scanner(System.in);

            System.out.println("Enter the original method name: ");
            name = kb.nextLine();

            System.out.println("Enter the new method name: ");
            newName = kb.nextLine();
            if (validName(newName)) {

                Runtime rt = Runtime.getRuntime();
                String [] cmd = {"/Users/trushpatel/refactor/methodSignature.sh"};
                Process p = rt.exec(cmd);

                ArrayList<String> a1 = printStream(p.getInputStream());

                ArrayList<String> pTypes = new ArrayList<>();
                ArrayList<String> names = new ArrayList<>();
                for (int i = 0; i < a1.size(); i++) {
                    pTypes.add(methodParameterTypes(a1.get(i)));
                    names.add(methodName(a1.get(i)));
                }
                System.out.println(pTypes);
                System.out.println(names);
                
                replaceNames();
            } else {
                System.out.println("Method name is illegal");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList printStream(InputStream in) throws IOException {
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

    private static boolean validName (String s) {
        Pattern p = Pattern.compile("\s*[_$A-Za-z][_$a-zA-Z0-9]*");
        return p.matcher(s).matches();
    }

    private static String methodParameterTypes(String input) {
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
     }

     private static String methodName(String input){
         StringBuilder n = new StringBuilder();
         for (int i = 0; i < input.length(); i++) {
             if (input.charAt(i) == L_PAREN) {
                 break;
             }
             n.append(input.charAt(i));
         }
         return n.toString();
     }

    private static void replaceNames() throws IOException{
        Runtime rt = Runtime.getRuntime();
        String[] cmd = {"/Users/trushpatel/refactor/rename.sh"};
        Process proc = rt.exec(cmd);
        ArrayList<String> a3 = printStream(proc.getInputStream());
        System.out.println(a3.toString());
    }
}

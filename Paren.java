import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Runtime;
import java.util.regex.*;

class Paren {

    private static final char L_PAREN = '(';

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(name(input));
        System.out.println(parameterTypes(input));
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
    }

    public static String name(String input){
        // Name
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == L_PAREN) {
                break;
            }
            n.append(input.charAt(i));
        }
        return n.toString();
    }
}

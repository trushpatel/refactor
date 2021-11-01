import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Runtime;
import java.util.regex.*;

class Paren {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
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

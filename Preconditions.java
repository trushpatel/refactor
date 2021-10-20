import java.util.regex.*;
import java.util.*;
import java.lang.Runtime;
import java.io.*;

class Preconditions {

    /*public static boolean check () {
        if (pC1 && pC2 && pC3) return true;
        return false;
    }*/

    // The new name cannot be illegal

    private static boolean validName (String newName) {
        Pattern p = Pattern.compile("^[_$A-Za-z][_$a-zA-Z0-9]*+");
        return p.matcher(newName).matches();
    }

    // The target method cannot be a duplicate with any existing method after rename

    private static boolean methodSignature(String method1, String method2) {
    }
}

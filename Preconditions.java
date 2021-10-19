import java.util.regex.*;
import java.util.*;

class Preconditions {

    /*public static boolean check () {
        if (pC1 && pC2 && pC3) return true;
        return false;
    }*/

    // The new name cannot be illegal

    private static boolean pC1 (String newName) {
        Pattern p = Pattern.compile("^[_$A-Za-z][_$a-zA-Z0-9]*+");
        return p.matcher(newName).matches();
    }

    // The target method cannot be a duplicate with any existing method after rename

//    private static boolean pC2 () {}

    private static boolean methodSignature(String method1, String method2) {
        String [] a1 = method1.split(" ");
        String [] a2 = method2.split(" ");
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        return false;
    }

    public static void main(String[] args) {
        methodSignature("public void x()", "public void y()");
    }
    // Rename all overriding and overridden methods

    //private static boolean pC3 () {}
}

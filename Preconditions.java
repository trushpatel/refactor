import java.util.regex.*;

class Preconditions {

    // The new name cannot be illegal

    public static boolean pC1 (String newName) {
        Pattern p = Pattern.compile("^[_$A-Za-z][_$a-zA-Z0-9]*+");
        return p.matcher(newName).matches();
    }

    // The target method cannot be a duplicate with any existing method after rename

    public static boolean pC2 () {}

    public static boolean methodSignature(String method) {}

    // Rename all overriding and overridden methods

    public static boolean pC3 () {}
}

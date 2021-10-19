import java.util.regex.*;

class Preconditions {
    public static boolean pC1 (String newName) {
        Pattern p = Pattern.compile("^[_$A-Za-z][_$a-zA-Z0-9]*+");
        return p.matcher(newName).matches();
    }
}

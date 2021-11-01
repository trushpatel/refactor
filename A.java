public class A {
    public static void main (String[] args) {
        x("Hello", 1); y("Hello", 2);
    }
    public static void x(String s, int i) { System.out.println("x"); }
    public static void y(String s, int i) { System.out.println("y"); }
}

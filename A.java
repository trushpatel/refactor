/*

    Preconditions for RiMr:
        1. The new name cannot be illegal
        2. The target method cannot be duplicate with any existing method after rename
        3. An overriding/overridden method is not eligible for the target method (rename all overriding/overridden methods)

*/

public class A {
    private void x() {}
}

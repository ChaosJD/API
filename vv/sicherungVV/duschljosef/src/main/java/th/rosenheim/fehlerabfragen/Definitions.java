package th.rosenheim.fehlerabfragen;


public class Definitions {
    public final static int FALSE = -1;
    public final static int TRUE = 1;
    public final static int FALSE0 = 0;

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}

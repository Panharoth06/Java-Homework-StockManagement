package color;

public class Color {
    // ANSI escape codes
    private static final String RESET = "\u001B[0m";

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String BLACK = "\u001B[30m";
    private static final String GRAY = "\u001B[90m";

    public static String setRed(String text) {
        return RED + text + RESET;
    }
    public static String setGreen(String text) {
        return GREEN + text + RESET;
    }
    public static String setYellow(String text) {
        return YELLOW + text + RESET;
    }
    public static String setBlue(String text) {
        return BLUE + text + RESET;
    }
    public static String setPurple(String text) {
        return PURPLE + text + RESET;
    }
    public static String setCyan(String text) {
        return CYAN + text + RESET;
    }
    public static String setWhite(String text) {
        return WHITE + text + RESET;
    }
    public static String setBlack(String text) {
        return BLACK + text + RESET;
    }
    public static String setGray(String text) {
        return GRAY + text + RESET;
    }
}





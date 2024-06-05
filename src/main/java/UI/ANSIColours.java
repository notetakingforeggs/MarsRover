package UI;

import java.util.HashMap;
import java.util.Map;

public class ANSIColours {

    // text
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final Map<String, String> ANSI_COLOUR_MAP = new HashMap<>();
    static
    {
        ANSI_COLOUR_MAP.put("BLACK", ANSIColours.ANSI_BLACK);
        ANSI_COLOUR_MAP.put("GREEN", ANSIColours.ANSI_GREEN);
        ANSI_COLOUR_MAP.put("YELLOW", ANSIColours.ANSI_YELLOW);
        ANSI_COLOUR_MAP.put("BLUE", ANSIColours.ANSI_BLUE);
        ANSI_COLOUR_MAP.put("PURPLE", ANSIColours.ANSI_PURPLE);
        ANSI_COLOUR_MAP.put("CYAN", ANSIColours.ANSI_CYAN);
        ANSI_COLOUR_MAP.put("WHITE", ANSIColours.ANSI_WHITE);
    }


    // Background
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";


}

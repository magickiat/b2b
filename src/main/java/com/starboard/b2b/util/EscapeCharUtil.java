package com.starboard.b2b.util;

public class EscapeCharUtil {

    public String removeSpecialChar(String input) {
        if (input != null) {
            return input.replace("'", "").replace("\"", "").replace(" ", "_").replace(".", "_");
        }
        return "";
    }
}

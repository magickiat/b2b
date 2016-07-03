package com.starboard.b2b.util;

public class StringUtil {

    // http://stackoverflow.com/questions/4283351/how-to-replace-special-characters-in-a-string
    public static String removeSpecialChar(String data) {
        if (data != null) {
            return data.replaceAll("\\W", "");
        } else {
            return "";
        }
    }
}

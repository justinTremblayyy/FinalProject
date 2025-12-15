package util;

public class Util {

    /**
     * converts each word in a string to title case
     Assumes:
     * - Words are separated by spaces
     * - Extra spaces are collapsed to single spaces in output
     * @param str input string
     * @return title-cased string
     */
    public static String toTitleCase(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
            str = str.trim();

            String[] words = str.split(" ");

            StringBuilder sb = new StringBuilder();


        for (String word : words) {
            if (word.isEmpty()) continue;

            String lower = word.toLowerCase();
            char first = lower.charAt(0);
            String title = Character.toUpperCase(first) + (lower.length() > 1 ? lower.substring(1) : "");

            if (sb.length() > 0) sb.append(' ');
            sb.append(title);
        }
        return sb.toString();

    }
}

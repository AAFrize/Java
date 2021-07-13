public class ArabicNumerals {

    // является ли строка арабскими цифрами
    static boolean isParsable(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}

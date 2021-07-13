public class RomanNumerals {

    // перевод римских цифр в арабские
    static int fromRomanToInt(String string) {
        return switch (string) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new NumberFormatException("Числа не входят в заданный диапазон");
        };
    }

    // обратный перевод арабских цифр в римские
    static String fromIntToRoman(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            if (number == 100) {
                stringBuilder.append("C");
                number = number - 100;
            }
            else if (number >= 90) {
                stringBuilder.append("XC");
                number = number - 90;
            }
            else if (number >= 50) {
                stringBuilder.append("L");
                number = number - 50;
            }
            else if (number >= 40) {
                stringBuilder.append("XL");
                number = number - 40;
            }
            else if (number >= 10) {
                stringBuilder.append("X");
                number = number - 10;
            }
            else if (number == 9) {
                stringBuilder.append("IX");
                number = number - 9;
            }
            else if (number >= 5) {
                stringBuilder.append("V");
                number = number - 5;
            }
            else if (number == 4) {
                stringBuilder.append("IV");
                number = number - 4;
            }
            else {
                stringBuilder.append("I");
                number = number - 1;
            }
        }
        return stringBuilder.toString();
    }

    // является ли строка римскими цифрами
    static boolean isRoman(String string) {
        boolean roman = false;
        for (RomanNumber number : RomanNumber.values()) {
            // или лучше с equalsIgnoreCase?
            if (number.name().equals(string)) {
                roman = true;
                break;
            }
        }
        return roman;
    }

}

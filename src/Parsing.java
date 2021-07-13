import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parsing {
    private String stringForPars;

    public Parsing(String stringForPars) {
        this.stringForPars = stringForPars;
    }

    /* получаем числа и знак из строки в виде списка
    0 - 1-е число;
    1 - знак;
    2 - 2-е число
    */
    ArrayList<String> parsingString() {
        StringTokenizer st = new StringTokenizer(stringForPars, "/*+- ", true);
        ArrayList<String> parseData = new ArrayList<>();
        String element;
        while (st.hasMoreTokens()) {
            element = st.nextToken();
            if (!element.equals(" ")) parseData.add(element);
        }
        return parseData;
    }

    // получаем список с заданными числами
    ArrayList<Integer> numbers(ArrayList<String> parseData) {
        ArrayList<Integer> num = new ArrayList<>();
        if (isParsable(parseData.get(0)) != isParsable(parseData.get(2))) throw new NumberFormatException("Присутствуют не только арабские цифры");
        else if (isParsable(parseData.get(0))) {
            Calculator.isRoman = false;
            num.add(Integer.parseInt(parseData.get(0)));
            num.add(Integer.parseInt(parseData.get(2)));
            if ((num.get(0) < 1 || num.get(0) > 10) || (num.get(1) < 1 || num.get(1) > 10)) throw new NumberFormatException("Числа не входят в заданный диапазон");
        }
        else if (isRoman(parseData.get(0)) && isRoman(parseData.get(2))) {
            Calculator.isRoman = true;
            num.add(RomanNumerals.fromRomanToInt(parseData.get(0)));
            num.add(RomanNumerals.fromRomanToInt(parseData.get(2)));
        }
        else throw new NumberFormatException("Числа не входят в заданный диапазон или в строке содержатся буквы");
        return num;
    }

    // выполнение нужной операции
    int operationResult(ArrayList<String> parseData, int number1, int number2) {
        return switch (parseData.get(1)) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            case "*" -> number1 * number2;
            default -> throw new NumberFormatException("Ошибка знака операции, используйте '+', '-', '/', '*'.");
        };
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

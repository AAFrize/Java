import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Calculator {
    private static boolean isRoman = false;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = bufferedReader.readLine();
            ArrayList<String> arrayOfData = parsing(data);
            ArrayList<Integer> numbers = numbers(arrayOfData);
            String sign = operation(arrayOfData);
            int result = operation(sign, numbers.get(0),numbers.get(1));
            if (isRoman) System.out.println(fromIntToRoman(result));
            else System.out.println(result);
        }
        catch (IOException io) {
            System.out.println("IOException");
        }
    }
    // получаем числа и знак из строки в список
    private static ArrayList<String> parsing(String data) {
        StringTokenizer st = new StringTokenizer(data, "/*+- ", true);
        ArrayList<String> parseData = new ArrayList<>();
        String element;
        while (st.hasMoreTokens()) {
            element = st.nextToken();
            if (!element.equals(" ")) parseData.add(element);
        }
        return parseData;
    }
    // получаем массив чисел
    private static ArrayList<Integer> numbers(ArrayList<String> parseData) {
        ArrayList<Integer> num = new ArrayList<>();
        if (isParsable(parseData.get(0)) != isParsable(parseData.get(2))) throw new NumberFormatException("Присутствуют не только арабские цифры");
        else if (isParsable(parseData.get(0))) {
            isRoman = false;
            num.add(Integer.parseInt(parseData.get(0)));
            num.add(Integer.parseInt(parseData.get(2)));
            if ((num.get(0) < 1 || num.get(0) > 10) || (num.get(1) < 1 || num.get(1) > 10)) throw new NumberFormatException("Числа не входят в заданный диапазон");
        }
        else if (isRoman(parseData.get(0)) && isRoman(parseData.get(2))) {
        isRoman = true;
        num.add(fromRomanToInt(parseData.get(0)));
        num.add(fromRomanToInt(parseData.get(2)));
        }
        return num;
    }
    // определяем знак операции
    private static String operation(ArrayList<String> parseData){
        return parseData.get(1);
    }
    // является ли строка арабскими цифрами
    private static boolean isParsable(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    // является ли строка римскими цифрами
    private static boolean isRoman(String string) {
        boolean roman = false;
        for (RomanNumber number : RomanNumber.values()) {
        if (number.name().equals(string)) {
            roman = true;
            break;
        }
        }
        return roman;
    }
    // перевод римских цифр в арабские
    private static int fromRomanToInt(String string) {
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
    // выполнение нужной операции
    private static int operation(String sign, int number1, int number2) {
        return switch (sign) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            case "*" -> number1 * number2;
            default -> throw new NumberFormatException("Ошибка знака операции, используйте '+', '-', '/', '*'.");
        };
    }
    // обратный перевод арабских цифр в римские
    private static String fromIntToRoman(int number) {
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
}

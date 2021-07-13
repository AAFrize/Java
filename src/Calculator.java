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
            int result = operationResult(sign, numbers.get(0), numbers.get(1));
            if (isRoman) System.out.println(RomanNumerals.fromIntToRoman(result));
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
    // получаем массив двух чисел
    private static ArrayList<Integer> numbers(ArrayList<String> parseData) {
        ArrayList<Integer> num = new ArrayList<>();
        if (ArabicNumerals.isParsable(parseData.get(0)) != ArabicNumerals.isParsable(parseData.get(2))) throw new NumberFormatException("Присутствуют не только арабские цифры");
        else if (ArabicNumerals.isParsable(parseData.get(0))) {
            isRoman = false;
            num.add(Integer.parseInt(parseData.get(0)));
            num.add(Integer.parseInt(parseData.get(2)));
            if ((num.get(0) < 1 || num.get(0) > 10) || (num.get(1) < 1 || num.get(1) > 10)) throw new NumberFormatException("Числа не входят в заданный диапазон");
        }
        else if (RomanNumerals.isRoman(parseData.get(0)) && RomanNumerals.isRoman(parseData.get(2))) {
        isRoman = true;
        num.add(RomanNumerals.fromRomanToInt(parseData.get(0)));
        num.add(RomanNumerals.fromRomanToInt(parseData.get(2)));
        }
        return num;
    }

    // определяем знак операции
    private static String operation(ArrayList<String> parseData){
        return parseData.get(1);
    }

    // выполнение нужной операции
    private static int operationResult(String sign, int number1, int number2) {
        return switch (sign) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            case "*" -> number1 * number2;
            default -> throw new NumberFormatException("Ошибка знака операции, используйте '+', '-', '/', '*'.");
        };
    }
}

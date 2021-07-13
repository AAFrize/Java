import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    static boolean isRoman = false;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = bufferedReader.readLine();
            Parsing parsing = new Parsing(data);
            ArrayList<String> arrayOfData = parsing.parsingString();
            ArrayList<Integer> numbers = parsing.numbers(arrayOfData);
            int result = parsing.operationResult(arrayOfData, numbers.get(0), numbers.get(1));
            if (isRoman) System.out.println(RomanNumerals.fromIntToRoman(result));
            else System.out.println(result);
        }
        catch (IOException io) {
            System.out.println("IOException");
        }
    }

}

package Calculator;

public class StringCalculator {
    int add(String numbers) {
        String numbersWithSpace = numbers.replace(",", " ");
        String[] tab = numbersWithSpace.split(" ");
        int result = 0;
        if (numbers.isEmpty()) {
            return result;
        } else {
            for (String number : tab) {
                if (!number.isEmpty() && number.length() < 4) {
                    if (number.contains("-")) {
                        throw new IllegalArgumentExeption("negatives not allowed " + number);
                    }
                    result += Integer.parseInt(number);
                }
            }
        }
        return result;
    }
}

package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceRadixAsString = "";
        String numberAsString = "";
        String targetRadixAsString = "";
        if (scanner.hasNext()) {
            sourceRadixAsString = scanner.nextLine();
        } else {
            System.out.println("Error: no input.");
        }
        if (scanner.hasNext()) {
            numberAsString = scanner.nextLine();
        } else {
            System.out.println("Error: no input.");
        }
        if (scanner.hasNext()) {
            targetRadixAsString = scanner.nextLine();
        } else {
            System.out.println("Error: no input.");
        }

        if (ErrorCatcher.validate(sourceRadixAsString, numberAsString, targetRadixAsString) == false) {
            System.out.println("Error.");
        } else {
            int sourceRadix = Integer.parseInt(sourceRadixAsString);
            int targetRadix = Integer.parseInt(targetRadixAsString);
            Fraction sourceFraction = new Fraction(numberAsString, sourceRadix);
            Fraction decFraction = Converter.toDecFraction(sourceFraction);
            Fraction resultFraction = Converter.fromDecFraction(decFraction, targetRadix);
            System.out.println(resultFraction);
        }


    }
}

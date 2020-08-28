package converter;

public class ErrorCatcher {

    public static boolean validate(String sourceRadixAsString, String numberAsString, String targetRadixAsString) {
        return validateSourceRadix(sourceRadixAsString) &&
                validateNumber(numberAsString) &&
                validateTargetRadix(targetRadixAsString);
    }

    private static boolean validateTargetRadix(String targetRadixAsString) {
        int i;
        try {
            i = Integer.parseInt(targetRadixAsString);
        } catch (NumberFormatException ex) {
            System.out.println("Error: target radix should be integer.");
            return false;
        }
        if (i < 1) {
            System.out.println("Error: target radix should be greater than one.");
            return false;
        } else if (i > Character.MAX_RADIX) {
            System.out.println("Error: target radix should be less or equal than 36");
            return false;
        } else {
            return true;
        }
    }

    private static boolean validateNumber(String numberAsString) {
        if (numberAsString.split("\\.").length > 2) {
            System.out.println("Error: fraction should contain no more than one delimiter.");
            return false;
        }
        if (!numberAsString.matches("[0-9a-zA-Z.]+")) {
            System.out.println("Error: number should contain only alphanumerical symbols.");
            return false;
        }
        return true;

    }

    private static boolean validateSourceRadix(String sourceRadixAsString) {
        int i;
        try {
            i = Integer.parseInt(sourceRadixAsString);
        } catch (NumberFormatException ex) {
            System.out.println("Error: source radix should be integer.");
            return false;
        }
        if (i < 1) {
            System.out.println("Error: source radix should be greater than one.");
            return false;
        } else if (i > Character.MAX_RADIX) {
            System.out.println("Error: source radix should be less or equal than 36");
            return false;
        } else {
            return true;
        }

    }
}

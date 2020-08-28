package converter;

public class Converter {

    private static final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static Fraction toDecFraction(Fraction sourceFraction) {
        String decIntegerPart;
        String decFractionPart;
        if (sourceFraction.getRadix() == 1) {
            decIntegerPart = String.valueOf(sourceFraction.getIntegerPart().length());
            decFractionPart = "";
        } else {
            decIntegerPart = convertIntegerPart(sourceFraction.getIntegerPart(), sourceFraction.getRadix());
            decFractionPart = convertFractionalPart(sourceFraction.getFractionalPart(), sourceFraction.getRadix());
        }
        return new Fraction(decIntegerPart, decFractionPart, 10);
    }

    private static String convertFractionalPart(String fractionalPart, int radix) {
        double result = 0.0;
        if (radix == 1) {
            return "";
        } else {
            for (int i = 0; i < fractionalPart.length(); i++) {
                result += alphabet.indexOf(fractionalPart.charAt(i)) / Math.pow(radix, i + 1);
            }
            // result = round(result, 5);
            return String.valueOf(result);
        }
    }

    private static String convertIntegerPart(String integerPart, int radix) {
        return String.valueOf(Integer.parseInt(integerPart, radix));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static Fraction fromDecFraction(Fraction decFraction, int targetRadix) {
        String decIntegerPart;
        String decFractionPart;
        if (targetRadix == 1) {
            decIntegerPart = "1".repeat(Integer.parseInt(decFraction.getIntegerPart()));
            decFractionPart = "";
        } else {
            decIntegerPart = convertIntegerPartOfDec(decFraction, targetRadix);
            decFractionPart = convertFractionalPartOfDec(decFraction, targetRadix);
        }
        return new Fraction(decIntegerPart, decFractionPart, 10);
    }

    private static String convertFractionalPartOfDec(Fraction decFraction, int targetRadix) {
        StringBuilder result = new StringBuilder();
        if (decFraction.getFractionalPart().equals("")) {
            return "";
        } else {
            double fractional = Double.parseDouble(decFraction.getFractionalPart());
            int index;
            for (int i = 1; i < 6; i++) {
                fractional = fractional * targetRadix;
                index = (int) Math.floor(fractional);
                result.append(alphabet.charAt(index));
                fractional = fractional - (double) index;
            }
            return String.valueOf(result);
        }
    }

    private static String convertIntegerPartOfDec(Fraction decFraction, int targetRadix) {
        return Integer.toString(Integer.parseInt(decFraction.getIntegerPart()), targetRadix);
    }
}

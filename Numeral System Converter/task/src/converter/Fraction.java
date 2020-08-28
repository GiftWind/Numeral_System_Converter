package converter;

public class Fraction {

    private String integerPart;
    private String fractionalPart;
    private int radix;

    public Fraction(String numberAsString, int sourceRadix) {
        String[] fractionAsString = numberAsString.split("\\.");
        if (fractionAsString.length == 2) {
            this.integerPart = fractionAsString[0];
            this.fractionalPart = fractionAsString[1];
            this.radix = sourceRadix;
        } else {
            this.integerPart = fractionAsString[0];
            this.fractionalPart = "";
            this.radix = sourceRadix;
        }
    }

    public Fraction(String decIntegerPart, String decFractionPart, int i) {
        this.integerPart = decIntegerPart;
        this.fractionalPart = decFractionPart;
        this.radix = i;
    }

    public String getIntegerPart() {
        return integerPart;
    }

    public String getFractionalPart() {
        return fractionalPart;
    }

    public int getRadix() {
        return radix;
    }

    @Override
    public String toString() {
        if ("".equals(fractionalPart)) {
            return integerPart;
        } else {
            return integerPart + "." + fractionalPart;
        }
    }
}

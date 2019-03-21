public class RomanNumbers extends ArabicNumbers {

    //Constructors
    public RomanNumbers(String expression) {
        super(expression);
    }

    //Functions
    @Override
    public void initialization() {
        try {
            int numberOne = 0, numberTwo = 0;
            if (isConvert(expressions[0])) {
                result = convertToArabic(expressions[0]);
            }
            for (int i = 2; i < expressions.length; i += 2) {
                if (isConvert(expressions[i - 2]) && isConvert(expressions[i])) {
                    numberOne = result;
                    numberTwo = convertToArabic(expressions[i]);
                    setResult(calculate(numberOne, numberTwo, expressions[i - 1]));
                    result = getResult();
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("Incorrect entry, try again");
        }
    }

    private int convertToArabic(String s){
        if (s.isEmpty()) return 0;
        if (s.startsWith("M"))  return 1000 + convertToArabic(s.substring(1));
        else if (s.startsWith("CM")) return 900  + convertToArabic(s.substring(2));
        else if (s.startsWith("D"))  return 500  + convertToArabic(s.substring(1));
        else if (s.startsWith("CD")) return 400  + convertToArabic(s.substring(2));
        else if (s.startsWith("C"))  return 100  + convertToArabic(s.substring(1));
        else if (s.startsWith("XC")) return 90   + convertToArabic(s.substring(2));
        else if (s.startsWith("L"))  return 50   + convertToArabic(s.substring(1));
        else if (s.startsWith("XL")) return 40   + convertToArabic(s.substring(2));
        else if (s.startsWith("X"))  return 10   + convertToArabic(s.substring(1));
        else if (s.startsWith("IX")) return 9    + convertToArabic(s.substring(2));
        else if (s.startsWith("V"))  return 5    + convertToArabic(s.substring(1));
        else if (s.startsWith("IV")) return 4    + convertToArabic(s.substring(2));
        else if (s.startsWith("I"))  return 1    + convertToArabic(s.substring(1));
        throw new IllegalArgumentException("Unexpected roman numerals");
    }

    private boolean isConvert(String s) {
        if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            return false;
        }else {
            return true;
        }
    }

    public boolean isValid(String expression) {
        boolean check = true;
        for (int i = 0; i <expression.length(); i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' || expression.charAt(i) == '/' ||
                    expression.charAt(i) == ' ' || !Character.isDigit(expression.charAt(i))) {
                continue;
            }else {
                check = false;
                break;
            }
        }
        return check;
    }
}

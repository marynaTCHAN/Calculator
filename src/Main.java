import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static boolean isArabic(String expression) {
        boolean isArabic = true;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != ' ' && Character.isDigit(expression.charAt(i))) {
                break;
            } else {
                isArabic = false;
                break;
            }
        }
        return isArabic;
    }

    public static void main(String ... args) {
        boolean done = true;
        Scanner scanner = new Scanner(System.in);
        String expression;
        while (done) {
            System.out.println("Enter the expression to calculate:");
            expression = scanner.nextLine();
            if("q".equals(expression)) {
                done = false;
                break;
            }
                if (isArabic(expression)) {
                     new ArabicNumbers(expression);
                } else {
                     new RomanNumbers(expression);
                }
            System.out.println("press 'q' to exit");
        }
    }
}

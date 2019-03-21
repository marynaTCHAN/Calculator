public class ArabicNumbers extends Calculator {
    //Fields
    String [] expressions;
    int result;

    //Constructors
    public ArabicNumbers(String expression) {
        if(isValid(expression)) {
            if (containsSpace(expression)) {
                expressions = (deleteSpace(expression));
            } else {
                expressions = deleteSpace(editString(expression));
            }
            initialization();
            print();
        }else {
            System.out.println("Incorrect entry, try again");
        }
    }

    //Functions
    private String editString(String expression) {
        StringBuilder string =  new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'
                    || expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                string.append(" " + expression.charAt(i) + " ");
            }
            else {
                string.append(expression.charAt(i));
            }
        }
        return string.toString();
    }

    private boolean containsSpace (String expression) {
        return expression.contains("\\s+");
    }

    private String [] deleteSpace (String expression) {
        String[] subStr;
        String delimeter = " ";
        subStr = expression.split(delimeter);
        int size = 0;
        for(int i = 0; i < subStr.length; i++) {
            if(!subStr[i].equals("")){
                size++;
            }
        }
        String [] expressionArray =  new String[size];
        int counter = 0;
        for(int i = 0; i < subStr.length; i++) {
            if(!subStr[i].equals("")){
                expressionArray[counter] = subStr[i];
                counter++;
            }
        }
        return expressionArray;
    }

    public int getResult(){
     return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void initialization(){
        try {
            int numberOne = 0, numberTwo = 0;
            result = Integer.parseInt(expressions[0]);
            for (int i = 2; i < expressions.length; i += 2) {
                numberOne = result;
                numberTwo = Integer.parseInt(expressions[i]);
                setResult(calculate(numberOne, numberTwo, expressions[i - 1]));
                result = getResult();
                //System.out.println(result);
            }
        }catch (NumberFormatException e) {
            System.out.println("Incorrect entry, try again");
        }
    }

    protected int calculate (int numberOne, int numberTwo, String sign) {
        if(sign.equals("+")){
            return sumOfNumbers(numberOne, numberTwo);
        }else if(sign.equals("-")) {
            return differenceOfNumbers(numberOne, numberTwo);
        }else if (sign.equals("*")){
            return productOfNumbers(numberOne, numberTwo);
        }else {
            return shareOfNumbers(numberOne, numberTwo);
        }
    }

    int sumOfNumbers(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }

    int differenceOfNumbers(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    int productOfNumbers(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }
    int shareOfNumbers(int numberOne, int numberTwo) {
        return (int)numberOne / numberTwo;
    }

    public String toString(){
        String string = "";
        for(int i = 0; i < expressions.length; i++) {
            string +=expressions[i] + " ";
        }
        string += "= ";
        string += getResult();
        return string;
    }

    public void print() {
        System.out.println(toString());
    }

    public boolean isValid(String expression) {
        boolean check = true;
        for (int i = 0; i <expression.length(); i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' ||
            expression.charAt(i) == '-' || expression.charAt(i) == '/' ||
            expression.charAt(i) == ' ' || Character.isDigit(expression.charAt(i))) {
                continue;
            }else {
                check = false;
                break;
            }
        }
        return check;
    }

}

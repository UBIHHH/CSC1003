import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class TestMathExpr {

    private Stack<String> notation = new Stack<>();
    private ArrayList<String> original = new ArrayList<String>();
    private ArrayList<String> eqation = new ArrayList<String>();
    private Stack<String> calculator = new Stack<>();

    public TestMathExpr(String PreExpression) {
        StringTokenizer stringTokenizer = new StringTokenizer(PreExpression, "\\+|\\-|\\*|\\/|\\(|\\)", true);
        while (stringTokenizer.hasMoreTokens()) {
            original.add(stringTokenizer.nextToken());
        }
        for (int i = 0; i < original.size(); i++) {
            if (original.get(i).equals(" ")) {
                original.remove(i);
            }
            if (original.get(i).contains(" ")) {
                original.set(i, original.get(i).replaceAll(" ", ""));
            }

        }
        if (original.get(0).equals("-")) {
            original.add(0, "0");
        }
        for (int i = 0; i < original.size(); i++) {
            if (original.get(i).equals("-")) {
                if (original.get(i - 1).equals("(")) {
                    original.add(i, "0");
                }
            }
        }

    }

    public boolean isNotation(String str) {
        if ("+-*/tancossinsqrt()".indexOf(str) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int knowPrior(String str) {
        int prior;
        switch (str) {
            case "+":
            case "-":
                prior = 1;
                break;
            case "*":
            case "/":
                prior = 2;
                break;
            case "(":
                prior = 4;
                break;
            case ")":
                prior = 0;
                break;
            case "tan":
            case "sin":
            case "cos":
            case "sqrt":
                prior = 3;
                break;
            default:
                prior = -1;
                break;
        }
        return prior;
    }

    public boolean isPrior(String str1, String str2) {
        return (knowPrior(str1) > knowPrior(str2));
    }

    public void notationStack(String str) {
        if (notation.isEmpty())
            notation.push(str);
        else if ("(".equals(str))
            notation.push(str);
        else if (")".equals(str)) {
            String string;
            while (!"(".equals(string = notation.pop())) {
                eqation.add(string);
            }
        } else if ("(".equals(notation.peek())) {
            notation.push(str);
        } else if (isPrior(str, notation.peek())) {
            notation.push(str);
        } else if (!isPrior(str, notation.peek())) {
            eqation.add(notation.pop());
            notationStack(str);
        }
    }

    public void originalToEqation() {
        for (String str : original) {
            if (isNotation(str))
                notationStack(str);
            else
                eqation.add(str);
        }

        while (!notation.isEmpty()) {
            eqation.add(notation.pop());
        }
    }

    public double doubleCal(String str1, String str2, String str3) {
        double num1, num2;
        num2 = Double.valueOf(str1).doubleValue();
        num1 = Double.valueOf(str2).doubleValue();
        if (str3.equals("+")) {
            return num1 + num2;
        } else if (str3.equals("-")) {
            return num1 - num2;
        } else if (str3.equals("*")) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    public double singleCal(String str1, String str2) {
        double num1;
        num1 = Double.valueOf(str1).doubleValue();

        if (str2.equals("sin")) {
            return Math.sin(num1);
        } else if (str2.equals("cos")) {
            return Math.cos(num1);
        }

        else if (str2.equals("tan")) {
            return Math.tan(num1);
        } else {
            return Math.sqrt(num1);
        }

    }

    public String getResult() {
        for (String str : eqation) {

            if (!isNotation(str)) {
                calculator.push(str);
            } else if ("tansincossqrt".indexOf(str) >= 0) {
                calculator.push(String.valueOf(singleCal(calculator.pop(), str)));
            } else {
                calculator.push(String.valueOf(doubleCal(calculator.pop(), calculator.pop(), str)));
            }
        }

        return calculator.pop();
    }

    public static double parse(String str) {
        TestMathExpr cal = new TestMathExpr(str);
        cal.originalToEqation();
        double res = Double.valueOf(cal.getResult());
        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            double result = parse(input.nextLine());
            System.out.println(String.valueOf(Math.round(result)));
        }

    }

}
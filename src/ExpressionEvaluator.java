import java.util.ArrayList;

public class ExpressionEvaluator {
    public static double evaluate(String expression) throws Exception {
        String noSpacesExpression = expression.replaceAll("\\s+", ""); /* Need to remove all spaces to
        be able to iterate through all the digits and operators in expression*/

        ArrayList<Double> numbersStack = new ArrayList<>();
        ArrayList<Character> operatorsStack = new ArrayList<>();

        for (int i = 0; i < noSpacesExpression.length(); i++) {
            char c = noSpacesExpression.charAt(i);

            if (Character.isDigit(c) || c == '.') { // Case for numbers and decimal points
                String currentNumber = "";
                while (i < noSpacesExpression.length() &&
                        (Character.isDigit(noSpacesExpression.charAt(i)) || noSpacesExpression.charAt(i) == '.')) {
                    currentNumber += noSpacesExpression.charAt(i);
                    i++;
                }
                i--; // Return to the 1st found non-number
                numbersStack.add(Double.parseDouble(currentNumber));
            }
            else if (c == '(') { // Case for parentheses
                operatorsStack.add(c);
            }
            else if (c == ')') {
                while (!operatorsStack.isEmpty() && operatorsStack.get(operatorsStack.size() - 1) != '(') {
                    computeTop(numbersStack, operatorsStack);
                }
                if (!operatorsStack.isEmpty()) {
                    operatorsStack.remove(operatorsStack.size() - 1); // remove '('
                } else {
                    throw new Exception("Mismatched parentheses in expression. Check the expression!");
                }
            }
            else if (c == '-' && (i == 0 || noSpacesExpression.charAt(i - 1) == '(')) { // Case for negative numbers
                i++;
                String currentNumber = "-";
                while (i < noSpacesExpression.length() &&
                        (Character.isDigit(noSpacesExpression.charAt(i)) || noSpacesExpression.charAt(i) == '.')) {
                    currentNumber += noSpacesExpression.charAt(i++);
                }
                i--;
                numbersStack.add(Double.parseDouble(currentNumber));
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') { // Case for operators
                while (!operatorsStack.isEmpty()) {
                    char top = operatorsStack.get(operatorsStack.size() - 1);
                    if (top == '(') break;
                    if ((top == '*' || top == '/') && (c == '+' || c == '-')) {
                        computeTop(numbersStack, operatorsStack);
                    } else if ((top == '+' || top == '-') && (c == '+' || c == '-')) {
                        computeTop(numbersStack, operatorsStack);
                    } else {
                        break;
                    }
                }
                operatorsStack.add(c);
            }
            else {
                throw new Exception("Invalid character in the expression: " + c);
            }
        }

        while (!operatorsStack.isEmpty()) {
            computeTop(numbersStack, operatorsStack);
        }

        if (numbersStack.size() != 1) {
            throw new Exception("The expression is not valid. Check the expression!");
        }

        double result = numbersStack.get(0);
        if (result == (int) result) { // To print without decimal when that is integer
            return (int) result;
        }
        return result;
    }

    private static void computeTop(ArrayList<Double> numbersStack, ArrayList<Character> operatorsStack) throws Exception {
        if (numbersStack.size() < 2 || operatorsStack.isEmpty()) {
            throw new Exception("The expression is not valid. Check the expression!");
        }

        double b = numbersStack.remove(numbersStack.size() - 1);
        double a = numbersStack.remove(numbersStack.size() - 1);
        char operator = operatorsStack.remove(operatorsStack.size() - 1);

        double result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new Exception("Division by zero in the expression. Check the expression!");
                yield a / b;
            }
            default -> throw new Exception("Unknown operator in the expression: " + operator);
        };

        numbersStack.add(result);
    }
}

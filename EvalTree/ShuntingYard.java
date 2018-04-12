package EvalTree;

import java.util.Stack;

/**
 * Implementation of Shunting-Yard algorithm.
 * Transforms an expression from infix to prefix.
 * @author Robert
 */
public class ShuntingYard {
    String infix;
    String operators = "+-*/()";
    
    /**
     * Constructor for ShuntingYard class.
     * Initialize the infix form.
     * @param infix The infix form of the expression
     */
    public ShuntingYard(String infix) {
        this.infix = infix;
    }
    /**
     * Verify if the given string is an operator.
     * @param string The string to be verified
     * @return True if the string is an operator, False otherwise
     */
    boolean isOperator(String string) {
        return operators.contains(string);
    }
    /**
     * Plus and minus have priority 1 and multiply and divide have priority 2.
     * @param string The operator
     * @return 1 if the operator is plus or minus and 2 if the operator is 
     * divide or multiply
     */
    int getPriority(String string) {
        if(string.equals("+") || string.equals("-")) {
            return 1;
        }
        else return 2;
    }
    
    /**
     * Converts the infix form to postfix form using the Shunting-Yard algorithm.
     * @return The postfix form of the expression
     */
    public String infixToPostfix() {
        
        Stack<String> stack = new Stack<>();
        String postfix = "";
        
        for (String token : infix.split(" ")) {
            
            if (!isOperator(token)) {
                postfix = postfix + token + " ";
            }
            
            else if (token.equals("(")) {
                stack.push(token);
            }
            
            else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();
            }
            
            else {
                boolean operationChecked = false;
                while (!operationChecked){
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        stack.push(token);
                        operationChecked = true;
                    }
                    else {
                        String topOperator = stack.peek();
                    
                        if (getPriority(token) > getPriority(topOperator)) {
                            stack.push(token);
                            operationChecked = true;
                        }
                    
                        else {
                            postfix = postfix + stack.pop() + " ";
                        }
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            postfix = postfix + stack.pop() + " ";
        }
        return postfix;
    }

}    

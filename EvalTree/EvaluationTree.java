package EvalTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Robert
 */
public class EvaluationTree {
    private static String operations = "+-*/";
    private String postfixExpression;
    
    /**
     * Constructor for EvaluationTree class.
     * Initialize the string postfixExpression with the postfix form converted
     * from infix form.
     * @param infixExpression The infix form of the expression
     * @param nodeList The map used for mapping the expression variables with
     * their names
     */
    public EvaluationTree(String infixExpression, HashMap<String,Node> nodeList) {
        this.postfixExpression = new ShuntingYard(infixExpression).infixToPostfix();
    }
 
    /**
     * Constructs the parsing tree from postfix expression.
     * In first part, all nodes are initialized and added to a list.
     * Nodes are initialized as operand node or as operator node.
     * @param postfixExpression The postfix form of the expression
     * @param nodeList The map used for mapping the expression variables with
     * their names
     * @return The first node of the tree(root node)
     */
    public TreeNode ConstrucPostfixTree(String postfixExpression, HashMap<String, Node> nodeList) {
        ArrayList<TreeNode> Nodes = new ArrayList<>();
        int i = 0;

        for (String token : postfixExpression.split(" ")) {
            if (EvaluationTree.operations.indexOf(token) == -1) {
                Nodes.add(new TreeNode(nodeList.get(token)));
                i++;
            }
            else {
                switch(token) {
                    case "+":
                        Nodes.add(new TreeNode(Operation.ADD));
                        break;
                    case "-":
                        Nodes.add(new TreeNode(Operation.SUB));
                        break;
                    case "*":
                        Nodes.add(new TreeNode(Operation.MUL));
                        break;
                    case "/":
                        Nodes.add(new TreeNode(Operation.DIV));
                        break;
                }
            }
        }    
	int currentPosition = 2;
            while (Nodes.size() > 1) {
                if (!Nodes.get(currentPosition).getOperation().equals(Operation.EQ)) {
                    Nodes.get(currentPosition).SetChildren(Nodes.remove(currentPosition - 2), Nodes.remove(currentPosition - 2));
                    currentPosition = 2;
                }    
                else {
                    currentPosition++;
                }
            }
            
            return Nodes.get(0);
    }
    
    /**
     * Evaluates the expression using the postfix form.
     * The evaluation is realized using the interpreter design pattern.
     * @param postfixExpression The postfix form of the expression
     * @param nodeList The map used for mapping the expression variables with
     * their names
     * @return The final value of the expression
     */
    public Node Evaluate(String postfixExpression, HashMap<String, Node> nodeList) {
        Stack<Expression> stack = new Stack<>();
        for (String token : postfixExpression.split(" ")) {
            if (isOperator(token)) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                Expression operator = getOperator(token, left, right);
                Node result = operator.interpret();
                System.out.println(left.interpret().getValue().toString() + " " + token + " " + right.interpret().getValue().toString() + " = " + result.getValue().toString());
                stack.push(new NumberExpression(result));
            }
            else {
                Expression number = new NumberExpression(nodeList.get(token));
                stack.push(number);
            }
        }
        return stack.pop().interpret();
        
    }
    
    /**
     * 
     * @param s The string to be tested
     * @return True if s is an operator
     */
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    /**
     * Used in interpreter pattern to initialize the operation will be effectuated
     * according to the parameter string.
     * @param s The operation will be effectuated
     * @param left The expression of the left child
     * @param right The expression of the right child
     * @return The initialization of a new operation
     */
    public static Expression getOperator(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new AdditionExpression(left, right);
                
            case "-":
                return new SubtractionExpression(left, right);
                
            case "*":
                return new MultiplyExpression(left, right);
                
            case "/":
                return new DivisionExpression(left, right);
        }
        return null;
    }

    /**
     * 
     * @return The postfix form of the expression
     */
    public String getPostfixExpression() {
        return postfixExpression;
    }
    
    
}

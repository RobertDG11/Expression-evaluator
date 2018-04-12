package EvalTree;

/**
 *
 * @author Robert
 */
public class NumberExpression implements Expression {
    Node number;
    
    /**
     * Constructor for NumberExpression class.
     * Initialize the value number with the given parameter.
     * @param number The node will be used
     */
    public NumberExpression(Node number) {
        this.number = number;
    }
    
    /**
     * Interprets the expression(this case the node).
     * @return The node
     */
    @Override
    public Node interpret() {
        return number;
    }  
}

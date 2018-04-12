package EvalTree;

/**
 *
 * @author Robert
 */
public class SubtractionExpression implements Expression{
    Expression left;
    Expression right;
    
    /**
     * Constructor for SubtractionExpression class.
     * Initialize an expression for subtraction operation with specific operands.
     * @param left The Expression for left child
     * @param right The Expression for right child
     */
    public SubtractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Interpret the expression and execute subtraction operation for left child
     * and right child.
     * The result is stored in an Node object's fields.
     * @return The node that contains the result of the operation
     */
    @Override
    public Node interpret() {
        Subtraction sub = new Subtraction();
        sub.substract(left.interpret(), right.interpret());
        NodeType type = sub.getType();
        NodeFactory nf = new NodeFactory();
        Node n = nf.createNode(type);
        switch(type) {
            case INT:
                if(sub.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Integer.parseInt(sub.getResult()));
                }
                break;
                
            case DOUBLE:
                if(sub.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Double.parseDouble(sub.getResult()));
                }
                break;
                
            case STRING:
                n.setValue(sub.getResult());
                break;
        }
        
      return n;
    }
}

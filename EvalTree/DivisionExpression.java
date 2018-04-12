package EvalTree;

/**
 *
 * @author Robert
 */
public class DivisionExpression implements Expression {
    Expression left;
    Expression right;
    
    /**
     * Constructor for DivisionExpression class.
     * Initialize an expression for division operation with specific operands.
     * @param left The Expression for left child
     * @param right The Expression for right child
     */
    public DivisionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Interpret the expression and execute division operation for left child
     * and right child.
     * The result is stored in an Node object's fields.
     * @return The node that contains the result of the operation
     */
    @Override
    public Node interpret() {
        Division div = new Division();
        div.div(left.interpret(), right.interpret());
        NodeType type = div.getType();
        NodeFactory nf = new NodeFactory();
        Node n = nf.createNode(type);
        switch(type) {
            case INT:
                if(div.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Integer.parseInt(div.getResult()));
                }
                break;
                
            case DOUBLE:
                if(div.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Double.parseDouble(div.getResult()));
                   
                }
                break;
                
            case STRING:
                n.setValue(div.getResult());
                break;
        }
        
      return n;
    }
}

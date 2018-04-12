package EvalTree;

/**
 *
 * @author Robert
 */
public class MultiplyExpression implements Expression {
    Expression left;
    Expression right;
    
    /**
     * Constructor for MultiplyExpression class.
     * Initialize an expression for division operation with specific operands.
     * @param left The Expression for left child
     * @param right The Expression for right child
     */
    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Interpret the expression and execute multiply operation for left child
     * and right child.
     * The result is stored in an Node object's fields.
     * @return The node that contains the result of the operation
     */
    @Override
    public Node interpret() {
        Multiply mul = new Multiply();
        mul.mul(left.interpret(), right.interpret());
        NodeType type = mul.getType();
        NodeFactory nf = new NodeFactory();
        Node n = nf.createNode(type);
        switch(type) {
            case INT:
                if(mul.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Integer.parseInt(mul.getResult()));
                }
                break;
                
            case DOUBLE:
                if(mul.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Double.parseDouble(mul.getResult()));
                }
                break;
                
            case STRING:
                n.setValue(mul.getResult());
                break;
        }
        
      return n;
    }
}

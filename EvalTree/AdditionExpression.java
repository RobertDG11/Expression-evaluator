package EvalTree;

/**
 *
 * @author Robert
 */
public class AdditionExpression implements Expression{
    Expression left;
    Expression right;
    
    /**
     * Constructor for AdditionExpression class.
     * Initialize an expression for addition operation with specific operands.
     * @param left The Expression for left child
     * @param right The Expression for right child
     */
    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Interpret the expression and execute addition operation for left child
     * and right child.
     * The result is stored in an Node object's fields.
     * @return The node that contains the result of the operation
     */
    @Override
    public Node interpret() {
        Addition add = new Addition();
        add.add(left.interpret(), right.interpret());
        NodeType type = add.getType();
        NodeFactory nf = new NodeFactory();
        Node n = nf.createNode(type);
        switch(type) {
            case INT:
                if(add.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Integer.parseInt(add.getResult()));
                }
                break;
                
            case DOUBLE:
                if(add.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Double.parseDouble(add.getResult()));
                }
                break;
                
            case STRING:
                n.setValue(add.getResult());
                break;
        }
        
      return n;
    }
    
    
}

package EvalTree;

/**
 *
 * @author Robert
 */
public class DoubleNode implements Node {
    double value;

    /**
     * Variable to store the type of the node.
     * The type is DOUBLE(by default).
     */
    public NodeType type;
    boolean isNaN;
    
    /**
     * Constructor for DoubleNode class.
     * Initialize a node with double type value.
     * Field isNaN is false by default(when initialized, a node will never have)
     * NaN value.
     */
    public DoubleNode() {
        this.type = NodeType.DOUBLE;
        this.isNaN = false;
    }

    /**
     * If the isNaN variable is true, this will return "NaN", else will return
     * the value of the node.
     * @return The value of the DoubleNode
     */
    @Override
    public Object getValue() {
        if (getNaN()) {
            return "NaN";
        }
        else {
           return this.value;
        }     
    }

    /**
     * Sets the value of the DoubleNode converted to double
     * @param value The new value
     */
    @Override
    public void setValue(Object value) {
        this.value = (Double) value;
    }

    /**
     * 
     * @return The type of DoubleNode(Double by default).
     */
    @Override
    public NodeType getType() {
        return this.type;
    }
    
    /**
     * Sets the the value of isNaN variable.
     * @param expr The value which can be true or false
     */
    @Override
    public void setNaN(boolean expr) {
        this.isNaN = expr;
    }

    /**
     *
     * @return The value of isNaN variable
     */
    @Override
    public boolean getNaN() {
        return this.isNaN;
    }
    
}

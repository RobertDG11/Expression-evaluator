package EvalTree;

/**
 *
 * @author Robert
 */
public class IntNode implements Node {
    int value;

    /**
     * Variable to store the type of the node.
     * The type is INT(by default).
     */
    public NodeType type;
    boolean isNaN;

   /**
     * Constructor for IntNode class.
     * Initialize a node with int type value.
     * Field isNaN is false by default(when initialized, a node will never have)
     * NaN value.
     */
    public IntNode() {
        this.type = NodeType.INT;
        isNaN = false;
    }

    /**
     * Sets the value of the IntNode converted to int
     * @param value The new value
     */
    @Override
    public void setValue(Object value) {
        this.value = (int) value;
    }

    /**
     * If the isNaN variable is true, this will return "NaN", else will return
     * the value of the node.
     * @return The value of the IntNode
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
     * 
     * @return The type of IntNode(INT by default).
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

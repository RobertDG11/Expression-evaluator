package EvalTree;

/**
 *
 * @author Robert
 */
public class StringNode implements Node {
    String value;

    /**
     * Variable to store the type of the node.
     * The type is STRING(by default).
     */
    public NodeType type;
    boolean isNaN;

    /**
     * Constructor for StringNode class.
     * Initialize a node with String type value.
     * Field isNaN is false by default(when initialized, a node will never have)
     * NaN value.
     */
    public StringNode() {
        this.type = NodeType.STRING;
        this.isNaN = false;
    }

    /**
     *
     * @return The value of the StringNode
     */
    @Override
    public Object getValue() {
        return this.value;
    }

    /**
     * Sets the value of the StringNode converted to string
     * @param value The new value
     */
    @Override
    public void setValue(Object value) {
        this.value = String.valueOf(value);
    }

    /**
     * 
     * @return The type of StringNode(STRING by default).
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

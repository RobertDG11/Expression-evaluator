package EvalTree;

/**
 * Interface used for interpreter design pattern
 * @author Robert
 */
public interface Expression {

    /**
     * Interpretes an expression.
     * @return the node resulted
     */
    public Node interpret();
}

package EvalTree;

/**
 * Interface for nodes
 * @author Robert
 */
public interface Node {

    public NodeType type = NodeType.INT;
    public Object getValue();
    public void setValue(Object value);
    public NodeType getType();
    public void setNaN(boolean expr);
    public boolean getNaN();
}

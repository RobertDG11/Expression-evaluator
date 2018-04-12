package EvalTree;

/**
 *
 * @author Robert
 */
public class NodeFactory {
    
    /**
     * Creates a new node according to the value of type variable
     * @param type The type of the node
     * @return The initialization of a node(IntNode, DoubleNode or StringNode)
     */
    public Node createNode(NodeType type) {
        switch(type) {
            case INT:
                return new IntNode();
                
            case DOUBLE:
                return new DoubleNode();
                
            case STRING:
                return new StringNode();
        }
        throw new IllegalArgumentException("The node type " + type + " is not recognized.");

    }
}

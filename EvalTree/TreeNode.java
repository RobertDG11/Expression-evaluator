package EvalTree;

/**
 * Node class of the tree
 * @author Robert
 */
public class TreeNode {
    Node data;
    TreeNode left;
    TreeNode right;
    Operation operation;
    
    /**
     * Constructor for TreeNode class for an operand.
     * Initialize the tree node with all his fields.
     * The node is initialized as a leaf, so it doesn't have children(left and 
     * right are null).
     * Operation is EQ by default at this constructor.
     * @param data The data stored by the node;
     */
    public TreeNode(Node data) {
	this.data = data;
	this.operation = Operation.EQ;
	this.left = null;
	this.right = null;
    }
    
    /**
     * Constructor for TreeNode class for an operator.
     * Initialize the tree node with all his fields.
     * The node is initialized as a leaf, so it doesn't have children(left and 
     * right are null).
     * Data field is null by default.
     * @param operation the operation will be effectuated
     */
    public TreeNode(Operation operation) {
        this.data = null;
        this.operation = operation;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Sets the children of the node.
     * @param left Left children
     * @param right Right children
     */
    public void SetChildren(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 
     * @return The operation field
     */
    public Operation getOperation() {
        return operation;
    }
    
    
    
}

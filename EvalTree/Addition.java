package EvalTree;

/**
 *
 * @author Robert
 */
public class Addition {
    String result;
    NodeType type;
    
    /**
     * Constructor for Addition class.
     * Initialize result with void string.
     */
    public Addition() {
        result = "";
    }
    
    /**
     * Add the value of the two nodes based on specific rules.
     * Nodes can have value of type int, double or String.
     * Uses specific rules for every combination of the two nodes.
     * The result of addition operation is stored in result variable.
     * @param n1 First node
     * @param n2 Second node
     */
    public void add(Node n1, Node n2) {
        switch(n1.getType()) {
            case INT:
                switch(n2.getType()) {
                    case INT:
                        int sum;
                        if(n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        }
                        else {
                            sum = (int) n1.getValue() + (int) n2.getValue();
                            result = result + sum;
                        }
        
                        this.type = NodeType.INT;
                        break;
                        
                    case DOUBLE:
                        double sum1;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            sum1 = (int) n1.getValue() + (double) n2.getValue();
                            result = result + sum1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        if (n2.getValue().equals("NaN")) {
                            result = result + n1.getValue().toString() + "NaN";
                        } 
                        else if (n1.getNaN()) {
                            result = result + "NaN" + n2.getValue().toString();
                        } 
                        else {
                            result = result + n1.getValue().toString() + n2.getValue().toString();
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                }
                break;
                
            case DOUBLE:
                switch(n2.getType()) {
                    case INT:
                        double sum;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            sum = (double) n1.getValue() + (int) n2.getValue();
                            result = result + sum;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case DOUBLE:
                        double sum1;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            sum1 = (double) n1.getValue() + (double) n2.getValue();
                            result = result + sum1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        if (n2.getValue().equals("NaN")) {
                            result = result + n1.getValue().toString() + "NaN";
                        } 
                        else if (n1.getNaN()) {
                            result = result + "NaN" + n2.getValue().toString();
                        } 
                        else {
                            result = result + ((double) Math.round((double) n1.getValue() * 100) / 100) + n2.getValue().toString();
                        }

                        this.type = NodeType.STRING;
                        break;
                }
                break;
                
            case STRING:
                switch(n2.getType()) {
                    case INT:
                        if (n1.getValue().equals("NaN")) {
                            result = result + "NaN";
                        } 
                        else if (n2.getNaN()) {
                            result = result + n1.getValue().toString() + "NaN";
                        }
                        else {

                            result = result + n1.getValue().toString() + n2.getValue().toString();
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                    case DOUBLE:
                        if (n1.getValue().equals("NaN")) {
                            result = result + "NaN";
                        } 
                        else if (n2.getNaN()) {
                            result = result + n1.getValue().toString() + "NaN";
                        }
                        else {

                            result = result + n1.getValue().toString() + ((double) Math.round((double) n2.getValue() * 100) / 100);
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                    case STRING:
                        result = result + n1.getValue().toString() + n2.getValue().toString();

                        this.type = NodeType.STRING;
                        break;
                }
                break;
        }
    }

    /**
     * 
     * @return the value of variable result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @return the value of variable type(INT, DOUBLE, STRING)
     */
    public NodeType getType() {
        return type;
    }  
}

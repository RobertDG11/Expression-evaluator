package EvalTree;

/**
 *
 * @author Robert
 */
public class Division {
    String result;
    NodeType type;
    
   /**
     * Constructor for Division class.
     * Initialize result with void string.
     */
    public Division() {
        result = "";
    }
    
    /**
     * Divide the value of the two nodes based on specific rules.
     * Nodes can have value of type int, double or String.
     * Uses specific rules for every combination of the two nodes.
     * The result of division operation is stored in result variable.
     * @param n1 First node
     * @param n2 Second node
     */
    public void div(Node n1, Node n2) {
        switch(n1.getType()) {
            case INT:
                switch(n2.getType()) {
                    case INT:
                        int div;
                        if(n1.getNaN() || n2.getNaN() || (int) n2.getValue() == 0) {
                            result = result + "NaN";
                        }
                        else {
                            div = (int) n1.getValue() / (int) n2.getValue();
                            result = result + div;
                        }
        
                        this.type = NodeType.INT;
                        break;
                        
                    case DOUBLE:
                        double div1;
                        if (n1.getNaN() || n2.getNaN() || (double) n2.getValue() == 0) {
                            result = result + "NaN";
                        } 
                        else {
                            div1 = (int) n1.getValue() / (double) n2.getValue();
                            result = result + div1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        int div2;
                        if (n1.getNaN() || n2.getValue().equals("NaN") || n2.getValue().toString().length() == 0) {
                            result = result + "NaN";
                        } 
                        else {
                            div2 = (int) n1.getValue() / n2.getValue().toString().length();
                            result = result + div2;
                        }

                        this.type = NodeType.INT;
                        break;
                        
                }
                break;
                
            case DOUBLE:
                switch(n2.getType()) {
                    case INT:
                        double div;
                        if (n1.getNaN() || n2.getNaN() || (int) n2.getValue() == 0) {
                            result = result + "NaN";
                        } 
                        else {
                            div = (double) n1.getValue() / (int) n2.getValue();
                            result = result + div;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case DOUBLE:
                        double div1;
                        if (n1.getNaN() || n2.getNaN() || (double) n2.getValue() == 0) {
                            result = result + "NaN";
                        } 
                        else {
                            div1 = (double) n1.getValue() / (double) n2.getValue();
                            result = result + div1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        double div2;
                        if (n2.getValue().equals("NaN") || n1.getNaN() || n2.getValue().toString().length() == 0) {
                            result = result + "NaN";
                        } 
                        else {
                            div2 = (double) n1.getValue() / n2.getValue().toString().length();
                            result = result + div2;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                }
                break;
                
            case STRING:
                switch(n2.getType()) {
                    case INT:
                        if (n2.getNaN() || (int) n2.getValue() <= 0) {
                            result = result + n1.getValue().toString();
                        } 
                        else {
                            int i = n1.getValue().toString().length() / (int) n2.getValue();
                            result = result + n1.getValue().toString().substring(0, i);                          
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                    case DOUBLE:
                        double div;
                        if (n1.getValue().equals("NaN") || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            div = n1.getValue().toString().length() / (double) n2.getValue();
                            result = result + div;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        int div1;
                        if (n1.getValue().equals("NaN") || n2.getValue().equals("NaN")) {
                            result = result + "NaN";
                        } 
                     
                        else {
                            div1 = n1.getValue().toString().length() / n2.getValue().toString().length();
                            result = result + div1;
                        }

                        this.type = NodeType.INT;
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

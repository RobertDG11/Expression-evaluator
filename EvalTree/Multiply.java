package EvalTree;

/**
 *
 * @author Robert
 */
public class Multiply {
    String result;
    NodeType type;
    
    /**
     * Constructor for Multiply class.
     * Initialize result with void string.
     */
    public Multiply() {
        result = "";
    }
    
    /**
     * Multiply the value of the two nodes based on specific rules.
     * Nodes can have value of type int, double or String.
     * Uses specific rules for every combination of the two nodes.
     * The result of multiply operation is stored in result variable.
     * @param n1 First node
     * @param n2 Second node
     */
    public void mul(Node n1, Node n2) {
        switch(n1.getType()) {
            case INT:
                switch(n2.getType()) {
                    case INT:
                        int mul;
                        if(n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        }
                        else {
                            mul = (int) n1.getValue() * (int) n2.getValue();
                            result = result + mul;
                        }
        
                        this.type = NodeType.INT;
                        break;
                        
                    case DOUBLE:
                        double mul1;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            mul1 = (int) n1.getValue() * (double) n2.getValue();
                            result = result + mul1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        if (n1.getNaN() || (int) n1.getValue() <= 0) {
                            result = "";
                        } 
                        else {
                            int i = (int) n1.getValue();
                            while(i > 0) {
                                result = result + n2.getValue().toString();
                                i--;
                            }
                            
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                }
                break;
                
            case DOUBLE:
                switch(n2.getType()) {
                    case INT:
                        double mul;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            mul = (double) n1.getValue() * (int) n2.getValue();
                            result = result + mul;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case DOUBLE:
                        double mul1;
                        if (n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            mul1 = (double) n1.getValue() * (double) n2.getValue();
                            result = result + mul1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        double mul2;
                        if (n2.getValue().equals("NaN") || n1.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            mul2 = (double) n1.getValue() * n2.getValue().toString().length();
                            result = result + mul2;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                }
                break;
                
            case STRING:
                switch(n2.getType()) {
                    case INT:
                        if (n2.getNaN() || (int) n2.getValue() <= 0) {
                            result = "";
                        } 
                        else {
                            int i = (int) n2.getValue();
                            while(i > 0) {
                                result = result + n1.getValue().toString();
                                i--;
                            }
                            
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                    case DOUBLE:
                        double mul;
                        if (n1.getValue().equals("NaN") || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                        else {
                            mul = (double) n2.getValue() * n1.getValue().toString().length();
                            result = result +mul;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        int mul1;
                        if (n1.getValue().equals("NaN") || n2.getValue().equals("NaN")) {
                            result = result + "NaN";
                        } 
                     
                        else {
                            mul1 = n1.getValue().toString().length() * n2.getValue().toString().length();
                            result = result + mul1;
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

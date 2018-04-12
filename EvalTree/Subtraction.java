package EvalTree;

/**
 *
 * @author Robert
 */
public class Subtraction {
    String result;
    NodeType type;

    /**
     * Constructor for Subtraction class.
     * Initialize result with void string.
     */
    public Subtraction() {
        this.result = "";
    }
    
    /**
     * Subtracts the value of the second node from the value of the first one
     * based on specific rules.
     * Nodes can have value of type int, double or String.
     * Uses specific rules for every combination of the two nodes.
     * The result of subtraction operation is stored in result variable.
     * @param n1 First node
     * @param n2 Second node
     */
    public void substract(Node n1, Node n2) {
        switch(n1.getType()) {
            case INT:
                switch(n2.getType()) {
                    case INT:
                        int sum;
                        if(n1.getNaN() || n2.getNaN()) {
                            result = result + "NaN";
                        }
                        else {
                            sum = (int) n1.getValue() - (int) n2.getValue();
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
                            sum1 = (int) n1.getValue() - (double) n2.getValue();
                            result = result + sum1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        int sub;
                        if (n2.getValue().equals("NaN") || n1.getNaN()) {
                            result = result + "NaN";
                        } 
                        
                        else {
                            sub = (int) n1.getValue() - n2.getValue().toString().length();
                            result = result + sub;
                        }

                        this.type = NodeType.INT;
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
                            sum = (double) n1.getValue() - (int) n2.getValue();
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
                            sum1 = (double) n1.getValue() - (double) n2.getValue();
                            result = result + sum1;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        double sub;
                        if (n2.getValue().equals("NaN") || n1.getNaN()) {
                            result = result + "NaN";
                        } 
                        
                        else {
                            sub = (double) n1.getValue() - n2.getValue().toString().length();
                            result = result + sub;
                        }

                        this.type = NodeType.DOUBLE;
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
                            result = result + n1.getValue().toString();
                        }
                        else if ((int) n2.getValue() > n1.getValue().toString().length()) {

                            result = "";
                        }
                        
                        else if ((int) n2.getValue() < 0) {
                            StringBuilder sb = new StringBuilder(n1.getValue().toString());
                            int i = (-1) * (int) n2.getValue();
                            while (i > 0) {
                                sb.append('#');
                                i--;
                            }
                            result = result + sb;
                            
                        }
                        
                        else {
                            StringBuilder sb = new StringBuilder(n1.getValue().toString());
                            result = result + sb.delete(sb.length() - (int) n2.getValue() , sb.length());
                        }

                        this.type = NodeType.STRING;
                        break;
                        
                    case DOUBLE:
                        double sub;
                        if (n1.getValue().equals("NaN") || n2.getNaN()) {
                            result = result + "NaN";
                        } 
                     
                        else {
                            sub = n1.getValue().toString().length() - (double) n2.getValue();
                            result = result + sub;
                        }

                        this.type = NodeType.DOUBLE;
                        break;
                        
                    case STRING:
                        int sub1;
                        if (n1.getValue().equals("NaN") || n2.getValue().equals("NaN")) {
                            result = result + "NaN";
                        } 
                     
                        else {
                            sub1 = n1.getValue().toString().length() - n2.getValue().toString().length();
                            result = result + sub1;
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

package EvalTree;

public class SubstractionExpression implements Expression{
    Expression left;
    Expression right;
    
    public SubstractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Node interpret() {
        Substraction sub = new Substraction();
        sub.substract(left.interpret(), right.interpret());
        NodeType type = sub.getType();
        NodeFactory nf = new NodeFactory();
        Node n = nf.createNode(type);
        switch(type) {
            case INT:
                if(sub.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Integer.parseInt(sub.getResult()));
                }
                break;
                
            case DOUBLE:
                if(sub.getResult().equals("NaN")) {
                    n.setNaN(true);
                }
                else {
                    n.setValue(Double.parseDouble(sub.getResult()));
                }
                break;
                
            case STRING:
                n.setValue(sub.getResult());
                break;
        }
        
      return n;
    }
}

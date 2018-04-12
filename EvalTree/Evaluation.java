package EvalTree;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author Robert
 */
public class Evaluation {

    /**
     * Main class of the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            
            BufferedReader buff = new BufferedReader(new FileReader("arbore.in"));
            PrintStream ps = new PrintStream("arbore.out");
           
            String CurrentLine;
            HashMap<String, Node> map = new HashMap<>();
            NodeFactory nodef = new NodeFactory();
            
            while((CurrentLine = buff.readLine()) != null) {
            
                String[] str = CurrentLine.split(" ");
                
                switch(str[0]) {
                    case "int":
                        Node n = nodef.createNode(NodeType.INT);
                        n.setValue(Integer.parseInt(str[3].replace(";", "")));
                        map.put(str[1], n);
                        break;
                    
                    case "double":
                        n = nodef.createNode(NodeType.DOUBLE);
                        n.setValue(Double.parseDouble(str[3].replace(";", "")));
                        map.put(str[1], n);
                        break;
                    
                    case "string":
                        n = nodef.createNode(NodeType.STRING);
                        n.setValue(CurrentLine.substring(7 + str[1].length() + 4, CurrentLine.length() - 2));
                        map.put(str[1], n);
                        break;
      
                        
                    case "eval":
                        String expression = CurrentLine.substring(str[0].length() + 1, CurrentLine.length() - 1);
                        EvaluationTree et = new EvaluationTree(expression, map);
                        TreeNode node = et.ConstrucPostfixTree(et.getPostfixExpression(), map);
                        Node N = et.Evaluate(et.getPostfixExpression(), map);
                        //DecimalFormat df = new DecimalFormat("0.0#");
                        if (N.getType().equals(NodeType.DOUBLE) && !N.getNaN()) {
                            ps.println((double) Math.round((double) N.getValue() * 100) / 100);
                        } 
                        else {
                            ps.println(N.getValue().toString());
                        }
                        break;
                }
            
            }
            ps.close();
            buff.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

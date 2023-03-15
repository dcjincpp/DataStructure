// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    ExpressionTree class that is a binary tree that creates and solves an expression tree
//
import java.util.Iterator;
public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface
{
    /** Creates an expression tree using a postorder array of string
     * @param postfix A String array of a postorder equation
     */
    public ExpressionTree(String[] postfix)
    {
        super();
        StackInterface<BinaryTree<String>> treeStack = new LinkedStack<>();
        int i = 0;
        BinaryTree<String> rhs, lhs;
        while(i < postfix.length)
        {
            String nextString = postfix[i];
            
            switch (nextString)
            {   
                
                case "+":
                    rhs = treeStack.pop();
                    lhs = treeStack.pop();
                    treeStack.push(new BinaryTree(nextString, lhs, rhs));
                    break;
                
                case "-":
                    rhs = treeStack.pop();
                    lhs = treeStack.pop();
                    treeStack.push(new BinaryTree(nextString, lhs, rhs));
                    break;
                    
                case "*":
                    rhs = treeStack.pop();
                    lhs = treeStack.pop();
                    treeStack.push(new BinaryTree(nextString, lhs, rhs));
                    break;
                    
                case "/":
                    rhs = treeStack.pop();
                    lhs = treeStack.pop();
                    treeStack.push(new BinaryTree(nextString, lhs, rhs));
                    break;
                    
                default:
                    treeStack.push(new BinaryTree(nextString));
                    break;
            }
            i++;
        }
        setRootNode(treeStack.pop().getRootNode());
        
    }
    
    @Override
    public double evaluate()
    {
        return evaluate(getRootNode());
    }
    
    private double evaluate(BinaryNode<String> rootNode)
    {
        double result;
        
        if (rootNode == null)
        {
            result = 0;
        } else if (rootNode.isLeaf()) {
            String variable = rootNode.getData();
            result = getValueOf(variable);
        } else {
            double firstOperand = evaluate(rootNode.getLeftChild());
            double secondOperand = evaluate (rootNode.getRightChild());
            String operator = rootNode.getData();
            result = compute(operator, firstOperand, secondOperand);
        }
        
        return result;
    }
    
    private double getValueOf(String variable)
    {
        double value = Double.parseDouble(variable);
        return value;
    }
    
    private double compute(String operator, double firstOperand, double secondOperand)
    {
        double result = 0;
        switch (operator)
        {
            case "+":
                result = firstOperand + secondOperand;
                break;
                
            case "-":
                result = firstOperand - secondOperand;
                break;
                
            case "*":
                result = firstOperand * secondOperand;
                break;
                
            case "/":
                result = firstOperand / secondOperand;
                break;
                
            default:
                System.out.println("Not a valid operator");
                break;
        }
        
        return result;
    }
    
    public void postorder()
    {
        Iterator<String> iterator = getPostorderIterator();
        String iterated;
        StackInterface<String> stack = new LinkedStack<>();
        while(iterator.hasNext())
        {
            iterated = iterator.next();
            switch(iterated)
            {
                case "+": case"-": case"/": case"*":
                    String rhs = stack.pop();
                    String lhs = stack.pop();
                    System.out.println(lhs + " : " + iterated + " : " + rhs);
                    stack.push(iterated);
                    break;
                    
                default:
                    System.out.println(iterated);
                    stack.push(iterated);
                    break;
            }
        }
    }

}

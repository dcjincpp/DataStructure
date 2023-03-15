// 
//  Name:    Jin, David 
//  Project: #3
//  Due:     10/21/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    A utility class that has two methods, one for converting a string array infix expression into a postfix
//    and the other for evaluating and solving a string array postfix expression
//
import java.util.*;

/**A utility class to be used in ExpressionTest.
 * @author David Jin
 */
public class Expression {
    
    private Expression()
    {
        
    }
    
    /** converts an infix expression into a postfix expression
     * @param infixExpression A String array of operands and operators in the infix form
     * @return The postfix expression of the infix expression
     */
    public static String[] convertToPostfix(String[] infixExpression)
    {
        String nextString;
        String topOperator;
        StackInterface<String> operatorStack = new LinkedStack<>();
        int i = 0;
        ArrayList<String> alPostFix = new ArrayList<>();
        while(i<infixExpression.length)
        {
            nextString = infixExpression[i];
            
            
                    
            switch (nextString)
            {   
                case "^":
                    operatorStack.push(nextString);
                    break;
                
                case "+":
                    while(!operatorStack.isEmpty() && !operatorStack.peek().equals("("))
                    {
                        alPostFix.add(operatorStack.pop());
                    }
                    operatorStack.push(nextString);
                    break;
                
                case "-":
                    while(!operatorStack.isEmpty() && !operatorStack.peek().equals("("))
                    {
                        alPostFix.add(operatorStack.pop());
                    }
                    operatorStack.push(nextString);
                    break;
                    
                case "*":
                    while(!operatorStack.isEmpty() && (operatorStack.peek().equals("^") || operatorStack.peek().equals("/")))
                    {
                        alPostFix.add(operatorStack.pop());
                    }
                    operatorStack.push(nextString);
                    break;
                    
                case "/":
                    while(!operatorStack.isEmpty() && (operatorStack.peek().equals("^") || operatorStack.peek().equals("*")))
                    {
                        alPostFix.add(operatorStack.pop());
                    }
                    operatorStack.push(nextString);
                    break;
                    
                case "(":
                    operatorStack.push(nextString);
                    break;
                    
                case ")":
                    topOperator = operatorStack.peek();
                    while(!(topOperator.equals("(")) && !operatorStack.isEmpty())
                    {
                        alPostFix.add(topOperator);
                        operatorStack.pop();
                        topOperator = operatorStack.peek();
                    }
                    operatorStack.pop();
                    break;
                    
                default:
                    alPostFix.add(nextString);
                    break;
            }
            i++;
        }
        
        while(!operatorStack.isEmpty())
        {
            topOperator = operatorStack.pop();
            alPostFix.add(topOperator);
        }
        
        String[] postFix = alPostFix.toArray(new String[0]);
        alPostFix.clear();
        
        return postFix;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**Solves a postfix expression
     * @param postfixExpression A String array of operands and operators in the postfix form
     * @return The answer of the postfix expression
     */
    public static double evaluatePostFix(String[] postfixExpression)
    {
        StackInterface<Double> valueStack = new LinkedStack<>();
        int i = 0;
        String nextString;
        double result;
        double rhs;
        double lhs;
        while(i<postfixExpression.length)
        {
            nextString = postfixExpression[i];
            switch(nextString)
            {   
                case "+":
                   rhs = valueStack.pop();
                   lhs = valueStack.pop();
                   result = lhs + rhs;
                   valueStack.push(result);
                   break;
                   
                case "-":
                   rhs = valueStack.pop();
                   lhs = valueStack.pop();
                   result = lhs - rhs;
                   valueStack.push(result);
                   break;
                   
                case "*":
                   rhs = valueStack.pop();
                   lhs = valueStack.pop();
                   result = lhs * rhs;
                   valueStack.push(result);
                   break;
                   
                case "/":
                   rhs = valueStack.pop();
                   lhs = valueStack.pop();
                   result = lhs / rhs;
                   valueStack.push(result);
                   break;
                   
                case "^":
                   rhs = valueStack.pop();
                   lhs = valueStack.pop();
                   result = Math.pow(lhs, rhs);
                   valueStack.push(result);
                   break;
                   
                default:
                    valueStack.push(Double.parseDouble(nextString));
                    break;
            }
            i++;
                    
        }
        
        return valueStack.pop();
    }
}

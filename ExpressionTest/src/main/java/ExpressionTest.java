// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Creates an expression tree by inputting a post order equation in the command line and prints out the answer.
//
public class ExpressionTest {
    
    public static void main (String[] args)
    {
        System.out.println("Expression Tree by D. Jin");
        System.out.println();
        System.out.print("Input:");
        for (String x : args)
        {
            System.out.print(" " + x);
        }
        System.out.println();
        
        ExpressionTree equation = new ExpressionTree(args[0].split(" "));
        
        System.out.println("Value: " + equation.evaluate());
        System.out.println();
        System.out.println("Postorder Traversal:");
        equation.postorder();
    }
}

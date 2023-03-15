// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description:
//    Expression tree interface that extends the binary tree interface
//
public interface ExpressionTreeInterface extends BinaryTreeInterface<String>
{
    /** Solves the expression tree
     * @return The answer after solving the expression tree
     */
    public double evaluate();
}

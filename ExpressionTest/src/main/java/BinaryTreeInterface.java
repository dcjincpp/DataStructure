// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Binary tree interface that extends the tree and tree iterator interface that makes the tree only have 2 children
//
public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>
{
    /** Sets the binary tree to a new one node binary tree. 
     * @param rootData The object that is the data for the new tree's root
     */
    public void setTree(T rootData);
    
    /** Sets this binary tree to a new binary tree.
     * @param rootData The object that is the data for the new tree's root
     * @param leftTree The left subtree of the new tree.
     * @param rigtTree The right subtree of the new tree.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rigtTree);

}

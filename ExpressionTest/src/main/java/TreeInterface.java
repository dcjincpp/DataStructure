// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Tree interface with methods for a tree ADT
//
public interface TreeInterface<T>
{
    /** Gets the data of the root node of the tree
     * @return T, data of the root node
     */
    public T getRootData();
    
    /** Gets the height of the tree
     * @return int, the height of the tree
     */
    public int getHeight();
    
    /** Gets the number of nodes in the tree
     * @return int, the number of nodes in the tree
     */
    public int getNumberOfNodes();
    
    /** Checks to see if the tree is empty
     * @return True or false whether the tree is empty
     */
    public boolean isEmpty();
    
    /** Clears the tree
     */
    public void clear();
}

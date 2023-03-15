// 
//  Name:    Jin, David 
//  Project: #3
//  Due:     10/21/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    StackInterface ADT with the needed methods
//
import java.util.EmptyStackException;
/**An interface that describes the operations of a stack of objects
*@author David Jin
* @param <T> Generic
*/
public interface StackInterface<T>
{
    /**Adds a new entry to the top of the stack
     * @param newEntry The new item to be added onto the stack
     */
    public void push(T newEntry);
    
    /**Removes and returns the stack's top entry
     * @return The item at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation
     */
    public T pop();
    
    /**Retrieves the stacks top entry
     * @return The item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek();
    
    /**Detects whether the stack is empty
     * @return True if the stack is empty, false if not
     */
    public boolean isEmpty();
    
    /**Removes all entries from the stack
     */
    public void clear();
}//end STack Interface
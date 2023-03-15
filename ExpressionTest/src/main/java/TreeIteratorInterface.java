// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Tree iterator interface with postorder method
//
import java.util.Iterator;
public interface TreeIteratorInterface<T>
{
    /** Creates an iterator that traverses a tree in postorder.
     * @return An iterator that traverses a tree in post order
     */
    public Iterator<T> getPostorderIterator();
}

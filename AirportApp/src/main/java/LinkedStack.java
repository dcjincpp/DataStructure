// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              A generic linkedlist that implements the StackInterface 
//
import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;
    
    /** Creates a linked list with the first node pointing to null.
     */
    public LinkedStack()
    {
        topNode = null;
    }
    
    @Override
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry);
        newNode.next = topNode;
        topNode = newNode;
    }
    
    @Override
    public T pop()
    {
        T removed;
        if(topNode != null)
        {
        removed = topNode.data;
        topNode = topNode.next;   
        } else {
            throw new EmptyStackException();
        }
        return removed;
    }
    
    @Override
    public T peek()
    {
        T top = null;
        if(!isEmpty())
        {
            top = topNode.data;
        } else {
            throw new EmptyStackException();
        }
        return top;
    }
    
    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    }
    
    @Override
    public void clear()
    {
        while(!isEmpty())
        {
            pop();
        }
    }
    
    
    private class Node
    {
        private T data;
        private Node next;
        
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    }
}

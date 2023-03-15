// 
//  Name:    Jin, David 
//  Project: #2
//  Due:     10/7/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//          LinkedSet class that implements the SetInterface abstract data type and creates the methods needed plus 3 additional methods
//          subset, equals, and union
//
public final class LinkedSet<T> implements SetInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;
    /** Creates a linked list with the first node pointing to null and starting the number of entries at 0.
     */
    public LinkedSet()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    @Override
    public boolean add(T newEntry)
    {
        boolean added = true;
        Node newNode = new Node(newEntry);
        
        if(isEmpty())
        {
            firstNode = newNode;
            numberOfEntries++;
        } else if(!contains(newEntry))
        {
        newNode.next = firstNode;
        firstNode = newNode;
        
        numberOfEntries++;
        } else {
            added = false;
        }
        
        return added;
    }
    
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Integer[numberOfEntries];
        Node currentNode = firstNode;
        int i = 0;
        
        while(currentNode != null)
        {
            result[i] = currentNode.data;
            i++;
            currentNode = currentNode.next;
        }
        return result;
    }
    
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    
    @Override
    public boolean isEmpty()
    {
        boolean result = false;
        
        if(numberOfEntries == 0)
        {
            result = true;
            return result;
        } else {
            return result;
        }
    }
    
    @Override
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        
        while((currentNode != null) && found != true)
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        
        return found;
    }
    
    @Override
    public boolean remove(T anEntry)
    {
        boolean removed = false;
        Node currentNode = firstNode;
        while((currentNode.next != null) && removed != true)
        {
            if(anEntry.equals(currentNode.data))
            {
                currentNode.data = firstNode.data;
                firstNode = firstNode.next;
                numberOfEntries--;
                removed = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        
        return removed;
    }
    
    @Override
    public T remove()
    {
        T node = null;
        if((numberOfEntries != 0) && (firstNode != null))
        {
        node = firstNode.data;
        firstNode = firstNode.next;
        numberOfEntries--;
        }
        
        return node;
    }
    
    @Override
    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

    @Override
    public boolean subset(SetInterface<T> rhs)
    {
        boolean sub = true;
        Node currentNode = firstNode;
        
        while(currentNode != null)
        {
            if((this != null) && !(rhs.contains(currentNode.data)))
            {
                sub = false;
            }
            currentNode = currentNode.next;
        }
        
        return sub;
    }

    @Override
    public boolean equals(SetInterface<T> rhs)
    {
        boolean equal = false;
        if((numberOfEntries == rhs.getCurrentSize()) && (subset(rhs)))
        {
            equal = true;
        }
        
        return equal;
    }
    
    @Override
    public SetInterface union(SetInterface<T> rhs)
    {
        Node currentNode = firstNode;
        SetInterface<T> c = new LinkedSet<>();
        while(currentNode != null)
        {
            c.add(currentNode.data);
            currentNode = currentNode.next;
        }

        LinkedSet n = (LinkedSet) rhs;
        currentNode = n.firstNode;
        while(currentNode != null)
        {
            c.add(currentNode.data);
            currentNode = currentNode.next;
        }        
        
        return c;
    }
    
    @Override
    public String toString()
    {
        
        StringBuilder set = new StringBuilder();
        Node currentNode = firstNode;
        
        if(isEmpty())
        {
            return "{}";
        } else {
            for(int i = 0; i<numberOfEntries - 1; i++)
            {
            set.append(currentNode.data);
            set.append(",");
            currentNode = currentNode.next;
            }
            
            set.append(currentNode.data);
            
            return "{ " + set + " }";
        }
    }
    
    
    private class Node
    {
        private T data;
        private Node next;
        
        private Node (T dataPortion)
        {
            this(dataPortion, null);
        }
        
        private Node (T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
        
    }
}

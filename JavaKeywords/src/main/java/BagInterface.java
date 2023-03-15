// 
//  Name:    Jin, David 
//  Project: #1
//  Due:     9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Creates the methods needed in the BagInterface
//
public interface BagInterface<T> {
    
    public int getCurrentSize();
    
    public boolean isEmpty();
    
    public boolean add(T newEntry);
    
    public T remove();
    
    public boolean remove (T anEntry);
    
    public void clear();
    
    public int getFrequencyOf(T anEntry);
    
    public boolean contains(T anEntry);
    
    public T[] toArray();
    
}

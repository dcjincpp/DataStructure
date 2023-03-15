// 
//  Name:    Jin, David 
//  Project: #2
//  Due:     10/7/2022
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//          The SetInterface and all the methods required
//
/**
 *An interface that describes the operations of a set of objects
 * @author David Jin
 * @param <T>
 */
public interface SetInterface<T>
{
    /** Gets the number of entries inside this set.
     * @return The integer representing the number of entries in the set
     */
    public int getCurrentSize();
    
    /** Checks whether the bag is empty
     * @return True if the bag is empty, false if not
     */
    public boolean isEmpty();
    
    /** Adds a new entry to this set, avoiding duplicates.
     * @param newEntry The item that is to be added as a new entry.
     * @return True if the addition was successful, or false if the item is already in the set
     */
    public boolean add(T newEntry);
    
    /** Removes a specific entry from this set, if possible.
     * @param anEntry The entry that should be removed
     * @return True if the item was removed, false if not
     */
    public boolean remove(T anEntry);
    
    /**Removes an unspecified entry in the set, if possible
     * @return The removed entry, if the removal was successful, null if not
     */
    public T remove();
    
    /** Removes all entries from this set
     */
    public void clear();
    
    /** Checks this set to see if it contains a specified entry
     * @param anEntry The entry to be found
     * @return True if the bag contains the entry, or false if not
     */
    public boolean contains(T anEntry);
    
    /** Copies all entries in the set into an array
     * @return A new array of all the entries in the set
     */
    public T[] toArray();
    
    /** Checks to see if this set is a subset of the SetInterface set on the right hand side.
     * @param rhs A generic SetInterface set
     * @return True if this set is a subset of the set on the right hand side, false if not
     */
    public boolean subset(SetInterface<T> rhs);
    
    /** Checks to see if this set equals the SetInterface set on the right hand side.
     * @param rhs A generic SetInterface set
     * @return True if this set is equal to the set of the right hand side, false if not
     */
    public boolean equals(SetInterface<T> rhs);
    
    /** Creates a new SetInterface set by adding this set and the SetInterface set on the right hand side with no duplicates
     * @param rhs A generic SetInterface set
     * @return A new SetInterface set
     */
    public SetInterface union(SetInterface<T> rhs);
    
    /** Formats the toString of a set a certain way
     * @return String
     */
    @Override
    public String toString();
} //end SetInterface
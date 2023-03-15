// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              The Dictionary ADT and all its required methods
//
import java.util.Iterator;

public interface DictionaryInterface<K, V>
{
    /** Adds an entry into to the dictionary
     * @param key Adds the key for the entry
     * @param value Adds the value connected to the key in the entry
     * @return Returns the value added
     */
    public V add(K key, V value);
    
    /** Removes the key and value of the entry with the given key
     * @param key The key of the entry to be removed
     * @return The value of the entry of the key
     */
    public V remove(K key);
    
    /** Returns the value of the given key
     * @param key The key of the entry for the value
     * @return The value of the entry of the key
     */
    public V getValue(K key);
    
    /** Checks to see if the dictionary contains the key
     * @param key The key to check if it contains
     * @return True or false whether the key is in the dictionary or not
     */
    public boolean contains(K key);
    
    /** Creates an Iterator of the keys
     * @return An iterator of the keys
     */
    public Iterator<K> getKeyIterator();
    
    /** Creates an iterator of the values
     * @return An iterator of the values
     */
    public Iterator<V> getValueIterator();
    
    /** Check to see if the dictionary is empty
     * @return True or false if the dictionary is empty or not
     */
    public boolean isEmpty();
    
    /** Returns the number of entries in the dictionary
     * @return An int value of the number of entries
     */
    public int getSize();
    
    /** Removes all the entries in the dictionary
     */
    public void clear();
}

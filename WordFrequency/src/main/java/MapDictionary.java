// 
//  Name:      Jin, David 
//  Homework:  1 
//  Due:       11/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              A MapDictionary class that implements the dictionary interface using the java.util.map hashmap
//
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDictionary<K, V> implements DictionaryInterface<K, V>
{
    private final Map<K, V> map;
    
    /** Creates a hash map imported from java.util
     */
    public MapDictionary()
    {
        map = new HashMap<>();
    }
    
    @Override
    public V add(K key, V value)
    {
        return map.put(key, value);
    }
    
    @Override
    public V remove(K key)
    {
        return map.remove(key);
    }
            
    @Override
    public V getValue(K key)
    {
        return map.get(key);
    }
    
    @Override
    public boolean contains(K key)
    {
        return map.containsKey(key);
    }
    
    @Override
    public Iterator<K> getKeyIterator()
    {
        Iterator<K> keyIterator = map.keySet().iterator();
        return keyIterator;
    }
    
    @Override
    public Iterator<V> getValueIterator()
    {
        Iterator<V> valueIterator = map.values().iterator();
        return valueIterator;
    }
    
    @Override
    public boolean isEmpty()
    {
        return map.isEmpty();
    }
    
    @Override
    public int getSize()
    {
        return map.size();
    }
    
    @Override
    public void clear()
    {
        map.clear();
    }
    
    
}

// 
//  Name:    Jin, David 
//  Project: #1
//  Due:     9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Creates an ArrayBag class that implements the BagInterface
//
public final class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 256;
    
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayBag(int desiredCapacity){
        if(desiredCapacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
        } else {
            bag = null;
            System.out.println("Desired capacity is too large for bag");
        }
}
    
                @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
                @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for(int index = 0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index])){
                counter++;
            }
        }
        
        return counter;
    }
    
                @Override
    public boolean contains(T anEntry) {
        int index = 0;
        boolean found = false;
        while(!found && index<numberOfEntries) {
            if(anEntry.equals(bag[index])){
                found = true;
            }
            index++;
        }
        
        return found;
    } 
    
            @Override
    public T remove() {
        T removed;
        
        if (!isEmpty()) {
            removed = bag[numberOfEntries-1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;
        } else {
            removed = null;
        }
        return removed;
    }
    
            @Override
    public void clear() {
        while(!isEmpty()) {
            remove();
        }
    }
    
    
            @Override
    public boolean remove (T anEntry) {
        int i;
        boolean result;
        result = true;
        for(i = 0; i<numberOfEntries; i++) {
            if(anEntry.equals(bag[i])) {
                bag[i] = bag[numberOfEntries-1];
                bag[numberOfEntries-1] = null;
                numberOfEntries--;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
    

        @Override
    public boolean isEmpty() {
        
        return numberOfEntries == 0;
    }

        @Override
    public boolean add(T newEntry) {
        boolean result = true;
        if(!isArrayFull()) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } else {
            result = false;
        }
        
        return result;
    }
    
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        
        for(int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }
    
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }
}

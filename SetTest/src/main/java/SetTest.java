// 
//  Name:    Jin, David 
//  Project: #2
//  Due:     10/7/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//          Tests the all the methods in LinkedSet including 5 different cases for subset, equals, and union
//
//
public class SetTest {

    public static void main(String[] args)
    {
        SetInterface<Integer> a = new LinkedSet<>();
        SetInterface<Integer> b = new LinkedSet<>();
        
        System.out.println("Set ADT by D. Jin");
        
        System.out.println("////////////SUBSET////////////SUBSET////////////SUBSET//////////SUBSET////////SUBSET////////////////////");
        
        System.out.println("Subset, Case 1: A and B are equal but distinct sets");
        
        a.add(3);
        a.add(2);
        a.add(1);
        
        b.add(3);
        b.add(1);
        b.add(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        if(a.subset(b) && b.subset(a))
        {
            System.out.println("A and B are subsets of eachother");
        } else {
            System.out.println("The code is wrong");
        }
        
        System.out.println();
        
        System.out.println("Subset, Case 2: A and B are such that they have different sizes, but one is a subset of the other");
        
        a.remove(2);
        a.remove(3);
        b.remove(3);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A is a subset of B: " + a.subset(b));
        System.out.println("B is a subset of A: " + b.subset(a));
        
        System.out.println();
        
        System.out.println("Subset, Case 3: A and B are non-empty and different in size but have common elements");
        
        a.add(2);
        a.add(3);
        
        b.add(5);
        b.add(4);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A is a subset of B: " + a.subset(b));
        System.out.println("B is a subset of A: " + b.subset(a));
        
        System.out.println();
        
        System.out.println("Subset, Case 4: A and B are non-empty with nothing in common");
        
        b.remove(1);
        b.remove(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A is a subset of B: " + a.subset(b));
        System.out.println("B is a subset of A: " + b.subset(a));

        System.out.println();
        
        System.out.println("Subset, Case 5: A is non-empty and B is empty");
        
        b.clear();
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + a);
        
        System.out.println("A is a subset of B: " + a.subset(b));
        System.out.println("B is a subset of A: " + b.subset(a));
        
        a.clear();
        
        System.out.println("////////////UNION////////////UNION////////////UNION//////////UNION////////UNION////////////////////");
        
        System.out.println("Union, Case 1: A and B are equal but distinct sets");
        
        a.add(3);
        a.add(2);
        a.add(1);
        
        b.add(3);
        b.add(1);
        b.add(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("The union of A and B: " + a.union(b));
        
        System.out.println();
        
        System.out.println("Union, Case 2: A and B are such that they have different sizes, but one is a subset of the other");
        
        a.remove(2);
        a.remove(3);
        b.remove(3);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("The union of A and B: " + a.union(b));
        
        System.out.println();
        
        System.out.println("Union, Case 3: A and B are non-empty and different in size but have common elements");
        
        a.add(2);
        a.add(3);
        
        b.add(5);
        b.add(4);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("The union of A and B: " + a.union(b));
        
        System.out.println();
        
        System.out.println("Union, Case 4: A and B are non-empty with nothing in common");
        
        b.remove(1);
        b.remove(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("The union of A and B: " + a.union(b));

        System.out.println();
        
        System.out.println("Union, Case 5: A is non-empty and B is empty");
        
        b.clear();
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("The union of A and B: " + a.union(b));
        
        a.clear();
        
        System.out.println("////////////EQUALS////////////EQUALS////////////EQUALS//////////EQUALS////////EQUALS////////////////////");
        
        System.out.println("Equals, Case 1: A and B are equal but distinct sets");
        
        a.add(3);
        a.add(2);
        a.add(1);
        
        b.add(3);
        b.add(1);
        b.add(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A equals B: " + a.equals(b));
        System.out.println("B equals A: " + b.equals(a));
        
        System.out.println();
        
        System.out.println("Equals, Case 2: A and B are such that they have different sizes, but one is a subset of the other");
        
        a.remove(2);
        a.remove(3);
        b.remove(3);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A equals B: " + a.equals(b));
        System.out.println("B equals A: " + b.equals(a));
        
        System.out.println();
        
        System.out.println("Equals, Case 3: A and B are non-empty and different in size but have common elements");
        
        a.add(2);
        a.add(3);
        
        b.add(5);
        b.add(4);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A equals B: " + a.equals(b));
        System.out.println("B equals A: " + b.equals(a));
        
        System.out.println();
        
        System.out.println("Equals, Case 4: A and B are non-empty with nothing in common");
        
        b.remove(1);
        b.remove(2);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A equals B: " + a.equals(b));
        System.out.println("B equals A: " + b.equals(a));

        System.out.println();
        
        System.out.println("Equals, Case 5: A is non-empty and B is empty");
        
        b.clear();
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("A equals B: " + a.equals(b));
        System.out.println("B equals A: " + b.equals(a));
        
        System.out.println("////////////OTHER METHODS////////////OTHER METHODS////////////OTHER METHODS//////////OTHER METHODS////////OTHER METHODS////////////////////");
        System.out.println("Adding more items to set A for testing methods");
        a.add(12);
        a.add(9);
        a.add(300);
        System.out.println("Set A: " + a);
        System.out.println("A array:");
        for(Integer elements : a.toArray())
        {
            System.out.println(elements);
        }
        System.out.println("Number of entries in set A: " + a.getCurrentSize());
        System.out.println("Removed the last entry: " + a.remove());
        System.out.println("Set A: " + a);
        System.out.println("Removed 1: " + a.remove(1));
        System.out.println("Set A: " + a);
        a.clear();
        System.out.println("Cleared A");
        if(a.isEmpty()){
        System.out.println("Set A: " + a);
        } else {
            System.out.println("Is not empty");
        }
        System.out.println("FINISHED");
    }
}

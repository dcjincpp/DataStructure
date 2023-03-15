// 
//  Name:    Jin, David 
//  Project: #1
//  Due:     9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Creates an ArrayBag that has all the java keywords from "javakeywords.txt" 
//    and tests all the methods in the bag interface
//

import java.io.*;
import java.util.Scanner;

public class JavaKeywords {

    public static void main(String[] args) throws FileNotFoundException 
    {
        BagInterface<String> keyWords = new ArrayBag<>(256);
        Scanner inputFile = new Scanner(new File("JavaKeywords.txt"));
        
        
        while (inputFile.hasNext()) {
            keyWords.add(inputFile.nextLine());
        }
        inputFile.close();
        
        System.out.println("Java Keywords by D. Jin");
        System.out.println();
        System.out.println(keyWords.getCurrentSize() + " Java keywords loaded.");
        System.out.println();
        
        for(String words: args) {
            if(keyWords.contains(words)) {
            System.out.println(words + " is a key word");
        } else {
            System.out.println(words + " is not a key word");
            }
        }
        System.out.println();
        System.out.println("////////////////////////////////TESTING OUTPUTS///////////////////////////////////////////////////");
        System.out.println("All the keywords in the bag");
        for(Object x:keyWords.toArray()) {
            System.out.println(x);
        }
        
        System.out.println();
        System.out.println("Removed " + keyWords.remove());
        System.out.println("Entries is now " + keyWords.getCurrentSize());
        System.out.println();
        
        System.out.println("The bag contains 'while' " + keyWords.getFrequencyOf("while") + " times");
        System.out.println();
        
        if (keyWords.remove("while")){
        
        System.out.println("'while' is no longer in the bag");
        } else {
            System.out.println("Could not remove");
        }
        
        System.out.println("Entries is now " + keyWords.getCurrentSize());
        System.out.println();
        
        keyWords.clear();
        System.out.println("Bag is cleared");
        
        if(keyWords.isEmpty()){
            System.out.println("The bag is empty");
            System.out.println("Entries is now " + keyWords.getCurrentSize());
        }
        
    }     
}

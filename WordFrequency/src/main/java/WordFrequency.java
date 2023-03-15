// 
//  Name:      Jin, David 
//  Homework:  1 
//  Due:       11/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Counts and prints out the frequency of words in the U.S. Constitution and how many unique words there are.
//
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class WordFrequency {

    public static void main(String[] args) throws FileNotFoundException {
        
        DictionaryInterface<String, Number> constitution = new MapDictionary<>();
        
        Scanner inputFile = new Scanner(new File("usconstitution.txt"));
        inputFile.useDelimiter("\\W+");
        while(inputFile.hasNext())
        {
            String nextWord = inputFile.next();
            if(nextWord.matches("[a-zA-Z]+"))
            {
                nextWord = nextWord.toLowerCase();
                Number frequency = constitution.getValue(nextWord);

                if(frequency == null)
                {
                    constitution.add(nextWord, new Number(1));
                } else {
                    frequency.plusOne();
                    constitution.add(nextWord, frequency);
                }
            }
        }
        inputFile.close();
        
        Iterator<String> key = constitution.getKeyIterator();
        
        int total = constitution.getSize();
        
        System.out.println("Word Frequency by D. Jin");
        System.out.println();
        System.out.println("Count Word");
        System.out.println("----- --------------------");
        while(key.hasNext())
        {
            String i = key.next();
            System.out.printf("%5d %s\n", constitution.getValue(i).getNumber(), i);

        }
        
        System.out.println("Total = " + total);
    }
}

// 
//  Name:      Jin, David 
//  Homework:  1 
//  Due:       11/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              A class that makes it easier and faster to increment the value of an entry compared to using an Integer
//
public class Number {
    private int i;
    
    /** Creates a Number object and sets the primitive int i into the given parameter
     * @param i Initial count 
     */
    public Number(int i)
    {
        this.i = i;
    }
    
    /** Adds 1 to the value of i
     */
    public void plusOne()
    {
        i++;
    }
    
    /** Returns the value of i
     * @return the int i
     */
    public int getNumber()
    {
        return i;
    }
}

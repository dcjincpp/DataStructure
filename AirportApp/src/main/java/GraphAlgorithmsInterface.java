// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Interface for graph algorithms
//
public interface GraphAlgorithmsInterface<T> {
    
    /** Finds the least-cost path between two vertices in a graph
     * @param begin An object that labels the path's origin vertex
     * @param end An object that labels the path's destination vertex
     * @param path An empty stack of labels
     * @return The cost of the cheapest path or 0 if there is no path
     */
    public double getCheapestPath(T begin, T end, StackInterface<T> path);
    
}

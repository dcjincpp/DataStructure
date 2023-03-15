// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Interface for a basic graph
//
public interface BasicGraphInterface<T> {
    
    /** Adds a vertex with the input label to the graph
     * @param vertexLabel An object that labels the new vertex and is distinct from the other labels currently in the graph
     * @return True if the vertex was added, false if not
     */
    public boolean addVertex(T vertexLabel);
    
    /** Adds an edge with a weight between 2 already existing vertex that do not already have an edge between the begin vertex and end vertex.
     * In a directed graph, the edge is only one way, from the begin vertex to end vertex
     * @param begin An object that labels the origin vertex of the edge
     * @param end An object, distinct from the beginning, that labels the end vertex of the edge
     * @param edgeWeight The real value of the edge's weight
     * @return True if the edge was added, false if not
     */
    public boolean addEdge(T begin, T end, double edgeWeight);
    
    /** Removes an existing edge between two points in a directed graph
     * @param begin An object that labels the origin vertex of the edge
     * @param end An object that labels the end vertex of the edge, a neighbor to the start edge
     * @return True if the edge was removed, false if it could not be removed
     */
    public boolean removeEdge(T begin, T end);
    
    /** Sees whether an edge between two given vertices exist
     * @param begin An object that labels the origin vertex of the edge
     * @param end An object that labels the end vertex of the edge
     * @return True if the edge exists, false if not
     */
    public boolean hasEdge(T begin, T end);
    
    /** Sees whether the graph is empty or not
     * @return True if the graph is empty, false if not
     */
    public boolean isEmpty();
    
    /** Gets the number of vertices in the graph
     * @return The number of vertices in the graph
     */
    public int getNumberOfVertices();
    
    /** Gets the number of edges in the graph
     * @return The number of edges in the graph
     */
    public int getNumberOfEdges();
    
    /** Removes all vertices and edges from the graph
     */
    public void clear();
}

// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Interface for Vertex with required methods
//
import java.util.Iterator;

public interface VertexInterface<T> {
    
    public T getLabel();
    
    public void visit();
    
    public void unvisit();
    
    public boolean isVisited();
    
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight);
    
    public boolean disconnect(VertexInterface<T> endVertex);
    
    public Iterator<VertexInterface<T>> getNeighborIterator();
    
    public Iterator<Double> getWeightIterator();
    
    public VertexInterface<T> getUnvisitedNeighbor();
    
    public void setPredecessor(VertexInterface<T> predecessor);
    
    public VertexInterface<T> getPredecessor();
    
    public boolean hasPredecessor();
    
    public void setCost(double newCost);
    
    public double getCost();
    
}

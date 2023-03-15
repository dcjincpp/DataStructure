// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Directed graph class that implements the graph ADT and has all methods required in the interfaces extended by GraphInterface
//
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class DiGraph<T> implements GraphInterface<T> {
    
    private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;
    
    /** Creates an empty directed graph
     */
    public DiGraph()
    {
        vertices = new MapDictionary<>();
        edgeCount = 0;
    }
    
    @Override
    public boolean addVertex(T vertexLabel)
    {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }
    
    public boolean removeEdge(T begin, T end)
    {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        
        if((vertices.contains(begin)) && (vertices.contains(end)) && !vertices.isEmpty())
        {
            result = beginVertex.disconnect(endVertex);
        }
        
        if(result)
        {
            edgeCount--;
        }
        
        return result;
    }
    
    @Override
    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;
        
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        
        if((beginVertex != null) && (endVertex != null))
        {
            result = beginVertex.connect(endVertex, edgeWeight);
        }
        
        if(result)
        {
            edgeCount++;
        }
        
        return result;
    }
    
    @Override
    public boolean hasEdge(T begin, T end)
    {
        boolean found = false;
        
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        
        if((beginVertex != null) && (endVertex != null))
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while(!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor))
                {
                    found = true;
                }
            }
        }
        return found;
    }
    
    @Override
    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }
    
    @Override
    public int getNumberOfVertices()
    {
        return vertices.getSize();
    }
    
    @Override
    public int getNumberOfEdges()
    {
        return edgeCount;
    }
    
    @Override
    public void clear()
    {
        vertices.clear();
        edgeCount = 0;
    }
    
    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while(vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }
    
    @Override
    public double getCheapestPath(T begin, T end, StackInterface<T> path)
    {
        resetVertices();
        boolean done = false;
        double pathCost;
        PriorityQueue<EntryPQ> pQ = new PriorityQueue<>();
        
        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        
        pQ.add(new EntryPQ(originVertex, 0, null));
        try {
            while(!done && !pQ.isEmpty())
            {
                EntryPQ frontEntry= pQ.poll();
                VertexInterface<T> frontVertex = frontEntry.label;
                Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                Iterator<Double> weights = frontVertex.getWeightIterator();
                if(!frontVertex.isVisited())
                {
                    frontVertex.visit();
                    frontVertex.setCost(frontEntry.cost);
                    frontVertex.setPredecessor(frontEntry.predecessor);
                    if(frontVertex.equals(endVertex))
                    {
                        done = true;
                    } else {
                        while(neighbors.hasNext())
                        {
                            VertexInterface<T> nextNeighbor = neighbors.next();
                            double nextWeights = weights.next();
                            if(!nextNeighbor.isVisited())
                            {
                                double nextCost = nextWeights + frontVertex.getCost();
                                nextNeighbor.setPredecessor(frontVertex);
                                nextNeighbor.setCost(nextCost);
                                pQ.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                            }

                        }
                    }
                }
            }
        
            pathCost = endVertex.getCost();
            path.push(endVertex.getLabel());
            VertexInterface<T> vertex = endVertex;
            while(vertex.hasPredecessor())
            {
                vertex = vertex.getPredecessor();
                path.push(vertex.getLabel());
            }
        } catch (Exception e) {
            pathCost = 0;
        }
        
        return pathCost;
    }
    
    class EntryPQ implements Comparable<EntryPQ>
    {
        private VertexInterface<T> label;
        private double cost;
        private VertexInterface<T> predecessor;
        
        public EntryPQ(VertexInterface<T> newLabel, double newCost, VertexInterface<T> newPredecessor)
        {
            label = newLabel;
            cost = newCost;
            predecessor = newPredecessor;
        }
        
        @Override
        public int compareTo(EntryPQ rhs)
        {
            if(cost < rhs.cost)
            {
                return -1;
            } else if (cost > rhs.cost) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    class Vertex<T> implements VertexInterface<T> {
        
        private LinkedList<Edge> edgeList;        
        private T label;
        private boolean visited;
        private double cost;
        private VertexInterface<T> previousVertex;
        
        public Vertex(T vertexLabel)
        {
            edgeList = new LinkedList<>();
            label = vertexLabel;
            visited = false;
            previousVertex = null;
            cost = 0;
        }
        
        
        @Override
        public T getLabel()
        {
            return label;
        }
        
        @Override
        public void visit()
        {
            visited = true;
        }
        
        @Override
        public void unvisit()
        {
            visited = false;
        }
        
        @Override
        public boolean isVisited()
        {
            return visited;
        }
        
        @Override
        public void setPredecessor(VertexInterface<T> predecessor)
        {
            previousVertex = predecessor;
        }
        
        @Override
        public VertexInterface<T> getPredecessor()
        {
            return previousVertex;
        }
        
        @Override
        public boolean hasPredecessor()
        {
            return previousVertex != null;
        }
        
        @Override
        public void setCost(double newCost)
        {
            cost = newCost;
        }
        
        @Override
        public double getCost()
        {
            return cost;
        }
        
        @Override
        public boolean disconnect(VertexInterface<T> endVertex)
        {
            boolean result = false;
            int index = 0;
            
            if(!this.equals(endVertex))
            {
                Iterator<Edge> connections = edgeList.listIterator();
                
                while(!result && connections.hasNext())
                {
                    VertexInterface<T> nextNeighbor = connections.next().getEndVertex();
                    if(endVertex.equals(nextNeighbor))
                    {
                        edgeList.remove(index);
                        result = true;
                    }
                    index++;
                }
            }
            
            return result;
        }
        
        @Override
        public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
        {
            boolean result = false;
            
            if(!this.equals(endVertex))
            {
                Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
                
                boolean duplicateEdge = false;
                    
                while(!duplicateEdge && neighbors.hasNext())
                {
                    VertexInterface<T> nextNeighbor = neighbors.next();
                    if(endVertex.equals(nextNeighbor))
                    {
                        duplicateEdge = true;
                    }
                }
                    
                if(!duplicateEdge)
                {
                    //////////////////////////////////////////////////////////
                    edgeList.add(new Edge(endVertex, edgeWeight));
                    result = true;
                }
            }
                
            return result;
        }
        
        @Override
        public VertexInterface<T> getUnvisitedNeighbor()
        {
            VertexInterface<T> result = null;
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            while(neighbors.hasNext() && result == null)
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(!nextNeighbor.isVisited())
                {
                    result = nextNeighbor;
                }
            }
            
            return result;
        }
        
        @Override
        public boolean equals(Object rhs)
        {
            boolean result;
            if((rhs == null) || (getClass() != rhs.getClass()))
            {
                result = false;
            } else {
                Vertex<T> rhsVertex = (Vertex<T>)rhs;
                result = label.equals(rhsVertex.label);
            }
            
            return result;
        }
        
        @Override
        public Iterator<Double> getWeightIterator()
        {
            return new WeightIterator();
        }
        
        @Override
        public Iterator<VertexInterface<T>> getNeighborIterator()
        {
            return new NeighborIterator();
        }
        
        protected class Edge
        {
            private VertexInterface<T> vertex;
            private double weight;
            
            protected Edge(VertexInterface<T> endVertex, double edgeWeight)
            {
                vertex = endVertex;
                weight = edgeWeight;
            }
            
            protected VertexInterface<T> getEndVertex()
            {
                return vertex;
            }
            
            protected double getWeight()
            {
                return weight;
            }
        }
        
        private class WeightIterator implements Iterator<Double>
        {
            private Iterator<Edge> weight;
            
            private WeightIterator()
            {
                weight = edgeList.listIterator();
            }
            
            @Override
            public boolean hasNext()
            {
                return weight.hasNext();
            }
            
            @Override
            public Double next()
            {
                double nextWeight = 0;
                if(weight.hasNext())
                {
                    Edge edgeToNextNeighbor = weight.next();
                    nextWeight = edgeToNextNeighbor.getWeight();
                } else {
                    throw new NoSuchElementException();
                }
                
                return nextWeight;
            }
            
            @Override
            public void remove()
            {
                throw new NoSuchElementException();
            }
        }
        
        private class NeighborIterator implements Iterator<VertexInterface<T>>
        {
            private Iterator<Edge> edges;
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            private NeighborIterator()
            {
                edges = edgeList.listIterator();
            }
            
            @Override
            public boolean hasNext()
            {
                return edges.hasNext();
            }
            
            @Override
            public VertexInterface<T> next()
            {
                VertexInterface<T> nextNeighbor = null;
                if(edges.hasNext())
                {
                    Edge edgeToNextNeighbor = edges.next();
                    nextNeighbor = edgeToNextNeighbor.getEndVertex();
                } else {
                    throw new NoSuchElementException();
                }
                
                return nextNeighbor;
            }
            
            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        }
    }
}

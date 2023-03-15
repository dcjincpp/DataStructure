// 
//  Name:    Jin, David 
//  Project: #4
//  Due:     12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Binary tree class that implements the binary tree interface and creates a root node with mutators and accessors to the left and right child
//
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    
    private BinaryNode<T> root;

    public BinaryTree()
    {
        root = null;
    }
    
    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    }
    
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        privateSetTree(rootData, leftTree, rightTree);
    }
    
    @Override
    public void setTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    }
    
    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
    }
    
    private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new BinaryNode<>(rootData);
        
        if ((leftTree != null) && !leftTree.isEmpty())
        {
            root.setLeftChild(leftTree.root);
        }
        
        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
            {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
        }
        
        if ((leftTree !=null) && (leftTree != this))
        {
            leftTree.clear();
        }
        if ((rightTree != null && (rightTree != this)))
        {
            rightTree.clear();
        }
    }
    
    @Override
    public T getRootData()
    {
        if(isEmpty())
        {
            System.out.println("Tree is empty");
            throw new RuntimeException();
        } else {
            return root.getData();
        }
    }
    
    @Override
    public boolean isEmpty()
    {
        return root == null;
    }
    
    @Override
    public void clear()
    {
        root = null;
    }
    
    protected void setRootData(T rootData)
    {
        root.setData(rootData);
    }
    
    protected void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    }
    
    protected BinaryNode<T> getRootNode()
    {
        return root;
    }
    
    @Override
    public int getHeight()
    {
        return root.getHeight();
    }
    
    @Override
    public int getNumberOfNodes()
    {
        return root.getNumberOfNodes();
    }
    
    @Override
    public Iterator<T> getPostorderIterator()
    {
        return new PostorderIterator();
    }
    
    
    
    class BinaryNode<T>
    {
        private T data;
        private BinaryNode<T> leftChild;
        private BinaryNode<T> rightChild;
        
        public BinaryNode()
        {
            this(null);
        }
        
        public BinaryNode(T dataPortion)
        {
            this(dataPortion, null, null);
        }
        
        public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
        {
            data = dataPortion;
            leftChild = newLeftChild;
            rightChild = newRightChild;
        }
        
        public T getData()
        {
            return data;
        }
        
        public void setData(T newData)
        {
            data = newData;
        }
        
        public BinaryNode<T> getLeftChild()
        {
            return leftChild;
        }
        
        public void setLeftChild(BinaryNode<T> newLeftChild)
        {
            leftChild = newLeftChild;
        }
        
        public boolean hasLeftChild()
        {
            return leftChild != null;
        }
        
        public BinaryNode<T> getRightChild()
        {
            return rightChild;
        }
        
        public void setRightChild(BinaryNode<T> newRightChild)
        {
            rightChild = newRightChild;
        }
        
        public boolean hasRightChild()
        {
            return rightChild != null;
        }
        
        public boolean isLeaf()
        {
            return (leftChild == null) && (rightChild == null);
        }
        
        public int getNumberOfNodes()
        {
            int leftNumber = 0;
            int rightNumber = 0;
            
            if (leftChild != null)
            {
                leftNumber = leftChild.getNumberOfNodes();
            }
            
            if (rightChild != null)
            {
                rightNumber = rightChild.getNumberOfNodes();
            }
            
            return 1 + leftNumber + rightNumber;
        }
        
        public int getHeight()
        {
            return getHeight(this);
        }
        
        private int getHeight(BinaryNode<T> node)
        {
            int height = 0;
            if (node != null)
            {
                height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
            }
            
            return height;
        }
        
        public BinaryNode<T> copy()
        {
            BinaryNode<T> newRoot = new BinaryNode<>(data);
            if (leftChild != null)
            {
                newRoot.setLeftChild(leftChild.copy());
            }
            
            if (rightChild != null)
            {
                newRoot.setRightChild(rightChild.copy());
            }
            
            return newRoot;
        }
    }
    
    private class PostorderIterator implements Iterator<T>
    {
        private final StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;
        
        public PostorderIterator()
        {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        }
        
        @Override
        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        }
        
        @Override
        public T next()
        {
            BinaryNode<T> nextNode = null;
            
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
                if (currentNode == null && nodeStack.peek().hasRightChild())
                {
                    currentNode = nodeStack.peek().getRightChild();
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                assert nextNode != null;
                
                if(!(nodeStack.isEmpty()) && nextNode == nodeStack.peek().getLeftChild())
                {
                    currentNode = nodeStack.peek().getRightChild();
                }
            } else {
                throw new NoSuchElementException();
            }
            
            return nextNode.getData();
        }
        
        
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}

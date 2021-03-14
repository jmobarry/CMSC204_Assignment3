
import java.util.Comparator;

/**
 * This is a child class of BasicDoubleLinkedList which is a SortedDoubleLinkedList
 * of generic Type
 * @author John Mobarry
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

    private Comparator<T> comparator;

    /**
     * Constructor for SortedDoubleLinkedList that takes a certain comparator
     * @param comparator
     */
    public SortedDoubleLinkedList (Comparator<T> comparator){
        super();
        this.comparator = comparator;
    }


    /**
     * Method to add elements to the SortedDoubleLinkedList based on comparator
     * @param data
     * @return created list
     */
    public SortedDoubleLinkedList<T> add(T data){

//        iterator = iterator();
        Node t;
        Node nextGuy = firstNode;
        while(nextGuy != null && comparator.compare(data, nextGuy.getData()) >= 0) {
            nextGuy = nextGuy.getNext();
        }

        Node oldPrevious = (nextGuy != null ? nextGuy.getPrevious() : null);

        //empty list
        if(size == 0){
           t = new Node(data, null, null);
           firstNode = lastNode = t;
        }
        //insert at beginning of non empty list
        else if( oldPrevious == null && nextGuy != null){
            t = new Node(data, oldPrevious, nextGuy);
            nextGuy.setPrevious(t);
            firstNode = t;
        }
        //insert at end of non empty list
        else if(nextGuy == null){
            t = new Node(data, lastNode, null);
            lastNode.setNext(t);
            lastNode = t;
        }
        //insert at middle of list
        else{
            t = new Node(data, oldPrevious, nextGuy);
            oldPrevious.setNext(t);
            nextGuy.setPrevious(t);
        }



        size++;
        return this;
    }
//        if(!(comparator.compare(data, nextGuy.getData()) <= 0)) {
//            throw new RuntimeException("We should not have gotten here");
//        }

    /**
     * Method is not supported for this class
     * @param data
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public SortedDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException
    { throw new UnsupportedOperationException(); }

    /**
     * Method is not supported for this class
     * @param data to be added via node
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public SortedDoubleLinkedList<T> addToEnd(T data)   throws UnsupportedOperationException
    { throw new UnsupportedOperationException(); }

}

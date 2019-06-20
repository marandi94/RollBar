package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        int i = 0;
        Node iterator = head;
        System.out.println( " index is " + index);

        while (iterator.getNext() != null){
            System.out.println(" get in into the while loop of get");
            if( i == index){
                //System.out.println("the value of index " + i + "is" + iterator.getData());
                return iterator.getData();
            }
            iterator = iterator.getNext();
        }
        //System.out.println("invalid Index: index > length");
        return head;
    }


    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        int  counter = 0;
        Node iterator = head;
        //System.out.println("iterator == head   " + iterator + "/n");
        while (iterator.getNext() != null){
            //System.out.println(" get in into the while loop of indexof");
            if ( data == iterator.getData()){
                //System.out.println("the counter  " + counter + "corresponds to" + iterator.getData());
                return counter;
            }
            counter++;
            //System.out.println("counter = " + counter + "/n/");
        }
        //System.out.println("there is no corresponding index for the value" + iterator.getData());
        return 0;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {


     return true; // value to change
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        return "Node";
    }
}

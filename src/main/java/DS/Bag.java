package DS;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/24 21:41
 * 4
 */
public class Bag<T> implements Iterable<T> {

    private Node<T> first;

    private int capacity;

    public Bag(){}

    public int size(){
        return capacity;
    }

    public void add(T item){
        Node<T> node = new Node<T>();

        node.setValue(item);
        node.setNext(this.first);

        this.first = node;

        capacity++;

    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }


    private class ListIterator<T> implements Iterator<T>{

        private Node<T> current;

        public ListIterator(Node<T> first){
            this.current = first;
        }

        @Override
        public boolean hasNext() {

            if (current != null){
                return true;
            }

            return false;
        }


        @Override
        public T next() {

            if (!hasNext()){
                throw new NoSuchElementException();
            }

            T item = current.getValue();
            current = current.getNext();
            return item;
        }
    }

}

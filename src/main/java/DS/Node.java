package DS;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/24 21:42
 * 4
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(){}

    public Node(T value){
        this.value = value;
    }

    public Node(T value, Node node){
        this.value = value;
        this.next = node;
    }


    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }


}

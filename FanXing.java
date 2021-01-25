import java.util.Objects;

public class FanXing<E> {
    private E[] arr = null;
    private int size;
    private int capacity = 0;

    public FanXing(int capacity) {
        arr = (E[])new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void add(E data){
        if(size < capacity){
            this.arr[size] = data;
            size++;
        }else{
            return;
        }
    }

    public E get(int index){
        return this.arr[index];
    }

    public static void main(String[] args) {
        FanXing<String> f = new FanXing<>(10);
        f.add("a");
        f.add("b");
        f.add("c");
        f.add("d");
        System.out.println(f.get(2));

    }
}

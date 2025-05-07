interface ILinkedBased { }
interface IArrayBased { }
interface IQueue{
    /**
     * return front without delete .
     */
    public Object front ()throws Exception;
    /**
     * Inserts an item at the queue front.
     */
    public void enqueue(Object item)throws Exception;
    /**
     * Removes the object at the queue rear and returns it.
     */
    public Object dequeue ()throws Exception;
    /**
     * Tests if this queue is empty.
     */
    public boolean isEmpty();
    /**
     * Returns the number of elements in the queue
     */
    public int size();
}

class queue1 implements IQueue   {
    int f, r, N;
    Object[] arr;

    public queue1 (int n) {
        f = r = 0;
        arr =  new Object[n];
        N = n;
    }

    public queue1() {
        this(1000);
    }

    public int size() {
        return (N - f + r) % N;
    }
    public boolean isEmpty() {
        return f == r;
    }
    public Object front() throws Exception {
        if (f == r) {
            throw new Exception();
        }
        return arr[f];

    }
    public Object dequeue() throws Exception {
        if (f == r) {
            throw new Exception();
        }
        Object temp = arr[f];
        f = (f + 1) % N;
        return temp;
    }
    public void enqueue(Object o) throws Exception {
        if (this.size() == N - 1) {
            throw new Exception();
        }
        arr[r] = o;
        r = (r + 1) % N;

    }


//   // public T get_last() throws Exception {
//
//        if (f == r) {
//            throw new Exception();
//        }
//        int a;
//        if (r == 0) {
//            a = N - 1;
//        } else {
//            a = r - 1;
//        }
//        return arr[a];
//    }


//    public Object remove_last() throws Exception {
//        if (f == r) {
//            throw new Exception();
//        }
//        if (r == 0) {
//            r = N - 1;
//        } else {
//            --r;
//        }
//
//        return arr[r];
//    }



//    public void insert_first(T o) throws Exception {
//
//        if (this.size() == N - 1) {
//            throw new Exception();
//        }
//        if (f == 0) {
//            f = N - 1;
//        } else {
//            --f;
//        }
//        arr[f] = o;
//    }
//
//


}

class DNode{
    Object value;
    DNode next;

    public DNode(DNode n, Object v) {
        value = v;
        next = n;

    }

    public DNode() {
        this(null, null);
    }
}
class queue2 implements IQueue  {
    DNode header;//dummy
    DNode tail;// point to the last element
    int size;

    public queue2() {
        tail = null;

        header = new DNode(null, null);
        size = 0;
//size()ليه عمل كده
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return header.next.value;
    }

//    public T get_last()throws Exception{
//        if (isEmpty()){
//            throw new Exception();
//        }
//        return tailer.prev.value;
//    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object temp = header.next.value;
        header.next = header.next.next;
        --size;
        return temp;

    }

//    public T remove_last()throws Exception{
//        if (isEmpty()){
//            throw new Exception();
//        }
//        T temp=tailer.prev.value;
//        tailer.prev=tailer.prev.prev;
//        tailer.prev.next=tailer;
//        --size;
//        return temp;
//
//
//    }

//    public void insert_first(T o)throws Exception {
//        //not throws Exeption here
//        DNode<T> i = new DNode<>(header, header.next, o);
//        header.next = i;
//        i.next.prev = i;
//        ++size;
//    }

    public void enqueue(Object o) throws Exception {
        DNode node = new DNode(null, o);

if(tail==null) {
        header.next = node;
        tail=node;
        return;
    }
tail.next=node;
tail=node;
}




}

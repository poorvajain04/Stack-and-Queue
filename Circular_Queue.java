public class Circular_Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int Size = 0;
    public Circular_Queue() {
        this(DEFAULT_SIZE);
    }
    public Circular_Queue(int size) {
        data = new int[size];
    }
    public boolean isFull() {
        return Size == data.length;
    }
    public boolean isEmpty() {
        return Size == 0;
    }
    public boolean insert(int item) {
        if (isFull())
            return false;
        data[end] = item;
        end++;
        end = end % data.length;
        Size++;
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        int d = data[front];
        front++;
        front = front % data.length;
        Size--;
        return d;
    }
    public int front() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return data[front];
    }
    public void display() {
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i]+" ");
            i++;
            i%=data.length;
        }while(i!=end);
        System.out.println("END");
    }
    public static void main(String[] args) throws Exception {
        Circular_Queue queue = new Circular_Queue(5);
        queue.insert(10);
        queue.insert(5);
        queue.insert(7);
        queue.insert(3);
        System.out.println(queue.remove());
        queue.insert(15);
        queue.insert(2);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
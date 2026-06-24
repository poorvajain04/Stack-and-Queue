public class Custom_Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    public Custom_Queue(){
        this(DEFAULT_SIZE);
    }
    int end=0;
    public Custom_Queue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isFull()) return false;
        data[end++]=item;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()) throw new Exception ("Queue is empty");
        int d=data[0];
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return d;
    }
    public int front() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty");
        return data[0];
    }
    public void display(){
        for(int i=0;i<end;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println("END");
    }
    public static void main(String[] args) throws Exception {
        Custom_Queue queue=new Custom_Queue(5);
        queue.insert(10);
        queue.insert(5);
        queue.insert(7);
        queue.insert(3);
        queue.insert(15);
        queue.insert(2);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}

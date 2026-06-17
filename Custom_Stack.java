public class Custom_Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    public Custom_Stack(){
        this(DEFAULT_SIZE);
    }
    int ptr=-1;
    public Custom_Stack(int size){
        this.data=new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    private boolean isFull(){
        return ptr==data.length-1;
    }
    private boolean isEmpty(){
        return ptr==-1;
    }
    public int pop() throws Exception{
        if(isEmpty()) throw new Exception("Cannot remove from empty stack");
        return data[ptr--];
    }
    public int peek() throws Exception{
        if(isEmpty()) throw new Exception("Cannot peek from empty stack");
        return data[ptr];
    }
    public static void main(String[] args) throws Exception {
        Custom_Stack stack=new Custom_Stack(5);
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(15);
        stack.push(2);//stack full, not inserted
        System.out.println("peek="+stack.peek());
        System.out.println("pop1="+stack.pop());
        System.out.println("pop2="+stack.pop());
        System.out.println("empty?="+stack.isEmpty());
        System.out.println("full?="+stack.isFull());
    }

}

public class Dynamic_Stack extends Custom_Stack{
    public Dynamic_Stack(){
        super();
    }
    public Dynamic_Stack(int size){
        super(size);
    }
    public boolean push(int item) {
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(item);
    }
    public static void main(String[] args) throws Exception {
        Dynamic_Stack stack = new Dynamic_Stack(5);
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(15);
        stack.push(2);//stack full, not inserted
        System.out.println("peek=" + stack.peek());
        System.out.println("pop1=" + stack.pop());
        System.out.println("pop2=" + stack.pop());
    }
}

package ots;
/**
*
* @author Scott
*/
public class ImpletementQueue<T>  {
    class Node <T> {
        T val;
        Node next;

        public Node(T val){
            this.val = val;
        }
    }
    Node end;
    Node start;
    int n;
    
    public ImpletementQueue () {
    }
    
    public void offer(T x){
        if(end==null){
            end = new Node(x);
            start = end;
        }else{
            end.next = new Node(x);
            end = end.next;
        }
    }
    
    public T poll(){
        if(start==null) return null;
        Node temp = start;
        start = start.next;
        temp.next = null;
        return (T)temp.val;
    }
    
    public static void main(String[] args){
        ImpletementQueue queue = new ImpletementQueue();
        System.out.println(queue.poll());
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

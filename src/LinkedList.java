public class LinkedList<T> {
    Node<T> head;

    public LinkedList(){
       this.head=null;
    }

    public void add(T data){

        Node<T> newNode=new Node<>(data);

        if(head==null){
            head=newNode;
            return;
        }
        Node<T> temp=head;

        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    public void display(){
        Node<T> temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void reverse(){
        //1->2->3->null
        //3<-2<-1 null
        Node<T> prevNode=null;
        Node<T> currNode=head;
        Node<T> nextNode;

        while(currNode!=null){
            nextNode=currNode.next; //store

            currNode.next=prevNode;

            prevNode=currNode;

            currNode=nextNode;
        }

        head=prevNode;

    }

    public static void main(String [] args){
        LinkedList<Integer> linkedList=new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(0);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(23);
        linkedList.add(14);

        linkedList.display();

        System.out.println("Reverse LinkedList");

        linkedList.reverse();
        linkedList.display();

    }
}

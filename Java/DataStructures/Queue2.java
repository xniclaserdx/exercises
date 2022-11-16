public class Queue<ContentType>
{
    private Node<ContentType> head;
    private Node<ContentType> tail;

    public Queue() {
        head=null;
        tail=null;
    }
    public boolean isEmpty() {
        return head==null;
    }
    public void enqueue(ContentType pContent){
        if(pContent!=null){
              Node<ContentType> newNode= new Node<ContentType>(pContent);
              if(this.isEmpty()){
				  tail= newNode;
				  head= newNode;
              }else{
				  tail.setNext(newNode);
			      tail= newNode;
			  }
        }
    }
    public void dequeue(){
        if(!this.isEmpty()){
            head=head.getNext();
            if(this.isEmpty()){

                head=null;
                tail=null;
            }
        }
    }
    public ContentType front(){
        if(this.isEmpty()){
            return null;
        }else{
            return head.getContent();
        }
    }
}
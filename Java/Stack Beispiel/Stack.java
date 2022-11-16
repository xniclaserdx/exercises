class Stack<ContentType>{
  private Node<ContentType> top;

  public Stack(){
     top=null;
  } // Konstruktor

  public boolean isEmpty(){
    if(top==null) {
      return true; 
    } else {
      return false;
    } // if
  } // isEmpty()

  public ContentType top(){
    if(this.isEmpty()) {
      return null;
    } else {
      return top.getContent();
    } // if
  } // front()
  
  public void pop(){
    if(!this.isEmpty()){
      top=top.getNext();
    } // if
  } // dequeue()
  
  public void push(ContentType pContent){
    if(pContent!=null) {
      Node<ContentType> newNode=new Node<ContentType>(pContent);
      if(this.isEmpty()){
        top=newNode;
      } else {
        newNode.setNext(top);
        top=newNode;
      } // if(this.isEmpty())
    } // if(content!=null)
      
  } // enqueue()
  
  
} // class
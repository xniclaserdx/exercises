public class Stack<ContentType>{

  private Node<ContentType> top;

  public Stack(){
  top=null;
  } // Konstruktor

  public boolean isEmpty(){
	 if(top==null){
		  return true;
	 }else{
		  return false;
	 }
  } // isEmpty()

  public ContentType top(){
	if(!isEmpty())
		return top.getContent();
    }else{
		return null;
	} // top()
  public void pop(){
    if(!this.isEmpty()){ 
		top=top.getNext();
	} // if
  } // pop()
  
  public void push(ContentType pContent){
  if(pContent!=null)
  Node<ContentType> newNode=new Node<ContentType>(pContent);
	if(!isEmpty()){
	top=newNode;
	}else{
	newNode=top.setNext(top);
	top=newNode;
	}
  } // push()
} // class
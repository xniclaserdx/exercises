public class Stack<ContentType>
{
	private Node<ContentType> top;

	public Stack(){
	    top=null;
	 } 
	 public boolean isEmpty(){
	   return top==null;
	 } 
	 public ContentType top(){
		if(this.isEmpty()){
			  return null;
		}else{
			  return top.getContent();
		} 
	 } 
	 public void pop(){
		if(!this.isEmpty()){
		top=top.getNext();
		} 
	 }
	 public void push(ContentType pContent){
		if(pContent!=null) {
		  Node<ContentType> newNode=new Node<ContentType>(pContent);
			  if(this.isEmpty()){
				 top=newNode;
			  }else{
				 newNode.setNext(top);
			     top=newNode;
			  } // if(this.isEmpty())
		  } // if(content!=null)
	 } // push()
} // class
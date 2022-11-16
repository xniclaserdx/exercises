public class Node<CT>
{
    private CT content=null;
    private Node<CT> nextNode=null;

    public Node(CT pContent, Node<CT>pNext)
    {
        this.content=pContent;
        this.nextNode=pNext;
    }
    public Node(CT pContent){
        this.content=pContent;
        this.nextNode=null;
    }
    public void setNext(Node<CT> pNext){
        this.nextNode=pNext;
    }
    public void setContent(CT pContent){
        this.content=pContent;
    }
    public CT getContent(){
        return this.content;
    }
    public Node<CT> getNext(){
        return this.nextNode;
    }
    }


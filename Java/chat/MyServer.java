public class MyServer extends Server
{
    public MyServer(int pPort)
    {
     super(pPort);
    }
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
       this.sendToAll(pMessage); 
    }
}

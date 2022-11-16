import basis.*;
public class Kommunikation
{
   private MyServer server;
   private MyClient client;
   private MyClient client2;
   public Kommunikation()
   {
      server= new MyServer(10000);
      client= new MyClient("192.168.188.52",10000,"HanSolo420");
      client2= new MyClient("192.168.188.52",10000,"Endor2");
   }
}

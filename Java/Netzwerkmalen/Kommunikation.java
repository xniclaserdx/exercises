public class Kommunikation
{
    private MeinServer x;
    private MeinClient y;
    private MeinClient z;
    public Kommunikation(String client1name,String client1ip, String client2name, String client2ip)
    {
        x=new MeinServer(10000);
        y=new MeinClient(client1ip,10000,client1name);
        y.setPort(x.getClientPort());
        y.setServer(x);
        z=new MeinClient(client2ip,10000,client2name);
        z.setPort(x.getClientPort());
        z.setServer(x);
        x.fuegeClienthinzu(y);
        x.fuegeClienthinzu(z);
    }
    public void neuerClient(String name, String ip){
        MeinClient m=new MeinClient(ip,10000,name);
        m.setPort(x.getClientPort());
        m.setServer(x);
        x.fuegeClienthinzu(m);
    }
}

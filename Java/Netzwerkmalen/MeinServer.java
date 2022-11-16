import basis.*;
public class MeinServer extends Server
{
    private int port;
    private List1<MeinClient> clientList;
    private Fenster f;
    private List1<Stift> stiftList;
    public MeinServer(int pPort)
    {
        super(pPort);
        this.port=pPort;
        clientList=new List1<MeinClient>();
        f=new Fenster("Leinwand",1920,1080);
        stiftList=new List1<Stift>();
        Stift s=new Stift();
        s.maleAuf(f);
        stiftList.append(s);
    }
    public void processMessage(String pClientIP, int pClientPort, String pMessage)
    {
        MeinClient client=findeClient(pClientPort);
        sendToAll(client.getName());
        sendToAll(pMessage);
    }
    public MeinClient findeClient(int pClientPort){
        clientList.toFirst();
        while(clientList.hasAccess()){
            if(pClientPort==clientList.getContent().getPort()){
                return clientList.getContent();
            }
            clientList.next();
        }
        return null;
    }
    public void fuegeClienthinzu(MeinClient pClient){
        clientList.append(pClient);
        Stift x=new Stift();
        x.maleAuf(pClient.getFenster());
        stiftList.append(x);
        System.out.println(x.getMalflaeche());
    }
    public Fenster getFenster(){
        return this.f;
    }
    public void bewegen(double x, double y){
        stiftList.toFirst();
        while(stiftList.hasAccess()){
            stiftList.getContent().hoch();
            stiftList.getContent().bewegeBis(x,y);
            stiftList.next();
        }
    }
    public void malen(double x, double y, String modus, String farbe, int groesse){
        stiftList.toFirst();
        while(stiftList.hasAccess()){
            if(modus=="radieren"){
                stiftList.getContent().radiere();
            }
            else{stiftList.getContent().normal();}
            if(farbe=="schwarz"){stiftList.getContent().setzeFarbe(Farbe.SCHWARZ);}
            if(farbe=="rot"){stiftList.getContent().setzeFarbe(Farbe.ROT);}
            if(farbe=="gruen"){stiftList.getContent().setzeFarbe(Farbe.GRUEN);}
            stiftList.getContent().setzeLinienBreite(groesse);
            stiftList.getContent().runter();
            stiftList.getContent().bewegeBis(x,y);
            stiftList.next();
        }
    }
}

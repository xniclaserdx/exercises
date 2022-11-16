import basis.*;
import java.awt.*;
import java.awt.Color.*;
public class MyClient extends Client implements KnopfLauscher
{
   private TextFeld tf1,tf3;
   private TextBereich tb;
   private BeschriftungsFeld bf,bf2,bf3;
   private Fenster f;
   private Knopf k1,k2;
   private MyServer server;
   private MyClient client;
   private String gespeichert;
   private boolean zeile1;
   private String benutzername;
   public MyClient(String pIP, int pPort, String pNutzername)
   {
    super(pIP, pPort);
    f = new Fenster("Chat",700,500);
    tf1 = new TextFeld(20,40,200,50);
    tb = new TextBereich(20,190,400,250,f.leinwand());
    tb.setzeSchriftFarbe(Color.black);
    tb.setzeEditierbar(false);
    tb.setzeHintergrundFarbe(Color.lightGray);
    benutzername=pNutzername;
    k1 = new Knopf("senden",20,105,200,50);
    k1.setzeKnopfLauscher(this);
    bf = new BeschriftungsFeld("Chatfenster",20,150,200,50);
    bf2 = new BeschriftungsFeld("Eingabe",20,0,200,50);
    bf3 = new BeschriftungsFeld("Benutzername",300,0,200,50);
    tf3 = new TextFeld(300,40,200,50);
    zeile1=true;
    k2 = new Knopf("bestätigen",300,105,200,50);
    k2.setzeKnopfLauscher(this);
  }
  public void processMessage(String pMessage){
       if(zeile1){
        tb.setzeText(pMessage);
        zeile1=false;
    }else{
        tb.fuegeTextAn(pMessage,true);
      }
    }
    public void bearbeiteKnopfDruck(Knopf knopf){ 
     if(knopf==k1){
        this.send(benutzername+": "+tf1.text());
        k1.setzeBenutzbar(false);
        tf1.setzeSchriftFarbe(Color.green);
        tf1.setzeText("gesendet");
        try{Thread.sleep(350);}catch(Exception e){}
        tf1.setzeSchriftFarbe(Color.black);
        tf1.setzeText("");
        k1.setzeBenutzbar(true);
     }
     if(knopf==k2){
        benutzername=tf3.text();
        k2.setzeBenutzbar(false);
        tf3.setzeSchriftFarbe(Color.green);
        tf3.setzeText("erfolgreich geändert");
        try{Thread.sleep(350);}catch(Exception e){}
        tf3.setzeSchriftFarbe(Color.black);
        tf3.setzeText("");
        k2.setzeBenutzbar(true);
        
        }
  }
}
import basis.*;
public class ShopClient extends Client implements KnopfLauscher
{
    private Fenster f;
    private ListBox box,box1;
    private TextBereich tb;
    private TextFeld tf;
    private BeschriftungsFeld bGroesse,bFarbe;
    private Knopf k1,k2,k3,k4;
    public ShopClient(String pServerIP, int pServerPort)
    {
        super(pServerIP, pServerPort);
        f=new Fenster(1500,400);
        
        tb=new TextBereich(800,20,500,200);
        tb.setzeEditierbar(false);
        
        bFarbe=new BeschriftungsFeld("Farbe",30,40,230,40);
        bGroesse=new BeschriftungsFeld("Größe",30,90,230,40);
        
        box1=new ListBox(80,90,230,40);
        box=new ListBox(80,30,230,40);
        
        k3=new Knopf("Senden",400,30,230,40);
        k3.setzeKnopfLauscher(this);
        
        k1=new Knopf("Bestätigen",400,80,230,40);
        k1.setzeKnopfLauscher(this);
        k1.setzeBenutzbar(false);
        
        k2=new Knopf("Abbruch",400,130,230,40);
        k2.setzeKnopfLauscher(this);
        k2.setzeBenutzbar(false);
        
        k4=new Knopf("Abmelden",400,180,230,40);
        k4.setzeKnopfLauscher(this);
        
        box.fuegeAn("Schwarz");
        box.fuegeAn("Weiß");
        box1.fuegeAn("S");
        box1.fuegeAn("M");
        box1.fuegeAn("L");
        box1.fuegeAn("XL");
    }
    public void processMessage(String pMessage)
    {
        if(tb!=null){
            tb.fuegeAn(pMessage+"\n");
        }
        else{
            Hilfe.warte(900);
            tb.fuegeAn(pMessage+"\n");
        }
    }
    void groesseFarbeWaehlen(String pGroesse, String pFarbe)
    {
        send("TSHIRT:"+pGroesse+":"+pFarbe);
        k1.setzeBenutzbar(true);
        k2.setzeBenutzbar(true);
        k3.setzeBenutzbar(false);
    }

    void bestaetige(String pAntwort)
    {
        send("BESTAETIGUNG:"+ pAntwort);
        if(pAntwort=="nein"){
            f.gibFrei();
        }
        else{
            k1.setzeBenutzbar(false);
            k2.setzeBenutzbar(false);
            k3.setzeBenutzbar(false);
        }
    }

    void abmelden(){
        send("ABMELDEN");
        f.gibFrei();
    }
    
    
    public void bearbeiteKnopfDruck(Knopf k){
        if(k==k3){
            groesseFarbeWaehlen(box1.gewaehlterText(),box.gewaehlterText());
        }
        if(k==k1){
            bestaetige("ja");
        }
        if(k==k2){
            bestaetige("nein");
        }
        if(k==k4){
            abmelden( );
        }
    }
}

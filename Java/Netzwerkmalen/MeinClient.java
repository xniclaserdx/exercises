import basis.*;
public class MeinClient extends Client implements MausLauscherStandard, KnopfLauscher
{
    private String modus;
    private String farbe;
    private int port;
    private String name;
    private Fenster f;
    private MeinServer server;
    private Knopf knormal;
    private Knopf kradieren;
    private Knopf kschwarz;
    private Knopf krot;
    private Knopf kgruen;
    private BeschriftungsFeld groesse;
    private Knopf kgroesser;
    private Knopf kkleiner;
    private Knopf kkleiner10;
    private Knopf kgroesser10;

    public MeinClient(String pIP, int pPort, String pName){
        super(pIP,pPort);
        this.name=pName;
        erstelleGUI();
        modus="normal";
        farbe="schwarz";
    }
    public void processMessage(String pMessage){
    
    }
    public void erstelleGUI(){
        f=new Fenster(this.name+" Bild",1920,1080);
        f.setzeMausLauscherStandard(this);
        groesse=new BeschriftungsFeld("5",200,60,50,20);
        knormal=new Knopf("Normalmodus",100,100,100,20);
        knormal.setzeKnopfLauscher(this);
        kradieren=new Knopf("Radiermodus",100,130,100,20);
        kradieren.setzeKnopfLauscher(this);
        kschwarz=new Knopf("Schwarz",100,160,100,20);
        kschwarz.setzeKnopfLauscher(this);
        krot=new Knopf("Rot",100,190,100,20);
        krot.setzeKnopfLauscher(this);
        kgruen=new Knopf("Grün",100,220,100,20);
        kgruen.setzeKnopfLauscher(this);
        kkleiner=new Knopf("-",150,40,50,50);
        kkleiner.setzeKnopfLauscher(this);
        kgroesser=new Knopf("+",220,40,50,50);
        kgroesser.setzeKnopfLauscher(this);
        kkleiner10=new Knopf("-10",50,40,100,50);
        kkleiner10.setzeKnopfLauscher(this);
        kgroesser10=new Knopf("+10",270,40,100,50);
        kgroesser10.setzeKnopfLauscher(this);
    }
    public void bearbeiteKnopfDruck(Knopf e){
        if(e==knormal){modus="normal";}
        if(e==kradieren){modus="radieren";}
        if(e==kschwarz){farbe="schwarz";}
        if(e==krot){farbe="rot";}
        if(e==kgruen){farbe="gruen";}
        if(e==kkleiner && Integer.parseInt(groesse.text())>1){
            int x=Integer.parseInt(groesse.text());
            groesse.setzeText(Integer.toString(x-1));}
        if(e==kgroesser){
            int x=Integer.parseInt(groesse.text());
            groesse.setzeText(Integer.toString(x+1));}
        if(e==kkleiner10 && Integer.parseInt(groesse.text())>10){
            int x=Integer.parseInt(groesse.text());
            groesse.setzeText(Integer.toString(x-10));}
        if(e==kgroesser10){
            int x=Integer.parseInt(groesse.text());
            groesse.setzeText(Integer.toString(x+10));}
    }
    public void setServer(MeinServer x){
        this.server=x;
    }
    public void setPort(int pPort){
        this.port=pPort;
    }
    public int getPort(){
        return this.port;
    }
    public String getName(){
        return this.name;
    }
    public Fenster getFenster(){
        return this.f;
    }
    public void bearbeiteMausGezogen(Object x, int y, int z){
        server.malen(y,z,modus,farbe,Integer.parseInt(groesse.text()));
    }
    public void bearbeiteMausBewegt(Object x, int y, int z){
    }
    public void bearbeiteMausLosRechts(Object x, int y, int z){}
    public void bearbeiteMausLos(Object x, int y, int z){
    }
    public void bearbeiteMausDruckRechts(Object x, int y, int z){}
    public void bearbeiteMausDruck(Object x, int y, int z){
        server.bewegen(y,z);
        server.malen(y,z,modus,farbe,Integer.parseInt(groesse.text()));
    }
}

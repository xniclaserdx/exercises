import basis.*;

public class Wartezimmer implements KnopfLauscher
{ 
    private Fenster f;
    private TextFeld tfVorname;
    private TextFeld tfNachname;
    private TextFeld tfNummer;
    private Knopf kRegistrieren;
    private Knopf kAufrufen;
    private Patient wartezimmer[];
    private int first;
    private int last;
    
    public Wartezimmer()
    {
      f=new Fenster(600,120);
      new BeschriftungsFeld("Vorname:",10,20,100,20);
      tfVorname=new TextFeld(110,20,200,20);
      new BeschriftungsFeld("Nachname:",10,50,100,20);
      tfNachname=new TextFeld(110,50,200,20);
      new BeschriftungsFeld("Nr:",10,80,100,20);
      tfNummer=new TextFeld(110,80,200,20);
      kRegistrieren=new Knopf("registrieren",350,30,100,20);
      kRegistrieren.setzeKnopfLauscher(this);
      kAufrufen =new Knopf("aufrufen",350,60,100,20);
      kAufrufen.setzeKnopfLauscher(this);
      
      wartezimmer=new Patient[30];
      first=-1;
      last=-2;
    } // Konstruktor
    
    public void bearbeiteKnopfDruck(Knopf ereignis){
        if(ereignis==kRegistrieren){
         String vorname=tfVorname.text();
         String nachname=tfNachname.text();
         long kartenid=Long.parseLong(tfNummer.text());
         Patient p = new Patient(vorname,nachname,kartenid);
         if(first>last){
           wartezimmer[0]=p;
           first=0;
           last=0;
         } else {
           last++;
           wartezimmer[last]=p;
         } // if
         tfVorname.setzeText(""); 
         tfNachname.setzeText("");
         tfNummer.setzeText("");
        } // registrieren
        if(ereignis==kAufrufen){

           if(first>last){
              tfVorname.setzeText("kein Patient da"); 
              tfNachname.setzeText("");
              tfNummer.setzeText("");
              
            } else {
              Patient p=wartezimmer[first];
              first++;
              tfVorname.setzeText(p.getVorname()); 
              tfNachname.setzeText(p.getNachname());
              tfNummer.setzeText(Long.toString(p.getNummer()));
            } // if
             
        } // aufrufen      
    } // bearbeiteKnopfDruck()

  
} // class

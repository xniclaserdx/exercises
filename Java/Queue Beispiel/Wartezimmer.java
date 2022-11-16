
import basis.*;
public class Wartezimmer implements KnopfLauscher
{ 
    private Fenster f;
    private TextFeld tfVorname;
    private TextFeld tfNachname;
    private Knopf kRegistrieren;
    private Knopf kAufrufen;
    private Queue<Patient> qwartezimmer;
    
    public Wartezimmer()
    {
      f=new Fenster(600,120);
      new BeschriftungsFeld("Vorname:",10,20,100,20);
      tfVorname=new TextFeld(110,20,200,20);
      new BeschriftungsFeld("Nachname:",10,50,100,20);
      tfNachname=new TextFeld(110,50,200,20);
      kRegistrieren=new Knopf("registrieren",350,30,100,20);
      kRegistrieren.setzeKnopfLauscher(this);
      kAufrufen =new Knopf("aufrufen",350,60,100,20);
      kAufrufen.setzeKnopfLauscher(this);
      qwartezimmer=new Queue<Patient>();
    }
    
    public void bearbeiteKnopfDruck(Knopf ereignis){
        if(ereignis==kRegistrieren){
            String vorname=tfVorname.text();
            String nachname=tfNachname.text();
            Patient p= new Patient(vorname,nachname);
            qwartezimmer.enqueue(p);
            tfVorname.setzeText("");
            tfNachname.setzeText("");
        }
        if(ereignis==kAufrufen){
            if(!qwartezimmer.isEmpty()){
                Patient c=qwartezimmer.front();
                tfVorname.setzeText(c.getVorname());
                tfNachname.setzeText(c.getNachname());
                qwartezimmer.dequeue();
            }else{
                tfVorname.setzeText("");
                tfNachname.setzeText("");
            }
        }
    }
}
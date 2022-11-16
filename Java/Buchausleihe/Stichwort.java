//niclas
public class Stichwort implements ComparableContent<Stichwort>
{
    private String wort;
    private int seite;
    private List<Integer> seiten;
    public Stichwort(String pWort, int pSeite){ 
     wort=pWort;
     seite=pSeite;
     seiten=new List<Integer>();
     seiten.append(new Integer(seite));
    }
    public boolean isEqual(Stichwort s){
     return this.gibWort().compareTo(s.gibWort())==0;
    }
    public boolean isLess(Stichwort s){
     return this.gibWort().compareTo(s.gibWort())>0;
    }
    public boolean isGreater(Stichwort s){
     return this.gibWort().compareTo(s.gibWort())<0;
    }
    public void fuegeSeitenzahlEin(int pSeite){
     if (!istEnthalten(pSeite)){
       Integer seite=new Integer(pSeite);
       seiten.toFirst();
       while(seiten.hasAccess()&&pSeite>seiten.getContent()){
        seiten.next();
       }
       if(!seiten.hasAccess()){
        seiten.append(seite);
       }else{
        seiten.insert(seite);
       }
     }
    }
    public String gibWort(){
     return wort;
    }
    public String toString(){
     String ausgabe=wort+" ";
     seiten.toFirst();
     while (seiten.hasAccess()){
      ausgabe=ausgabe+" "+seiten.getContent();
      seiten.next();
     }
     return ausgabe;   
    }
    public boolean istEnthalten(int pSeitenzahl){
     seiten.toFirst();
     boolean enthalten=false;
     while (seiten.hasAccess()&&!enthalten){
      enthalten=seiten.getContent()==pSeitenzahl;
      seiten.next();  
     }            
     return enthalten;   
    }
}

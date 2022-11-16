
/**
 * In der Beispieldatei wir eine Liste mit Double-Werten angelegt.
 */
public class Beispiel
{
    private List<Double> liste;
    
    public Beispiel()
    {
       System.out.println("Start");
       liste=new List<Double>();
       liste.append(new Double(80));
       liste.append(new Double(82));
       liste.append(new Double(81));
       liste.append(new Double(83));
       liste.append(new Double(82));
       liste.append(new Double(81));
       liste.append(new Double(84));
       
       liste.append(new Double(88));
       liste.append(new Double(89));
       liste.append(new Double(87));
       liste.append(new Double(86));
       liste.append(new Double(86));
       liste.append(new Double(54));
       liste.append(new Double(84));
       
       listeAusgeben(liste);
       double s=listeDurchschnitt(liste);
       
       System.out.println("Durchschnitt: "+s);
       
       System.out.println("Ende");
    } // Konstruktor

  public void listeAusgeben(List<Double> l){
      l.toFirst();
      while(l.hasAccess()){
          Double x=l.getContent();
          System.out.println(x.doubleValue());
          l.next();
      } // while
      
    }  // listeAusgeben()
  
  public double listeDurchschnitt(List<Double> l){
      double schnitt=0;
      double summe=0;
      int anzahl=0;
      l.toFirst();
      while(l.hasAccess()){
          Double x=l.getContent();
          summe=summe+x.doubleValue();
          anzahl++;
          l.next();
      } // while
      schnitt=summe/anzahl;
      return schnitt;
    } // listeDurchschnitt()
   
} // class

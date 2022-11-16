 public class Station
{
   private List<Fahrzeug> liste;
   public Station()
    {
        liste=new List<Fahrzeug>();
        liste.append(new EScooter(10,10,"Modell_1ES"));
        liste.append(new EScooter(20,30,"Modell_3ES"));
        liste.append(new Fahrrad("gut",20,"Modell_2F")); 
        liste.append(new Fahrrad("schlecht",10,"Modell_8F")); 
    }
    int ermittleAnzahl(){
        int anzahl=0;
        liste.toFirst();
        while(liste.hasAccess()){x3sw
            anzahl++;
            liste.next();
        }
        return anzahl;
        }
    int  aktuelleAkkuLaufzeit(){
        int insgesammtlaufzeit=0;
        liste.toFirst();
        while(liste.hasAccess()){
            Fahrzeug f=liste.getContent();
            if(f.getKlasse().equals("EScooter")){
                EScooter es=(EScooter)f;
                insgesammtlaufzeit+=es.getLaufzeit();
            }
            liste.next();
        }
        return insgesammtlaufzeit;
    }
}
